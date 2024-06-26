package controller.project;

import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.MemberDao;
import model.ProjectListDTO;
import model.ProjectListDao;

@WebServlet("/uploadproject.do")
public class UploadController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		int fileSize = 5*1024*1024;
		String uploadPath = request.getServletContext().getRealPath("/file");
		System.out.println("uploadpath는? "+uploadPath);
		UUID uuid = UUID.randomUUID();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			
			//파일 이름 초기화
			String fileName  = "";
			
			//파일 이름 가져오기
			Enumeration<String> names = multi.getFileNames();
			
			if(names.hasMoreElements()) {
				String name = names.nextElement();
				fileName = multi.getFilesystemName(name);
			}
			
			HttpSession session = request.getSession();
			String name = (String) session.getAttribute("idKey");
			
			ProjectListDTO pDto = new ProjectListDTO();
			pDto.setName(name);
			pDto.setTitle(multi.getParameter("title"));
			pDto.setTeam(multi.getParameter("team"));
			pDto.setSource(multi.getParameter("source"));
			pDto.setContent(multi.getParameter("content"));
			pDto.setYturl(multi.getParameter("yturl"));
			pDto.setFile(fileName);
			
			ProjectListDao pDao = new ProjectListDao();	
			boolean uploadCheck = pDao.insertProject(pDto);
		
		
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
