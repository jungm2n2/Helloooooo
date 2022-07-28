<%@ page contentType="text/html; charset=UTF-8"%>

<%

	request.setCharacterEncoding("UTF-8"); //꺼내기 전에 인코딩 해주면 post에서도 한글 안깨짐

	String s1 = request.getParameter("su1"); //파라미터값은 무조건 String으로 받음
	String s2 = request.getParameter("su2");
	String name = request.getParameter("name");

	int sum = 0;
	
	int n1 = Integer.parseInt(s1); //int로 변환
	int n2 = Integer.parseInt(s2);
	
	sum = n1+n2;





%>







<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


결과:<%=n1 %>+<%=n2 %>=<%=sum %><br/>
이름:<%=name %><br/>

</body>
</html>