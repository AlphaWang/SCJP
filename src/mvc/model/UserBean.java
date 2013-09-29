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
package mvc.model;

import java.util.Date;

import org.jdesktop.beans.AbstractBean;

public class UserBean extends AbstractBean {
	private String name;
	private String pwd;
	private Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		firePropertyChange("name", this.name, this.name = name);  
		System.out.println("model.name = " + name);
		
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		firePropertyChange("date", this.date, this.date = date);  
		System.out.println("model.date = " + date);
	}
	

	
}
