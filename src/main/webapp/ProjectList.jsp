<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>
<jsp:useBean id="proDao" class="model.ProjectListDao" />
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/ProjectList.css">
<script language="JavaScript" src="script.js"></script>
<title>작품 보기</title>
<%@ include file="top.jsp"%>
<!-- </head> -->
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
                    <a href="detail.jsp?id=<%=project.getPostid()%>">
                    <h2><%=project.getTitle()%></h2></a>
                    
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
	<form name="detail" method="post" action="detail.jsp" >
	<input type="hidden" name="no">
	</form>
<%@ include file="bottom.jsp"%>