<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, smartProject.*" %>

<jsp:useBean id="postMgr" class="smartProject.PostMgr" />

<html>
<head>
<title>Simple Project Admin</title>
<link href="../style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>

<body bgcolor="#996600" topmargin="100">

    <%@ include file="Top.jsp" %>

    <table width="75%" align="center" bgcolor="#FFFF99">
    <tr> 
    <td align="center" bgcolor="#FFFFCC">
 
        <table width="95%" align="center" bgcolor="#FFFF99" border="1">
        <tr bgcolor="#996600"> 
        <td align="center"><font color="#FFFFFF">이름</font></td>
        <td align="center"><font color="#FFFFFF">날짜</font></td>
        <td align="center"><font color="#FFFFFF">팀원</font></td>
        <td align="center"><font color="#FFFFFF">사용 기술</font></td>
        <td align="center">&nbsp;</font></td>
        <td align="center">&nbsp;</font></td>
        </tr>
        <%
        Vector vResult = postMgr.getPostList();
        if(vResult.size() == 0){
        %>
        <tr> 
        <td align="center" colspan="6">등록된 게시물이 없습니다.</td>
        </tr>
        <%} else {
            for(int i = 0; i < vResult.size(); i++){
            PostBean post = (PostBean)vResult.get(i);
        %>
        <tr> 
        <td align="center"><a href="viewPost.jsp?id=<%=post.getId()%>"><%=post.getName()%></a></td>
        <td align="center"><%=post.getDate()%></td>
        <td align="center"><%=post.getTeam()%></td>
        <td align="center"><%=post.getTechnology()%></td>
        <td align="center"><a href="viewPost.jsp?id=<%=post.getId()%>">상세보기</a></td>
        <td align="center"><a href="deletePost.jsp?id=<%=post.getId()%>" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a></td>
        </tr>
        <%}
        }%>
        </table>
        
    </td>
    </tr>
    </table>

    <%@ include file="Bottom.jsp" %>
    
</body>
</html>
