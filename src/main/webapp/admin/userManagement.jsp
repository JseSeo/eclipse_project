<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>사용자 관리</title>
<link rel="stylesheet" type="text/css" href="../css/userManagement.css">
</head>
<body>
    <h2>사용자 관리</h2>
    <nav>
        <a href="dashBoard.jsp">대시보드</a> |
        <a href="postManagement.jsp">게시물 관리</a> |
        <a href="logout.jsp">로그아웃</a>
    </nav>
    <p>여기에서 회원을 관리하세요.</p>
    <!-- 사용자 목록 테이블 -->
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>사용자 이름</th>
                <th>이메일</th>
                <th>동작</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>홍길동</td>
                <td>hong@example.com</td>
                <td>
                    <button class="edit-btn">수정</button>
                    <button class="delete-btn">삭제</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>이몽룡</td>
                <td>lee@example.com</td>
                <td>
                    <button class="edit-btn">수정</button>
                    <button class="delete-btn">삭제</button>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>성춘향</td>
                <td>sung@example.com</td>
                <td>
                    <button class="edit-btn">수정</button>
                    <button class="delete-btn">삭제</button>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
