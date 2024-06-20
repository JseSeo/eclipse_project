<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*"%>
<jsp:useBean id="Dao" class="model.ProjectListDao" />
<html>
<head>
<meta charset="UTF-8">
<title>JEIU 캡스톤 프로젝트 - 프로젝트 보기</title>
<link rel="stylesheet" href="./css/detail.css">
<script language="JavaScript" src="script.js"></script>
<%@ include file="top.jsp"%>
<!-- </head> -->
<body>
	<%ProjectListDTO project= Dao.getproject(request.getParameter("id"));
	System.out.println("작성자"+project.getName());
	String log_user1 = (String)session.getAttribute("idKey");
	System.out.println("로그인"+log_user1);%>
	
	<main style="margin-top: 2%;">
		<section class="view-section">
			<h1><%=project.getTitle()%></h1>
			<div class="project-details">
				<div class="author-info">
					<i class="fas fa-user-circle"></i><%=project.getName()%>
				</div>
				<div class="project-overview">
					<h2>작품 개요</h2>
					<%=project.getContent()%>
				</div>
				<div class="project-poster">
					<h2>발표 자료</h2>
					
					<%=project.getFile()%>
				</div>
				<div class="project-youtube-video">
					<h2>유튜브 동영상</h2>
					<iframe width="560" height="315"
						src="https://www.youtube.com/embed/<%=project.getYturl()%>"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
				</div>
				<div class="project-actions">
					<span id="likeCount"><i id="likeIcon" class="far fa-heart"></i>
						<span id="likeNum">0</span>개</span> <span><i
						class="fas fa-comment"></i> <span id="commentNum">0</span>개</span>
					<%String log_user = (String)session.getAttribute("idKey");
					String show_btn = "";
					if (log_user != null && log_user.equals(project.getName())){
					show_btn = "<button type=\"button\" onclick=\"location.href=\'UpdateProject.jsp?id="+
					+project.getPostid()
					+"\'\">수정하기</button>"
							
					+"<button type=\"button\" onclick=\"location.href=\'deleteproject.do?id="
					+project.getPostid()
					+"\'\">삭제하기</button>";	
					
					System.out.println("작성자 본인");
					}%>
						
					<%=show_btn%>
				</div>
				<div class="comments-section">
					<h2>댓글</h2>
					<textarea id="commentInput" placeholder="댓글을 입력하세요"></textarea>
					<button id="submitComment">댓글 달기</button>
			
					<div id="commentsList">
						<!-- 댓글 리스트가 여기 표시됩니다. -->
					</div>
				</div>
			</div>
		</section>
	</main>



</body>
<%@ include file="bottom.jsp"%>