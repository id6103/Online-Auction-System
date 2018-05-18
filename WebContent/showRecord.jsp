<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ page import="java.util.List"%>
<%@ page import="auction.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�ҵľ��ۼ�¼My Bidding Records</title>

</head>
<body background="./images/background.jpg">


<h1 align="center">�ҵľ��ۼ�¼My Bidding Records</h1>


Welcome to you, <%=session.getAttribute("LOGIN_USER") %> &nbsp;&nbsp;
<a href="logout.do">�˳���¼Log Out</a> <a href="login.do?flag=1">������ҳMain Page</a><br><br>

<a href="queryProductByName.do?action=1">�ҵ�����My Auction</a>
<a href="showRecord.do">�ҵľ��ۼ�¼My Bidding Records</a>
<a href="queryProductByName.do?action=3">���ĵ�����ƷWhat I have Bought</a>
<a href="newProduct.jsp">�µ�����New Auction</a>
<br><br>


<br>

<%
List<RecordVO> arr = (List<RecordVO>)request.getAttribute("RECORD");
if(arr.size()==0){
%>
�޾��ۼ�¼No existing bidding records
<%
}
else
{
%>



<table border=3>
<tr><th>��Ʒ����Product Name</th><th>�ҵı���My Price</th><th>�鿴����Detail</th></tr>

<%for (RecordVO vo : arr) {%>
<tr>
	<td><%=vo.getProductName()%></td>
	<td><%=vo.getPrice()%></td>
    <%int productId=vo.getProductId();%>
	<td><a href="productDetail.do?productId=<%= vo.getProductId()%>&action=2">�鿴����Detail</a></td>
</tr>
<%} }%>
</table>

</body>
</html>