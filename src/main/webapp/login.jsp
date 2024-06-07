<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="./css/styles.css">
<%@ include file="top.jsp"%>
<body>
	<div class="login-container">
		<h2>로그인</h2>
		<form action="login.do" method="post">
			<label for="id">아이디:</label> <input type="text" id="id"
				name="id" required> <label for="password">비밀번호:</label>
			<input type="password" id="password" name="password" required>
			<input type="submit" value="로그인">
		</form>
		<a href="register.jsp">회원가입</a>
		<%
		String error = request.getParameter("error");
		if ("1".equals(error)) {
			out.println("<p style='color:red;'>로그인 실패. 아이디와 비밀번호를 확인하세요.</p>");
		}
		%>
	</div>
</body>
<%@ include file="bottom.jsp"%>
