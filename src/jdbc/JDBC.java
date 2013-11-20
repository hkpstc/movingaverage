package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	static String url="jdbc:oracle:thin:@172.16.126.197:1521:tpm";
    static String user="tpm_supplementary";
    static String password="tpm_supplementary";
          
            /**
             * 读取配置
             * @return
             */ 
	       public static Connection ConnectToOralce_TPM(){
	    	   Connection conn=null;
	    	   try {
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	    	    conn= DriverManager.getConnection(url,user,password);	 
	    	   } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	    return conn; 	      
	       }	
	       /**
	        * 现场设置
	        * @return
	        */
	       public static Connection ConnectToOralce_TPM(String url,String user,String password){
	    	   Connection conn=null;
	    	   try {
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	    	    conn= DriverManager.getConnection(url,user,password);	 
	    	   } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	    return conn; 	      
	       }	
	       
	       public static ResultSet ExecuteSQLAndReturnResultSet(Connection conn,String sql) {
	   		PreparedStatement ps;
	   		ResultSet rs=null ;
	   		try {
	   			ps = conn.prepareStatement(sql);
	   			ps.execute();
	   			rs = ps.getResultSet();
	   		} catch (SQLException e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		}
	   		
	   		return rs;

	   	}
}
