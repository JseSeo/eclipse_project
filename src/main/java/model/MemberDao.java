package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import common.JdbcConnectUtil;
import common.DBConnectionMgr;

public class MemberDao {
	private static MemberDao mDao;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int result;
	private DBConnectionMgr pool = null;

    public MemberDao() {
        try {
            pool = DBConnectionMgr.getInstance();
        } catch (Exception e) {
            System.out.println("Error !!");
        }
    }
	

public boolean loginCheck(String id, String password) {    	
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginCon = false;
  
        try {   	
        	con = pool.getConnection();
            String strQuery = "select id, password from users where id = ? and password = ?";
            pstmt = con.prepareStatement(strQuery);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            loginCon = rs.next();
            
            System.out.println("Login Check: " + loginCon + " for user ID: " + id);
            
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        } finally {
        	JdbcConnectUtil.close(con, pstmt, null);
        }
        return loginCon;
    }	
	
    public boolean memberInsert(MemberDTO mDTO) {
        PreparedStatement pstmt = null;
        boolean flag = false;
        try {
        	con = pool.getConnection();
            String strQuery = "insert into users values(?,?,?,?)";
            pstmt = con.prepareStatement(strQuery);
            pstmt.setString(1, mDTO.getId());
            pstmt.setString(2, mDTO.getPassword());
            pstmt.setString(3, mDTO.getName());
            pstmt.setString(4, mDTO.getRole());
            int count = pstmt.executeUpdate();
            
            if (count == 1) {
                flag = true;
            }

        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        } finally {
        	JdbcConnectUtil.close(con, pstmt, null);
        }
        return flag;
    }		
	
}
