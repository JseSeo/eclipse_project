<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*"%>
<jsp:useBean id="Dao" class="model.ProjectListDao" />
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JEIU 캡스톤 프로젝트 - 작품 등록</title>
    <link rel="stylesheet" href="./css/uploadproject.css">
<%@ include file="top.jsp"%>
<!-- </head> -->
<body>
<%ProjectListDTO project= Dao.getproject(request.getParameter("id"));%>
    <main style="margin-top: 2%;">
        <section class="upload-section">
            <h1>캡스톤 프로젝트</h1>
            <form id="upoload-form" action="updateproject.do" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="title">프로젝트 이름</label>
                    <input type="text" id="title" name="title" value="<%=project.getTitle()%>" required>
                </div>
                <div class="form-group">
                    <label for="team">팀원</label>
                    <input type="text" id="team" name="team" value="<%=project.getTeam()%>" required>
                </div>
                <div class="form-group">
                    <label for="source">사용 기술</label>
                    <input type="text" id="source" name="source" value="<%=project.getSource()%>" required>
                </div>
                <div class="form-group">
                    <label for="content">작품 개요</label>
                    <textarea id="content" name="content" rows="4" required><%=project.getContent()%></textarea>
                </div>
                <div class="form-group">
                    <label for="yturl">유튜브 영상 주소</label>
                    <p>https://youtu.be/[?] 혹은 https://www.youtube.com/watch?v=[?]</p>
                    <input type="text" id="yturl" name="yturl" value="<%=project.getYturl()%>">
                </div>
                <div class="form-group">
                    <label for="poster">발표 자료 (포스터)</label>
                    <input type="file" id="file" name="file">
                </div>
                	<input type="hidden" name="postid" value=<%=project.getPostid()%>>
                <button type="submit" class="submit-button">수정하기</button>
            </form>
        </section>
    </main>
</body>

<%@ include file="bottom.jsp"%>