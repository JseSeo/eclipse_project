<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>
<jsp:useBean id="mDao" class="model.MemberDao" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>사용자 관리</title>
<link rel="stylesheet" type="text/css" href="../css/userManagement.css">
</head>
<body>
<%Vector vResult= mDao.getMemberList();%>
    <h2>사용자 관리</h2>
    <%@ include file="top.jsp"%>
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
        <% 
		for(int i=0; i<vResult.size(); i++){
		MemberDTO member = (MemberDTO)vResult.get(i);
		%>
            <tr>
                <td><%=member.getId()%></td>
                <td><%=member.getUser_id()%></td>
                <td><%=member.getName()%></td>
                <td>
                    <!-- <button class="edit-btn" onclick="location.href='leave.do?id=<%=member.getId()%>'">수정</button> -->
                    <button class="delete-btn" onclick="location.href='${pageContext.request.contextPath}/leave.do?id=<%=member.getId()%>'" >삭제</button>
                </td>
            </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>
