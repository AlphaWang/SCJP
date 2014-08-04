package ch09_thread;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

class User{
	
	
}

 class UserDAO1 {  
	   
	     private Connection conn = null;  
	       
	     public UserDAO1(){  	           
	     }  
	       
	     public void insertUser(User user){  
	           String sql = "";
	           try {
				getConn().prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	           
	         //jdbc 操作  
	     }  
	       
	     public synchronized Connection getConn(){  
	        if (conn == null) {  
	             try {  
	                 Class.forName("com.mysql.jdbc.Driver");  
	                 conn = DriverManager.getConnection("jdbc:mysql://?useUnicode=true&characterEncoding=gbk", "system",  
	                         "oracle");  
	             } catch (Exception ex) {  
	                 ex.printStackTrace();  
	             }  
	         }  
	         return conn;  
	     }  
	 }  
   
 
 
 
 
class UserDAO {  
	
	/**
	 * ThreadLocal可以为每个线程维护自己的变量，对于多线程使用同一对象可以起到管理作用。
	 * 
	 * UserDAO中为每个线程开立一个conn，各线程使用自己的连接执行sql
	 * 否则，多个线程使用同一个conn效率比较低，存在数据共享问题。影响效率
	 */
	private static ThreadLocal<Connection> connThreadLocal = new ThreadLocal<Connection>();  
       
       
     public UserDAO(){  
           
     }  
       
     public void insertUser(User user){
    	 String sql = "";           
         try {
			getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
           
         //jdbc 操作  
     }  
        
     public Connection getConnection(){     
         if (connThreadLocal.get() == null) {    
             Connection conn = getConn();     
             connThreadLocal.set(conn);     
             return conn;     
         }              
         return connThreadLocal.get();     
     }  
   
       
       
    public synchronized  Connection getConn(){  
         try{  
             Class.forName("com.mysql.jdbc.Driver");  
             return DriverManager.getConnection("jdbc:mysql://?useUnicode=true&characterEncoding=gbk", "system",  "oracle");  
         }catch(SQLException e){  
            e.printStackTrace();     
         } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
         return null;  
          
     }  
    
 }  
public class Ch9_6_ThreadLocal implements Runnable{

	 private UserDAO userDAO;  
	       
	     public Ch9_6_ThreadLocal(UserDAO userDAO){  
	         this.userDAO = userDAO;  
	     }  
	       
	     public  void run() {  
	         // TODO Auto-generated method stub  
	         for(int i=0; i<1000; i++){  
	               
	             userDAO.insertUser(new User());  
	         }  
	     }  
	   
	       
	       
	     public static void main(String[] args) {  
	         UserDAO userDAO = new UserDAO();  
	           
	         new Thread(new Ch9_6_ThreadLocal(userDAO)).start();  
	         new Thread(new Ch9_6_ThreadLocal(userDAO)).start();  
	         new Thread(new Ch9_6_ThreadLocal(userDAO)).start();  
	           
	           
	     }  
}