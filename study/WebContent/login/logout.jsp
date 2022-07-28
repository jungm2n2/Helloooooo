<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	session.removeAttribute("userId"); //값인 suzi 삭제.
	session.invalidate(); //userId 변수도 삭제
	
	response.sendRedirect("login2.jsp");
%>
