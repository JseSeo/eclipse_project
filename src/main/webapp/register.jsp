<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<link rel="stylesheet" href="./css/styles.css">
<%@ include file="top.jsp"%>
<body>
	<div class="register-container">
		<h2>회원가입</h2>
		<form action="register.do" method="post">
			<label for="id">아이디:</label>
			<input type="text" id="id" name="id" required>
			
			<label for="password">비밀번호:</label>
			<input type="password" id="password" name="password" required>
			
			<label for="name">이름:</label>
			<input type="text" id="name" name="name" required>
			
			<label for="role">권한:</label>
			<select id="role" name="role" required>
				<option value="user">일반회원</option>
				<option value="admin">관리자</option>
			</select>
			<input type="submit" value="회원가입">
		</form>
		<%
		String error = request.getParameter("error");
		if ("1".equals(error)) {
			out.println("<p style='color:red;'>회원가입 실패. 다시 시도하세요.</p>");
		}
		%>
	</div>
</body>
<%@ include file="bottom.jsp"%>
