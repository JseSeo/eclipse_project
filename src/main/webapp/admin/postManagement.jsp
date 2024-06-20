<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시물 관리</title>
<link rel="stylesheet" type="text/css" href="../css/postManagement.css">
</head>
<body>
    <h2>게시물 관리</h2>
    <nav>
        <a href="dashBoard.jsp">대시보드</a> |
        <a href="userManagement.jsp">사용자 관리</a> |
        <a href="logout.jsp">로그아웃</a>
    </nav>
    <p>여기에서 게시물을 관리하세요.</p>
    <!-- 게시물 목록 테이블 -->
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>제목</th>
                <th>작성자</th>
                <th>동작</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>게시물 제목 예시 1</td>
                <td>작성자 1</td>
                <td>
                    <button class="edit-btn">수정</button>
                    <button class="delete-btn">삭제</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>게시물 제목 예시 2</td>
                <td>작성자 2</td>
                <td>
                    <button class="edit-btn">수정</button>
                    <button class="delete-btn">삭제</button>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>게시물 제목 예시 3</td>
                <td>작성자 3</td>
                <td>
                    <button class="edit-btn">수정</button>
                    <button class="delete-btn">삭제</button>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
