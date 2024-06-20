<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>
<jsp:useBean id="proDao" class="model.ProjectListDao" />
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시물 관리</title>
<link rel="stylesheet" type="text/css" href="../css/postManagement.css">
</head>
<body>
<%Vector vResult= proDao.getProjectList();%>
    <h2>게시물 관리</h2>
    <%@ include file="top.jsp"%>
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
        <% 
		for(int i=0; i<vResult.size(); i++){
		ProjectListDTO project = (ProjectListDTO)vResult.get(i);
		%>
            <tr>
                <td><%=project.getPostid()%></td>
                <td><%=project.getTitle()%></td>
                <td><%=project.getName()%></td>
                <td>
                    <button class="edit-btn" onclick="window.open('${pageContext.request.contextPath}/detail.jsp?id=<%=project.getPostid()%>')">글 확인</button>
                    <button class="delete-btn" onclick="location.href='${pageContext.request.contextPath}/deleteproject.do?id=<%=project.getPostid()%>'">삭제</button>
                </td>
            </tr>
            <%} %>
        </tbody>
    </table>
</body>
</html>
