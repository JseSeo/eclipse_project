<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JEIU 캡스톤 프로젝트 - 작품 등록</title>
    <link rel="stylesheet" href="./css/uploadproject.css">
<%@ include file="top.jsp"%>
<!-- </head> -->
<%if(mem_id == null){%>
	<script>
      alert("회원만 이용할 수 있습니다.");
	  location.href="login.jsp";
    </script>
   	<%}
%>
<body>
    <main style="margin-top: 2%;">
        <section class="upload-section">
            <h1>캡스톤 프로젝트</h1>
            <form id="upoload-form" action="uploadproject.do" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="title">프로젝트 이름</label>
                    <input type="text" id="title" name="title" required>
                </div>
                <div class="form-group">
                    <label for="team">팀원</label>
                    <input type="text" id="team" name="team" required>
                </div>
                <div class="form-group">
                    <label for="source">사용 기술</label>
                    <input type="text" id="source" name="source" required>
                </div>
                <div class="form-group">
                    <label for="content">작품 개요</label>
                    <textarea id="content" name="content" rows="4" required></textarea>
                </div>
                <div class="form-group">
                    <label for="yturl">유튜브 영상 주소</label>
                    <p>https://youtu.be/[?] 혹은 https://www.youtube.com/watch?v=[?]</p>
                    <input type="text" id="yturl" name="yturl">
                </div>
                <div class="form-group">
                    <label for="poster">발표 자료 (포스터)</label>
                    <input type="file" id="file" name="file">
                </div>
                <button type="submit" class="submit-button">등록하기</button>
            </form>
        </section>
    </main>
</body>

<%@ include file="bottom.jsp"%>