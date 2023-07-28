package common;

import java.sql.*;

public class JDBCTemplate {
	
	private static JDBCTemplate instance;
	private static Connection conn;
	private  JDBCTemplate () {		
	}
	public static JDBCTemplate getInstance() {
		if(instance==null) {
			instance = new JDBCTemplate();
			
		}
		return instance;
	}
	public Connection createConnection() {
		String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String ID ="MEMBERWEB";
		String PW = "MEMBERWEB";
				
		try {
			if(conn ==null || conn.isClosed()) {
				Class.forName(DRIVER_NAME);
				conn = DriverManager.getConnection(url,ID,PW);
				conn.setAutoCommit(false);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		}
				
		return conn;
	}
	public void close(Connection conn) {
		if(conn!=null) {
			try {
				if(conn.isClosed()) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void commit(Connection conn) {
		if(conn !=null) {
			try {
			if(conn.isClosed())	conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void rollback(Connection conn) {
		if(conn!=null) {
		try {
        if(conn.isClosed())			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}
}
