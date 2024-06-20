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
		try {	 
		 	ProjectListDao pDao = new ProjectListDao();	
			 boolean uploadCheck = pDao.deleteProject(postid);
			 HttpSession session = request.getSession();
		 if(uploadCheck) {
				session.setAttribute("pro_chk", "okay");
				RequestDispatcher dispatcher = request.getRequestDispatcher("ProjectProc.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ProjectProc.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
}