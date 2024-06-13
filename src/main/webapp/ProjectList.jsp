<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>
<jsp:useBean id="proDao" class="model.ProjectListDao" />
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/ProjectList.css">
<link rel="stylesheet" href="./css/topbot.css">
<script src="https://kit.fontawesome.com/fff8ef1317.js"	crossorigin="anonymous"></script>
<%@ include file="top.jsp"%>
<title>작품 보기</title>
</head>
<body>
<main>
<%Vector vResult= proDao.getProjectList();%>
        <section class="project-detail">
            <h1>캡스톤 프로젝트 상세</h1>
            <% 
		for(int i=0; i<vResult.size(); i++){
		ProjectListDTO project = (ProjectListDTO)vResult.get(i);
		%>
            <div class="project-info">
                <img src="143315.png" alt="프로젝트 이미지">
                <div class="project-details">
                    <h2><%=project.getTitle() %></h2>
                    <p>프로젝트 설명: <%=project.getContent() %></p>
                    <p>팀 구성원: <%=project.getTeam() %></p>
                    <p>완성 날짜: <%=project.getDate() %></p>
                    <p>사용 기술: <%=project.getSource() %></p>
                </div>
            </div>
            <%}%>
        </section>
    </main>

</body>
<%@ include file="bottom.jsp"%>