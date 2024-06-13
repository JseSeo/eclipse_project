package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDao;

@WebServlet("/admin/adminCheck.do")
public class adminCheck extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String admin_id = request.getParameter("admin_id");
		String admin_passwd = request.getParameter("admin_passwd");

		MemberDao mDao = new MemberDao();
		boolean adminCheck = mDao.adminCheck(admin_id, admin_passwd);

		if (adminCheck) {
			HttpSession session = request.getSession();
			session.setAttribute("adminKey", admin_id);
			response.sendRedirect("Index.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter()
					.println("<script>alert('입력한 정보가 정확하지 않습니다.'); location.href='AdminLogin.jsp';</script>");
		}
	}

	
}

