package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import common.JdbcConnectUtil;
import common.DBConnectionMgr;

public class MemberDao {
    private DBConnectionMgr pool;

    public MemberDao() {
        try {
            pool = DBConnectionMgr.getInstance();
        } catch (Exception e) {
            System.out.println("Error !!");
        }
    }

    public boolean loginCheck(String id, String password) {    	
        boolean loginCon = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {   	
            con = pool.getConnection();
            String strQuery = "SELECT user_id, password FROM users WHERE user_id = ? AND password = ?";
            pstmt = con.prepareStatement(strQuery);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            loginCon = rs.next();
            
            System.out.println("Login Check: " + loginCon + " for user ID: " + id);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        } finally {
            JdbcConnectUtil.close(con, pstmt, rs);
        }
        return loginCon;
    }	
	
    public boolean memberInsert(MemberDTO mDTO) {
        boolean flag = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = pool.getConnection();
            String strQuery = "INSERT INTO users VALUES(?,?,?,?)";
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
    
    public boolean adminCheck(String admin_id, String admin_passwd) {
        boolean loginCon = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = pool.getConnection();
            String strQuery = "SELECT admin_id, admin_passwd FROM admin WHERE admin_id = ? AND admin_passwd = ?";
            pstmt = con.prepareStatement(strQuery);
            pstmt.setString(1, admin_id);
            pstmt.setString(2, admin_passwd);
            rs = pstmt.executeQuery();
            loginCon = rs.next();
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        } finally {
            JdbcConnectUtil.close(con, pstmt, rs);
        }
        return loginCon;
    }

    
}

