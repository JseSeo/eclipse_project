package controller.comment;

import model.CommentDao;
import model.CommentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comment")
public class CommentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        String userId = (String) request.getSession().getAttribute("idKey");
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String content = request.getParameter("content");

        if (userId != null && content != null && !content.trim().isEmpty()) {
            CommentDao commentDao = new CommentDao();
            CommentDTO comment = new CommentDTO();
            comment.setUserId(userId);
            comment.setProjectId(projectId);
            comment.setContent(content);
            commentDao.addComment(comment);
        }

        response.sendRedirect("detail.jsp?id=" + projectId);
    }
}
