<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ page import="java.util.List"%>
<%@ page import="auction.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�ҵ�����</title>

</head>
<body background="./images/background.jpg">
<%
Integer o = (Integer)request.getAttribute("ACTION");
int action=o.intValue();
if(action==1){
%>
<h1 align="center">�ҵ�����</h1>
<%
}
else if(action==2){
%>
<h1 align="center">�ҵľ��ۼ�¼</h1>
<%
}
else
{
%>
<h1 align="center">���ĵ�����Ʒ</h1>
<%
}
%>

Welcome to you, <%=session.getAttribute("LOGIN_USER") %> &nbsp;&nbsp;
<a href="logout.do">�˳���¼</a> <a href="login.do?flag=1">������ҳ</a><br><br>

<a href="queryProductByName.do?action=1">�ҵ�����</a>
<a href="showRecord.do">�ҵľ��ۼ�¼</a>
<a href="queryProductByName.do?action=3">���ĵ�����Ʒ</a>
<a href="newProduct.jsp">�µ�����</a>
<br><br>


<br>

<%
List<ProductVO> arr = (List<ProductVO>)request.getAttribute("QUERYPRODUCT_RES");
if(arr.size()==0){
%>
����Ʒ
<%
}
else
{
%>



<table border=3>
<tr><th>��Ʒ����</th><th>��Ʒ����</th><th>����״̬</th><th>�鿴����</th></tr>

<%for (ProductVO vo : arr) {%>
<tr>
	<td><%=vo.getProductName()%></td>
	<td><%=vo.getProductDesc()%></td>
	<%String state="������"; %>
    <%if(vo.getState()==0) state="�ѽ���";%>
	<td><%=state%></td>
	<td><a href="productDetail.do?productId=<%= vo.getId()%>&action=<%= action%>">�鿴����</a></td>
</tr>
<%} }%>
</table>

</body>
</html>