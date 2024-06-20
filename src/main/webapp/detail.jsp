<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*, model.*"%>
<jsp:useBean id="Dao" class="model.ProjectListDao" />
<jsp:useBean id="likeDao" class="model.LikeDao" />
<jsp:useBean id="commentDao" class="model.CommentDao" />
<html>
<head>
<meta charset="UTF-8">
<title>JEIU 캡스톤 프로젝트 - 프로젝트 보기</title>
<link rel="stylesheet" href="./css/detail.css">
<script language="JavaScript" src="script.js"></script>
<%@ include file="top.jsp"%>
</head>
<body>
    <% 
        ProjectListDTO project = Dao.getproject(request.getParameter("id"));
        String log_user1 = (String) session.getAttribute("idKey"); 
    %>

    <main style="margin-top: 2%;">
        <section class="view-section">
            <h1><%= project.getTitle() %></h1>
            <div class="project-details">
                <div class="author-info">
                    <i class="fas fa-user-circle"></i><%= project.getName() %>
                </div>
                <div class="project-overview">
                    <h2>작품 개요</h2>
                    <%= project.getContent() %>
                </div>
                <div class="project-poster">
                    <h2>발표 자료</h2>
                    <a href="${pageContext.request.contextPath}/download.do?fileName=<%=project.getFile()%>"><%=project.getFile()%></a>
                </div>
                <div class="project-youtube-video">
                    <h2>유튜브 동영상</h2>
                    <iframe width="560" height="315"
                        src="https://www.youtube.com/embed/<%= project.getYturl() %>"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe>
                </div>
                <div class="project-actions">
                    <form action="${pageContext.request.contextPath}/like" method="post" style="display:inline;">
                        <input type="hidden" name="projectId" value="<%= project.getPostid() %>">
                        <button type="submit" class="like-button" style="background: none; border: none; cursor: pointer;">
                            <%
                                boolean isLiked = likeDao.isLiked(log_user1, project.getPostid());
                                int likeCount = likeDao.getLikeCount(project.getPostid());
                            %>
                            <i id="likeIcon" class="<%= isLiked ? "fas" : "far" %> fa-heart"></i>
                            <span id="likeNum"><%= likeCount %></span>개
                        </button>
                    </form>
                    <span>
                        <i class="fas fa-comment"></i>
                        <span id="commentNum"><%= commentDao.getComments(project.getPostid()).size() %></span>개
                    </span>
                    <% 
                        String log_user = (String) session.getAttribute("idKey");
                        String show_btn = "";
                        if (log_user != null && log_user.equals(project.getName())) {
                            show_btn = "<button type=\"button\" class=\"edit\" onclick=\"location.href='UpdateProject.jsp?id=" +
                            project.getPostid() + "'\">수정하기</button>" +
                            "<button type=\"button\" class=\"remove\" onclick=\"location.href='deleteproject.do?id=" +
                            project.getPostid() + "'\">삭제하기</button>";
                        } 
                    %>
                    <%= show_btn %>
                </div>
                <div class="comments-section">
                    <h2>댓글</h2>
                    <form action="${pageContext.request.contextPath}/comment" method="post">
                        <input type="hidden" name="projectId" value="<%= project.getPostid() %>">
                        <textarea name="content" id="commentInput" placeholder="댓글을 입력하세요"></textarea>
                        <button type="submit">댓글 달기</button>
                    </form>
                    <div id="commentsList">
                        <%
                            List<CommentDTO> comments = commentDao.getComments(project.getPostid());
                            for (CommentDTO comment : comments) {
                        %>
                        <div class="comment">
                            <p><strong><%= comment.getUserId() %></strong>: <%= comment.getContent() %></p>
                            <p><small><%= comment.getCreatedAt() %></small></p>
                        </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </section>
    </main>
</body>
<%@ include file="bottom.jsp"%>
