package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBConnectionMgr;

public class CommentDao {
    private DBConnectionMgr pool;

    public CommentDao() {
        try {
            pool = DBConnectionMgr.getInstance();
        } catch (Exception e) {
            System.out.println("Error !!");
        }
    }

    public void addComment(CommentDTO comment) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = pool.getConnection();
            String sql = "INSERT INTO comments (user_id, project_id, content, created_at) VALUES (?, ?, ?, now())";
            ps = con.prepareStatement(sql);
            ps.setString(1, comment.getUserId());
            ps.setInt(2, comment.getProjectId());
            ps.setString(3, comment.getContent());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, ps);
        }
    }

    public List<CommentDTO> getComments(int projectId) {
        List<CommentDTO> comments = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = pool.getConnection();
            String sql = "SELECT * FROM comments WHERE project_id = ? ORDER BY created_at DESC";
            ps = con.prepareStatement(sql);
            ps.setInt(1, projectId);
            rs = ps.executeQuery();
            while (rs.next()) {
                CommentDTO comment = new CommentDTO();
                comment.setId(rs.getInt("id"));
                comment.setUserId(rs.getString("user_id"));
                comment.setProjectId(rs.getInt("project_id"));
                comment.setContent(rs.getString("content"));
                comment.setCreatedAt(rs.getTimestamp("created_at"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con, ps, rs);
        }
        return comments;
    }
}
