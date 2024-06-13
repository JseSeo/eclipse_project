package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.DBConnectionMgr;

public class ProjectListDao {
	
	private DBConnectionMgr pool = null;

    public ProjectListDao() {
        try {
            pool = DBConnectionMgr.getInstance();
        } catch (Exception e) {
            System.out.println("Error !!");
        }
    }
	
	
	
	
	public ProjectListDTO getproject(String no) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ProjectListDTO project = null;

        try {
            con = pool.getConnection();
            String query = "select * from board where no=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                project = new ProjectListDTO();
                project.setPostid(rs.getInt("no"));
                project.setTitle(rs.getString("title"));
                project.setTeam(rs.getString("team"));
                project.setContent(rs.getString("content"));
                project.setDate(rs.getString("date"));
                project.setImage(rs.getString("image"));
                project.setFile(rs.getString("file"));
            }
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt, rs);
        }
        return project;

	}
	
	public Vector getProjectList() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Vector vProject = new Vector();

        try {
            con = pool.getConnection();
            String query = "select * from board order by postid desc";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
            	ProjectListDTO project = new ProjectListDTO();
            	project.setPostid(rs.getInt("postid"));
                project.setTitle(rs.getString("title"));
                project.setTeam(rs.getString("team"));
                project.setContent(rs.getString("content"));
                project.setDate(rs.getString("date"));
                project.setImage(rs.getString("image"));
                project.setFile(rs.getString("file"));
                vProject.add(project);
            }
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, stmt, rs);
        }
        return vProject;
    }
}
