package controller.like;

import model.LikeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/like")
public class LikeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = (String) request.getSession().getAttribute("idKey");
        int projectId = Integer.parseInt(request.getParameter("projectId"));

        if (userId != null) {
            LikeDao likeDao = new LikeDao();
            if (likeDao.isLiked(userId, projectId)) {
                likeDao.unlikeProject(userId, projectId);
            } else {
                likeDao.likeProject(userId, projectId);
            }
        }

        response.sendRedirect("detail.jsp?id=" + projectId);
    }
}
