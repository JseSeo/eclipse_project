<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, smartProject.*" %>

<jsp:useBean id="postMgr" class="smartProject.PostMgr" />

<html>
<head>
<title>게시물 상세보기</title>
<link href="../style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#996600" topmargin="100">

    <%@ include file="Top.jsp" %>

    <%
    String id = request.getParameter("id");
    PostBean post = postMgr.getPost(id);
    %>

    <table width="75%" align="center" bgcolor="#FFFF99">
    <tr> 
    <td align="center" bgcolor="#FFFFCC">

        <table width="95%" align="center" bgcolor="#FFFF99" border="1">
        <tr bgcolor="#996600"> 
        <td align="center"><font color="#FFFFFF">이름</font></td>
        <td align="center"><font color="#FFFFFF">날짜</font></td>
        <td align="center"><font color="#FFFFFF">팀원</font></td>
        <td align="center"><font color="#FFFFFF">사용 기술</font></td>
        </tr>
        <tr> 
        <td align="center"><%=post.getName()%></td>
        <td align="center"><%=post.getDate()%></td>
        <td align="center"><%=post.getTeam()%></td>
        <td align="center"><%=post.getTechnology()%></td>
        </tr>
        </table>

        <p><a href="managePosts.jsp">목록으로 돌아가기</a></p>
        
    </td>
    </tr>
    </table>

    <%@ include file="Bottom.jsp" %>
    
</body>
</html>
