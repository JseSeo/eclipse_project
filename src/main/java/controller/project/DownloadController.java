package controller.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class DownloadController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 다운로드할 파일 이름 파라미터로 받기
        String fileName = request.getParameter("fileName");
        // 업로드된 파일의 경로 설정
        String uploadPath = getServletContext().getRealPath("/file");
        String filePath = uploadPath + File.separator + fileName;
        
        File downloadFile = new File(filePath);
        if (!downloadFile.exists()) {
            request.setAttribute("errorMessage", "File not found");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }
        
        // 파일 다운로드 설정
        response.setContentType("application/octet-stream");
        response.setContentLength((int) downloadFile.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        // 파일 읽기 및 전송
        try (FileInputStream inStream = new FileInputStream(downloadFile);
             OutputStream outStream = response.getOutputStream()) {
            
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
