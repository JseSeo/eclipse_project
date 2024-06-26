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

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String admin = request.getParameter("role");

		MemberDao mDao = new MemberDao();
		boolean loginCheck = false;
		boolean adminCheck = false;
		
		

		if (admin != null) {	
			adminCheck = mDao.adminCheck(id, pw, admin);
			if(adminCheck){
		    	request.setAttribute("loginResult", adminCheck);
				HttpSession session = request.getSession();
				session.setAttribute("adminKey", id);
				String redirectPage = request.getContextPath() + "/admin/dashBoard.jsp";
		        response.sendRedirect(redirectPage);

			}else{
			      response.sendRedirect("LogError.jsp");
			}
			
		} else {
			loginCheck = mDao.loginCheck(id, pw);
			if(loginCheck){
		    	request.setAttribute("loginResult", loginCheck);
				HttpSession session = request.getSession();
				session.setAttribute("idKey", id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);

			}else{
			      response.sendRedirect("LogError.jsp");
			}
		}
		
		

	}

	
}
