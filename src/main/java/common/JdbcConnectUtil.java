package common;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcConnectUtil {
	private static JdbcConnectUtil mDao;

	private PreparedStatement pstmt;
	private ResultSet rs;
	private int result;

	public static Connection getConnection() {
		String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_capstone?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false";
		String id = "freedb_admin1", pw = "#Gva!C6Kh$cMCgD";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	
	

}
