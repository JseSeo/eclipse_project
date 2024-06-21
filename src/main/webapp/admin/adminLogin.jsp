<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>관리자 로그인</title>
    <!--head 부분 코드는 이 줄 아래에 삽입-->
    <link rel="stylesheet" type="text/css" href="../css/adminLogin.css">
</head>
<%	String admin_id = (String)session.getAttribute("adminKey");
	String url = request.getContextPath()+"/admin/";
	String requestURI = request.getRequestURI(); 
	if (admin_id != null) {
		response.sendRedirect("dashBoard.jsp");
	}%>
<body>
    <h2>관리자 로그인</h2>
    <form action="${pageContext.request.contextPath}/login.do" method="post">
        <label for="username">아이디:</label>
        <input type="text" id="id" name="id" required><br><br>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="hidden" id="role" name="role" value="admin">
        <button type="submit">로그인</button>
    </form>
</body>
</html>
