<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String admin_id = (String)session.getAttribute("adminKey");

	if(admin_id == null) {
		response.sendRedirect("AdminLogin.jsp");
	}
%>
<table width="75%" align="center" bgcolor="#FFFF99">
  <tr bgcolor="#FFCC00"> 
    <td align="center"><b><a href="../Index.jsp" target="_blank">사이트 홈 </a></b></td>
     <td align="center"><b><a href="Index.jsp">관리자 홈 </a></b></td>
    <td align="center"><b><a href="AdminLogout.jsp">관리자 로그아웃 </a></b></td>
    <td align="center"><b><a href="MemberMgr.jsp">회원 관리 </a></b></td>
    <td align="center"><b><a href="ProductMgr.jsp">게시물 관리 </a></b></td>
    <td align="center"><b><a href="OrderMgr.jsp">주문 관리</a></b></td>
  </tr>
</table> 