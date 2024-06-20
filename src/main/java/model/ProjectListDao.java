package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
    
    public boolean insertProject(ProjectListDTO pDto) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean result = false;
        try {
     
     
            con = pool.getConnection();
            String query = "insert into board(name, title, team, source, content, yturl, date, file)"
                    + "values(?, ?, ?, ?, ?, ?, now(), ?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, pDto.getName());
            pstmt.setString(2, pDto.getTitle());
            pstmt.setString(3, pDto.getTeam());
            pstmt.setString(4, pDto.getSource());
            pstmt.setString(5, pDto.getContent());
            pstmt.setString(6, pDto.getYturl());
            pstmt.setString(7, pDto.getFile());

           
            int count = pstmt.executeUpdate();
            if (count == 1) result = true;

        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt);
        }
        return result;
    }
	
	public ProjectListDTO getproject(String no) {
		ProjectListDTO project = null;
	    
	    String query = "select * from capstone.board where postid=?";
	    
	    try (Connection con = pool.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(query)) {
	         
	        pstmt.setString(1, no);
	        
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                project = new ProjectListDTO();
	                project.setPostid(rs.getInt("postid"));
	                project.setName(rs.getString("name"));
	                project.setTitle(rs.getString("title"));
	                project.setTeam(rs.getString("team"));
	                project.setSource(rs.getString("source"));
	                project.setContent(rs.getString("content"));
	                project.setYturl(rs.getString("yturl"));
	                project.setDate(rs.getString("date"));
	                project.setFile(Optional.ofNullable(rs.getString("file")).orElse("첨부 파일이 없습니다."));
	                
//	                if (rs.getString("file").equals(null)) {
//	                	project.setFile(rs.getString("첨부 파일이 없습니다."));
//	                } else {
//	                	project.setFile(rs.getString("file"));
//	                }
	                System.out.println(rs.getString("file"));
	            }
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace(); // 자세한 예외 정보를 출력
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
            	project.setName(rs.getString("name"));
                project.setTitle(rs.getString("title"));
                project.setTeam(rs.getString("team"));
                project.setSource(rs.getString("source"));
                project.setContent(rs.getString("content"));
                project.setDate(rs.getString("yturl"));
                project.setDate(rs.getString("date"));
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
	
	public boolean updateProject(ProjectListDTO pDto) {
		Connection con = null;
        PreparedStatement pstmt = null;
        boolean result = false;
        try {
     
     
            con = pool.getConnection();
            String query = "update board set title=?, team=?, source=?, content=?, yturl=?, date=now(), file=? WHERE postid = ?";
            pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, pDto.getTitle());
            pstmt.setString(2, pDto.getTeam());
            pstmt.setString(3, pDto.getSource());
            pstmt.setString(4, pDto.getContent());
            pstmt.setString(5, pDto.getYturl());
            pstmt.setString(6, pDto.getFile());
            pstmt.setInt(7, pDto.getPostid());

           
            int count = pstmt.executeUpdate();
            if (count == 1) result = true;

        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt);
        }
        return result;
    }
	
	public boolean deleteProject(String no, String name) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean result = false;
        
        try {
        	con = pool.getConnection();
            String query = "select * from capstone.board where postid=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, no);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            if(rs.getString("name").equals(name) || "admin".equals(name) ) {
            	query = "delete from board where postid = ?";
            	pstmt = con.prepareStatement(query);
                pstmt.setString(1, no);
                int count = pstmt.executeUpdate();
                if (count == 1) result = true;
            }
        } catch (Exception ex) {
            System.out.println("Exception :" + ex);
        } finally {
            pool.freeConnection(con, pstmt);
        }
        
        
        
        return result;
	}
}
