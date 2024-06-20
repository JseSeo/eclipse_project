package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionMgr;

public class LikeDao {
    private DBConnectionMgr pool;

    public LikeDao() {
        try {
            pool = DBConnectionMgr.getInstance();
        } catch (Exception e) {
            System.out.println("Error !!");
        }
    }

    public boolean isLiked(String userId, int projectId) {
        boolean liked = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = pool.getConnection();
            String sql = "SELECT COUNT(*) FROM likes WHERE user_id = ? AND project_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setInt(2, projectId);
            rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                liked = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, ps, rs);
        }
        return liked;
    }

    public void likeProject(String userId, int projectId) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = pool.getConnection();
            String sql = "INSERT INTO likes (user_id, project_id) VALUES (?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setInt(2, projectId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, ps);
        }
    }

    public void unlikeProject(String userId, int projectId) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = pool.getConnection();
            String sql = "DELETE FROM likes WHERE user_id = ? AND project_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setInt(2, projectId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, ps);
        }
    }

    public int getLikeCount(int projectId) {
        int count = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = pool.getConnection();
            String sql = "SELECT COUNT(*) FROM likes WHERE project_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, projectId);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, ps, rs);
        }
        return count;
    }
}
