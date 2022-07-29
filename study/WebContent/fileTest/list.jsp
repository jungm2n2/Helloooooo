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
<title>파일 리스트</title>
</head>
<body>

<table width="600" align="center" border="1" cellpadding="0" cellspacing="0">
<tr>
	<td align="right" colspan="4">
	<input type="button" value="파일업로드"
	onclick="location='<%=cp%>/file/write.do';">
	</td>

</tr>	

<tr>
	<td align="center" width="50">번호</td>
	<td align="left" width="150">제목</td>
	<td align="left" width="250">파일명</td>
	<td align="center" width="50">삭제</td>
</tr>

<c:forEach var="dto" items="${lists }">

<tr>
	<td align="center" width="50">${dto.num }</td>
	<td align="left" width="150">${dto.subject }</td>
	<td align="left" width="250">
	<!-- <a href="${downloadPath}?num=${dto.num }">${dto.originalFileName }</a> -->
	
	<img src="${imagePath }/${dto.saveFileName}" width="180" height="180"/>
	
	</td>
	<td align="center" width="50">
	<a href="${deletePath }?num=${dto.num }">삭제</a></td>
</tr>
</c:forEach>


</table>


</body>
</html>