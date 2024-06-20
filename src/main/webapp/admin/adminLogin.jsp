<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>관리자 로그인</title>
    <!--head 부분 코드는 이 줄 아래에 삽입-->
    <link rel="stylesheet" type="text/css" href="../css/adminLogin.css">
</head>
<body>
    <h2>Admin Login</h2>
    <form action="loginProcess.jsp" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <button type="submit">Login</button>
    </form>
</body>
</html>
