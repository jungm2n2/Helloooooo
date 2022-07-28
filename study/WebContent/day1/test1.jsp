<%@ page contentType="text/html; charset=UTF-8"%>

<%

	int a=10,b=5,c;
	c=a+b;



%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

합:<%=c %><br/> <!-- 웹의 영역이므로 <%  %> 반드시 필요 -->

<!-- 내장객체를 사용하여 출력. 자바의 영역. 바로 변수 가져와서 사용 가능-->
<%

	out.print("합:" + a+"+"+b+"="+c+"<br/>");
	
	String str = String.format("합:%d+%d=%d",a,b,c);
	out.print(str);


%>


</body>
</html>