<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--head 부분 코드는 이 줄 아래에 삽입-->
<link rel="stylesheet" href="./css/styles.css">
<script src="https://kit.fontawesome.com/fff8ef1317.js"	crossorigin="anonymous"></script>
<%@ include file="top.jsp"%>
<!-- </head> -->
<body>
	<main>
		<section class="main-image">
			<img src="https://jeiu.ac.kr/img/main/main_slide_02.png" alt="메인 이미지">
		</section>
		<section class="project-thumbnails">
			<p id="capTitle">캡스톤 프로젝트</p>
			<div class="thumbnails-container">
				<!-- 썸네일들을 감싸는 새로운 컨테이너 --> 
				<div class="thumbnail">
					<img src="media/123.png" alt="썸네일 1">
				</div>
				<div class="thumbnail">
					<img src="media/123.png" alt="썸네일 2">
				</div>
				<div class="thumbnail">
					<img src="media/123.png" alt="썸네일 3">
				</div>
			</div>
			<button class="more-button">더보기</button>
		</section>
	</main>
</body>
<!--<footer> 시작-->
<%@ include file="bottom.jsp"%>