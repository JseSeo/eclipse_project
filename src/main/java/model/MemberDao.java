package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
    
    public boolean adminCheck(String id, String password, String role) {    	
        boolean loginCon = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {   	
            con = pool.getConnection();
            String strQuery = "SELECT user_id, password, role FROM users WHERE user_id = ? AND password = ? AND role = ?";
            pstmt = con.prepareStatement(strQuery);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
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
            String strQuery = "INSERT INTO users(user_id, password, name) VALUES(?,?,?)";
            pstmt = con.prepareStatement(strQuery);
            pstmt.setString(1, mDTO.getId());
            pstmt.setString(2, mDTO.getPassword());
            pstmt.setString(3, mDTO.getName());
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
    
    public Vector getMemberList() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Vector vProject = new Vector();

        try {
            con = pool.getConnection();
            String query = "select * from users order by id asc";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
            	MemberDTO users = new MemberDTO();
            	users.setId(rs.getString("id"));
            	users.setUser_id(rs.getString("user_id"));
            	users.setName(rs.getString("name"));
                vProject.add(users);
            }
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, stmt, rs);
        }
        return vProject;
    }
    
    public boolean leaveMember(String no) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean result = false;

        try {
            con = pool.getConnection();
            String query = "delete from users where id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, no);
            int count = pstmt.executeUpdate();
            if (count == 1) result = true;
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt);
        }
        return result;
	}
    
}

