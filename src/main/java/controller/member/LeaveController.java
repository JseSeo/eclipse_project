package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDao;

@WebServlet("/leave.do")
public class LeaveController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String mem_id = request.getParameter("id");
		try {	 
		 	MemberDao mDao = new MemberDao();	
			 boolean leaveCheck = mDao.leaveMember(mem_id);
			 HttpSession session = request.getSession();
		 if(leaveCheck) {
				session.setAttribute("pro_chk", "okay");
				String redirectPage = request.getContextPath() + "/admin/userManagement.jsp";
		        response.sendRedirect(redirectPage);
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