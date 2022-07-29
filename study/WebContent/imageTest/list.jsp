
<%@page import="java.util.List"%>
<%@page import="com.util.MyPage"%>

<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이미지 게시판</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/imageTest/data/style.css"/>

<script type="text/javascript" src="<%=cp%>/imageTest/data/image.js"></script>
<script type="text/javascript" >

</script>


</head>

<body>
<br/>&nbsp;<br/>


<table width="560" border="2" cellspacing="0" cellpadding="0" 
borderColor="#D6D4A6" style="margin: auto;">
<tr height="40"> 
<td style="padding-left:20px;">
<b>이미지 게시판</b>
</td>
</tr>
</table>
<br/>




<table border="0" style="margin: auto;" >

<tr align="left">
<td  align="left">total 21 articles, 3 pages/Now page is 1</td>

<td  align="right"><input type="button" value="게시물 등록"> </td></tr>


</table>



  <table  width="560" border="0" cellspacing="0" cellpadding="0" style="margin: auto;">

  <tr><td colspan="3" height="3"  bgcolor="#DBDBDB" align="center"></td></tr>



<c:forEach begin="1" end="3" step="1" >

<tr>
<c:forEach begin="1" end="3" step="1" >
<td align="center"><img src="./image/000.jpg" width="180" height="180"><br/>
<a href="<%=cp%>">삭제</a></td>
</c:forEach>

</tr>


</c:forEach>


<tr align="center"><td colspan="3">1 2 3</td></tr>
  
    <tr><td colspan="3" height="3"  bgcolor="#DBDBDB" align="center"></td></tr>
    
</table>










</body>
</html>