<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="./css/topbot.css">
<script src="https://kit.fontawesome.com/fff8ef1317.js" crossorigin="anonymous"></script>
</head>
<header>
    <div class="header_warp">
        <a href="index.jsp" class="main_logo">JEIU CAPSTONE</a>
    </div>
    <div class="nav_warp">
        <ul class="nav">
            <li><a href="index.jsp">HOME</a></li>
            <li><a href="UploadProject.jsp">작품등록</a></li>
            <li><a href="ProjectList.jsp">작품보기</a></li>
            <li><a href="#">공지사항</a></li>
            <li>
            <%String mem_id = (String)session.getAttribute("idKey");
	    	String log="";
	    	if(mem_id == null){
	    		log ="<a href=login.jsp> LOGIN </a>";
	    	}else {
	    		log ="<a href=logout.do> LOGOUT </a>";
	    	}
	    	%>
            <%=log %> 
            
            </li>
        </ul>
        <a href="#" id="search_icon"><i class="fa-solid fa-magnifying-glass"></i></a>
    </div>
</header>