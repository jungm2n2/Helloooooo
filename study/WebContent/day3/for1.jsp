<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//request.setCharacterEncoding("UTF-8"); //포워딩으로 한글을 보낼때는 무조건 깨짐
	String cp = request.getContextPath();
	
	String eng = "test";
	String kor = "테스트";
	
	String han = URLEncoder.encode(kor, "UTF-8"); //포워딩할때는 반드시 인코딩 시키기
%>

<jsp:forward page="for2.jsp">

	<jsp:param value="<%=eng %>" name="eng"/>
	<jsp:param value="<%=han %>" name="kor"/>

</jsp:forward>

