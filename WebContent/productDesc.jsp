<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ page import="java.util.List"%>
<%@ page import="auction.vo.*"%>
<%@ page import="auction.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>网上拍卖系统</title>
<script language="JavaScript">
function myrefresh()
{
   window.location.reload();
}
setTimeout('myrefresh()',12000);
</script>
</head>
<body background="./images/background.jpg">
<%
ProductVO vo = (ProductVO)request.getAttribute("PRODUCT_DETAIL");
List<RecordVO> arrayRVO = (List<RecordVO>)request.getAttribute("RECORD_DETAIL");
Integer o = (Integer)request.getAttribute("ACTION");
int action=o.intValue();
Integer m = (Integer)request.getAttribute("MAXPRICE");
int maxPrice=m.intValue();
String buyName = (String)request.getAttribute("BUYNAME");

%>

<h1 align="center">网上拍卖系统(商品详情)</h1>
Welcome to you, <%=session.getAttribute("LOGIN_USER") %> &nbsp;&nbsp;
<a href="logout.do">退出登录</a>&nbsp;&nbsp;
<a href="login.do?flag=1">返回首页</a>
<br><br>

<%String state="拍卖中"; %>
<%if(vo.getState()==0) state="已结束";%>

<table border=3>
<tr>
	<th>产品图片</th>
	<th>产品名称</th><th>产品描述</th>
	<th>开始拍卖时间</th><th>结束拍卖时间</th>
	<th>拍卖人姓名</th><th>起拍价</th><th>拍卖状态</th>
	
</tr>
<tr>
    <td><img src="<%=vo.getImg()%>"/></td>
	<td><%=vo.getProductName()%></td>
	<td><%=vo.getProductDesc()%></td>
	<td><%=vo.getStartTime()%></td>
	<td><%=vo.getEndTime()%></td>
	<td><%=vo.getSaleName()%></td>
	<td><%=vo.getStartPrice()%></td>
	<td><%=state%></td>
</tr>
</table>

<br><br>

<%if(arrayRVO.size()==0){ %>
当前无出价记录<br><br>
<%
}else{
%>
<table border=3>
<tr>
	<th>出价时间</th>
	<th>出价人</th>
	<th>价格</th>
</tr>


<%for(RecordVO rvo : arrayRVO) {%>
<tr>
	<td><%=rvo.getTime()%></td>
	<td><%=rvo.getBuyName()%></td>
	<td><%=rvo.getPrice()%></td>
</tr>
<%}%>


</table>
<br><br>

<table border=3>
<tr>
	<th>最高价</th>
	<th>出价人</th>
</tr>
<tr>
	<td><%=maxPrice %></td>
	<td><%=buyName %></td>
</tr>
</table>
<br><br>

<%
}
%>

<%if(action==1&(vo.getState()==1)&vo.getSaleName().equals(session.getAttribute("LOGIN_USER"))){%>
	<form action="endAuction.do">
	<input type="hidden" name="productId" value="<%=vo.getId()%>">
	<input type="submit" value="结束拍卖"> 
	</form>
<% 
}
else if(action==2&&!vo.getSaleName().equals(session.getAttribute("LOGIN_USER"))&&vo.getState()==1){%> 
<form action="submitPrice.do">
<input name="myPrice"> 
<input type="hidden" name="productId" value="<%=vo.getId()%>">
<input type="hidden" name="productName" value="<%=vo.getProductName()%>">
<input type="submit" value="我要出价">
</form>
<% } %>




</body>
</html>