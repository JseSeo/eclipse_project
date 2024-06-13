<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, smartProject.*"%>

<jsp:useBean id="orderMgr" class="smartProject.OrderMgr" />
<jsp:useBean id="proMgr" class="smartProject.ProductMgr" />

<html>
<head>
<title>Simple Shopping Mall Admin</title>
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
		<td align="center"><font color="#FFFFFF">주문번호</font></td>
		<td align="center"><font color="#FFFFFF">주문자</font></td>
		<td align="center"><font color="#FFFFFF">제품</font></td>
		<td align="center"><font color="#FFFFFF">주문수량</font></td>
		<td align="center"><font color="#FFFFFF">주문날짜</font></td>
		<td align="center"><font color="#FFFFFF">주문상태</font></td>
		<td>&nbsp;</td>
		</tr>
		<%
		Vector vResult = orderMgr.getOrderList();
		if(vResult.size() ==0){
		%>
		<tr> 
		<td align="center" colspan="7">주문 내역이 없습니다</td>
		</tr>
		<%}else{
			for(int i=0; i< vResult.size(); i++){
			OrderBean order = (OrderBean)vResult.get(i);
			ProductBean product = proMgr.getProduct(order.getProduct_no());
		%>
		<tr> 
		<td align="center"><%=order.getNo()%></td>
		<td align="center"><%=order.getId()%></td>
		<td align="center"><%=product.getName()%></td>
		<td align="center"><%=order.getQuantity()%></td>
		<td align="center"><%=order.getDate()%></td>
		<td align="center">
		<%
		switch(Integer.parseInt(order.getState())){
		case 1 : out.println("접수중");
		break;
		case 2 : out.println("접수");
		break;
		case 3 : out.println("입금확인");
		break;
		case 4 : out.println("배송준비");
		break;
		case 5 : out.println("배송중");
		break;
		default : out.println("완료");
		}%>
		</td>
		<td align="center"><a href="javascript:orderDetail('<%=order.getNo()%>')">상세보기</a></td>
		</tr>
		<%}
		}%>
		</table>
	
	</td>
	</tr>
	</table>
	
	<%@ include file="Bottom.jsp" %>

	<form name="detail" method="post" action="OrderDetail.jsp" >
	<input type="hidden" name="no">
	</form>

</body>
</html>
