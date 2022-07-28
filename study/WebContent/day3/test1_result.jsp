<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	String name = request.getParameter("name");
	String msg =(String)request.getAttribute("msg"); //수동으로 넣은 데이터(setAttribute).
	//getAttribute로 받을때는 다운캐스팅
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

리다이렉트 또는 포워딩 한 페이지<br/>



<%=name %>:<%=msg %> <!-- 널값이 나옴. 넘어오는 데이터는 버리고 초기화 하기때문.
리다이렉트는 값을 받아오는 코딩 보다 자체 코딩을 쓸때 많이 사용 -->


</body>
</html>