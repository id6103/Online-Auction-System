<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ page import="java.util.List"%>
<%@ page import="auction.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��������ϵͳ</title>

</head>
<body background="./images/background.jpg">
<h1 align="center">��������ϵͳ</h1>
Welcome to you, <%=session.getAttribute("LOGIN_USER") %> &nbsp;&nbsp;
<a href="logout.do">�˳���¼</a>
<a href="login.do?flag=1">������ҳ</a><br><br>

<form action="queryProduct.do">
    ��ѯ����(��Ʒ����)��<input name="keyword">
    <input type="hidden" name="page" value="1">
    <input type="submit" value="��ѯSearch">
</form>

<%!int pageNum;%>
<%!int totalPage;%>
<%!String keyword;%>



<%
List<ProductVO> arr = (List<ProductVO>)request.getAttribute("QUERYPRODUCT_RES");
Integer o = (Integer) request.getAttribute("PAGE_NUM");//int->Integer
pageNum = o.intValue();
Integer p=(Integer) request.getAttribute("TOTAL_PAGE_NUM");
totalPage = p.intValue();
String keyword=(String)request.getAttribute("KEYWORD");
%>

<%if(arr.size()==0){ %>
<br/>δ��ѯ������������Ʒ��No available products!
<%
}else{
%>
<br>��ѯ���Result��<br><br>
��ǰ��<%=pageNum%>ҳ ��<%=totalPage%>ҳ
<br><br>


<table border=3>
<tr><th>��Ʒ����Product Name</th><th>��Ʒ����Product Description</th><th>�鿴����Detail</th></tr>
<%for (ProductVO vo : arr) {%>
<tr>
	<td><%=vo.getProductName()%></td>
	<td><%=vo.getProductDesc()%></td>
	<td><a href="productDetail.do?productId=<%= vo.getId() %>&action=2">�鿴����Detail</a></td>
</tr>
<%}%>
</table>
<%if(totalPage!=1){ %>
<%if(pageNum==1&totalPage!=1) {%>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=pageNum+1%>">��һҳNext</a>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=totalPage%>">ĩҳLast</a>
<%}
else if(pageNum==totalPage&totalPage!=1){%>
<a href="queryProduct.do?keyword=<%=keyword%>&page=1">��ҳFirst</a>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=pageNum-1%>">��һҳPrevious</a>
<%}
else {%>
<a href="queryProduct.do?keyword=<%=keyword%>&page=1">��ҳFirst</a>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=pageNum-1%>">��һҳPrevious</a>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=pageNum+1%>">��һҳNext</a>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=totalPage%>">ĩҳLast</a>
<%} } }%>

</body>
</html>