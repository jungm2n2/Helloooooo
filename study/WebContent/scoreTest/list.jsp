<%@page import="java.util.ArrayList"%>
<%@page import="com.score.ScoreDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.score.scoreDAO"%>
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
<title>Insert title here</title>

<style type="text/css">

body{

	font-size: 9pt;
}

td{
	font-size: 9pt;
}

.btn{
	font-size: 9pt;
	background: #e6e6e6;

}

</style>


</head>
<body>

<br/>
<br/>

<table width="700" cellpadding="0" cellspacing="3" align="center" bgcolor="#e4e4e4">
<tr height="50">
	<td bgcolor="#ffffff" style="padding-left: 10px;">
	<b>성적처리 리스트 화면</b>
	</td>
</tr>

</table>
<br/>

<table width="650" cellpadding="0" cellspacing="3" align="center">
<tr height="35">
	<td align="right">
	<input type="button" class="btn" value="등록하기"
	onclick="location='<%=cp%>/sung/write.do';"/>
	</td>
</tr>	
</table>





<table width="650" cellpadding="0" cellspacing="1" align="center" bgcolor="#cccccc">

<tr height="30">
	<td align="center" bgcolor="#e6e6e6" width="80">학번</td>
	<td align="center" bgcolor="#e6e6e6" width="80">이름</td>
	<td align="center" bgcolor="#e6e6e6" width="60">국어</td>
	<td align="center" bgcolor="#e6e6e6" width="60">영어</td>
	<td align="center" bgcolor="#e6e6e6" width="60">수학</td>
	<td align="center" bgcolor="#e6e6e6" width="60">총점</td>
	<td align="center" bgcolor="#e6e6e6" width="60">평균</td>
	<td align="center" bgcolor="#e6e6e6" width="60">석차</td>
	<td align="center" bgcolor="#e6e6e6" width="130">수정</td>
</tr>



<c:if test="${!empty lists  }">

<c:forEach var="dto" items="${lists }">
	
	<tr height="30">
		<td align="center" bgcolor="#ffffff">${dto.hak }</td>
		<td align="center" bgcolor="#ffffff">${dto.name }</td>
		<td align="center" bgcolor="#ffffff">${dto.kor }</td>
		<td align="center" bgcolor="#ffffff">${dto.eng }</td>
		<td align="center" bgcolor="#ffffff">${dto.mat }</td>
		<td align="center" bgcolor="#ffffff">${dto.tot }</td>
		<td align="center" bgcolor="#ffffff">${dto.ave }</td>
		<td align="center" bgcolor="#ffffff">${dto.rank }</td>
		<td align="center" bgcolor="#ffffff">
		<a href="<%=cp %>/sung/updated.do?
		hak=${dto.hak}">수정</a> <!-- hak 가져가는 코딩. get방식 -->
		<a href="<%=cp %>/sung/delete_ok.do?hak=${dto.hak}">삭제</a></td>
	</tr>

</c:forEach>
</c:if>

<c:if test="${empty lists }">
<tr><td colspan="9" style="font-size: 15pt;" align="center" bgcolor="#ffffff" >
<b>조회할 학생이 존재하지 않습니다.</b></td></tr>
</c:if>




</table>






</body>
</html>