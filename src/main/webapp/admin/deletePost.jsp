<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, smartProject.*" %>

<jsp:useBean id="postMgr" class="smartProject.PostMgr" />

<html>
<head>
<title>게시물 삭제</title>
<link href="../style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#996600" topmargin="100">

    <%
    String id = request.getParameter("id");
    postMgr.deletePost(id);
    response.sendRedirect("managePosts.jsp");
    %>
    
</body>
</html>
