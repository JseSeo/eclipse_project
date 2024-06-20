package controller.project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProjectListDao;

@WebServlet("/deleteproject.do")
public class DeleteController extends HttpServlet {


	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postid = request.getParameter("id");
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("idKey");
		if (name == null) {
			name = "admin";
		}
		try {	 
		 	ProjectListDao pDao = new ProjectListDao();
			 boolean deleteCheck = pDao.deleteProject(postid, name);
			 if(deleteCheck) {
				session.setAttribute("pro_chk", "okay");
				RequestDispatcher dispatcher = request.getRequestDispatcher("ProjectProc.jsp");
				dispatcher.forward(request, response);
			 } else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ProjectProc.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
}