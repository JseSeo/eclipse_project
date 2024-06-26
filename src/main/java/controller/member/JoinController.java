package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDTO;
import model.MemberDao;


@WebServlet("/register.do")
public class JoinController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		
		System.out.println("ID: " + id);
        System.out.println("Password: " + pw);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);

		MemberDTO mDto = new MemberDTO();
		mDto.setId(id);
		mDto.setPassword(pw);
		mDto.setName(name);
		mDto.setRole(role);		
		
		MemberDao mDao = new MemberDao();	
		boolean insertCheck = mDao.memberInsert(mDto);

	    if(insertCheck){
	    	request.setAttribute("joinResult", insertCheck);
			HttpSession session = request.getSession();
			session.setAttribute("idKey", id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		}else{
	    	request.setAttribute("joinResult", 0);
			RequestDispatcher dispatcher = request.getRequestDispatcher("registerFinish.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	

}
