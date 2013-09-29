//
/////////////////////////////////////////////////////////////////
//                 C O P Y R I G H T  (c) 2013
//             A G F A - G E V A E R T  G R O U P
//                    All Rights Reserved
/////////////////////////////////////////////////////////////////
//
//       THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
//                    Agfa-Gevaert Group
//      The copyright notice above does not evidence any
//     actual or intended publication of such source code.
//
/////////////////////////////////////////////////////////////////
//
//


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.logging.Logger;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.AccountExpiredException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class PasswordExpirationLoginModule implements LoginModule {
	
	private static final Logger log = Logger.getLogger(PasswordExpirationLoginModule.class);

	private final class PasswordDao extends LoginModuleDAO {
		private final String userName;
		Timestamp expireDate;
		Timestamp createDate;

		private PasswordDao(String userName) {
			super(dsJndiName);
			this.userName = userName;
		}

		@Override
		public void innerRun(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException,
				LoginException {
				ps = conn.prepareStatement(passwordQuery);
				ps.setString(1, userName);
				rs = ps.executeQuery();
				if (rs.next()) {
					expireDate = rs.getTimestamp("date_of_expiration");
					createDate = rs.getTimestamp("date_of_creation");
				}
		}
	}

	private final class SettingDAO<T> extends LoginModuleDAO {
		
		private final String query;
		private T data;
		private final Class<T> type;

		private SettingDAO(String query, Class<T> type) {
			super(dsJndiName);
			this.query = query;
			this.type = type;
		}

		@Override
		public void innerRun(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException,
				LoginException {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				if(type==Integer.class) {
					data = (T) Integer.valueOf(rs.getInt(1));
				}else if(type==Boolean.class) {
					data = (T) Boolean.valueOf(rs.getBoolean(1));
				}else if(type==Timestamp.class) {
					data = (T) rs.getTimestamp(1);
				}else {
					data = (T) rs.getObject(1);
				}

			}
		}
		
		public T getResult() {
			return data;
		}
	}
	
	/**
	 * Flag to allow ignore "about to expire" checking 
	 */
	public static final String IGNORE_EXPIRED = "ignore_expired";
	
	//mili seconds in a day
	private static final long timeADay = 86400000L;
	
	private String dsJndiName;
	
	//get pw creation date and expiration date
	private String passwordQuery;
	
	private String checkEnabledQuery;
	private String checkFirstLoginQuery;
	private String notifyPeriodQuery;
	private String passAgeQuery;
	
	private CallbackHandler callbackHandler;
	
	private CallbackHelper helper = new CallbackHelper();

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map sharedState,
			Map options) {
		this.callbackHandler = callbackHandler;
		
		dsJndiName = (String) options.get("dsJndiName");
		
		passwordQuery = (String) options.get("passwordQuery");
		checkEnabledQuery = (String) options.get("checkEnabledQuery");
		checkFirstLoginQuery = (String) options.get("checkFirstLoginQuery");
		notifyPeriodQuery = (String) options.get("notifyPeriodQuery");
		passAgeQuery = (String) options.get("passAgeQuery");
	}

	@Override
	public boolean login() throws LoginException {
		if(log.isDebugEnabled()) {
			log.debug("do expire check");
		}
		
		final String userName =  helper.getUsername(callbackHandler);
		
		PasswordDao dao = new PasswordDao(userName);
		dao.run();
		
		if(isCheckFirstLoginEnabled()) {
			if(dao.expireDate!=null && dao.expireDate.equals(dao.createDate)) {
				throw new FirstLoginException();
			}
		}
		
		if(isCheckEnabled()) {
			long passAge = getPassAge() * timeADay;
			
			SettingDAO<Timestamp> timeDao = 
				new SettingDAO<Timestamp>("select systimestamp from dual", Timestamp.class);
			timeDao.run();
			Timestamp now = timeDao.getResult();
			
			if(dao.expireDate!=null) {
				log.warn("expiration date has been set for current password.");
				long time = dao.expireDate.getTime() - dao.createDate.getTime();
				
				if(time>0) {
					passAge = Math.min(passAge, time);
				}
			}
			
			long currentAge = now.getTime() - dao.createDate.getTime();
			if(currentAge >= passAge) {
				throw new AccountExpiredException();
			}
			
			//ignore about to expire
			Boolean isIgnore = (Boolean)(SecurityContextAssociation.getSecurityContext().getData().get(IGNORE_EXPIRED));
			if(isIgnore!=null && isIgnore) {
				return false;
			}
			long notifiPeriod = getNotifyPeriod() * timeADay;
			if(currentAge >= passAge - notifiPeriod) {
				long time = passAge -currentAge;
				int day = (int)(time / timeADay + (time % timeADay==0 ? 0 : 1));
				throw new AccountToExpireException(day);
			}
		}
		
		return false;
	}

	private boolean isCheckFirstLoginEnabled() throws LoginException {
		SettingDAO<Boolean> dao = new SettingDAO(checkFirstLoginQuery, Boolean.class);
		dao.run();
		Boolean result = dao.getResult();
		
		return result;
	}

	private int getNotifyPeriod() throws LoginException{
		SettingDAO<Integer> dao = new SettingDAO(notifyPeriodQuery, Integer.class);
		dao.run();
		Integer data = dao.getResult();
		
		if(data==null) {
			log.warn("setting for notify period is not found, use hardcode value 14");
			return 14;
		}
		
		return data;
	}

	private int getPassAge() throws LoginException {
		SettingDAO<Integer> dao = new SettingDAO(passAgeQuery, Integer.class);
		dao.run();
		Integer data = dao.getResult();
		
		if(data==null) {
			log.warn("setting for password expired age is not found, use hardcode value 42");
			return 42;
		}
		
		return data;
	}

	private boolean isCheckEnabled() throws LoginException{
		SettingDAO<Boolean> dao = new SettingDAO(checkEnabledQuery, Boolean.class);
		dao.run();
		Boolean result = dao.getResult();
		
		return result;
	}
	

	@Override
	public boolean commit() throws LoginException {
		return false;
	}

	@Override
	public boolean abort() throws LoginException {
		return false;
	}

	@Override
	public boolean logout() throws LoginException {
		return false;
	}

}
