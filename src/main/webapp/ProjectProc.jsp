<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="pDao" class="model.ProjectListDao" />
<%
	String chk = (String) session.getAttribute("pro_chk");
	System.out.println(chk);
	
	if("okay".equals(chk)){
		session.removeAttribute("chk");
%>
		<script>
	      alert("처리하였습니다");
		  location.href="ProjectList.jsp";
	    </script>
<%		
	}else{%>
	  <script>
	    alert("오류가 발생하였습니다.");
		location.href="ProjectList.jsp";
	  </script>
<%	}%>