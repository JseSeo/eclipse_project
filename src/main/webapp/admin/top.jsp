<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String admin_id = (String)session.getAttribute("adminKey");
	String url = request.getContextPath()+"/admin/";
	String conurl = "${pageContext.request.contextPath}/";
	String requestURI = request.getRequestURI();

	if(admin_id == null) {
		response.sendRedirect("adminLogin.jsp");
	} else if (admin_id != null && requestURI == "/JEIUCapStone/adminLogin.jsp") {
		response.sendRedirect("dashBoard.jsp");
	}

%>
	<nav>
        <a href="<%=url %>userManagement.jsp">사용자 관리</a> | 
        <a href="<%=url %>postManagement.jsp">게시물 관리</a> | 
        <a href="${pageContext.request.contextPath}/logout.do">로그아웃</a>
    </nav>