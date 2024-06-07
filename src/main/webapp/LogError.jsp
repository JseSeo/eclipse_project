<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 오류</title>
    <link rel="stylesheet" href="./css/styles.css">
    <script>
        function showError() {
            alert("로그인 오류: 아이디 또는 비밀번호가 잘못되었습니다.");
            window.location.href = "login.jsp?error=1"; 
        }
    </script>
</head>
<body onload="showError()">
    <div class="login-container">
        <h2>로그인</h2>
        <form action="login.do" method="post">
            <label for="id">아이디:</label>
            <input type="text" id="id" name="id" required>
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" required>
            <input type="submit" value="로그인">
        </form>
        <a href="register.jsp">회원가입</a>
        <% String error = request.getParameter("error");
           if ("1".equals(error)) { %>
            <p style="color:red;">로그인 실패. 아이디와 비밀번호를 확인하세요.</p>
        <% } %>
    </div>
</body>
<%@ include file="top.jsp" %>
<%@ include file="bottom.jsp" %>
