
<%@page import="com.naver.NaverDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<jsp:useBean id="dto" class="com.naver.NaverDTO" scope="page"/>
<jsp:setProperty property="*" name="dto"/>

<%

	Connection conn = DBConn.getConnecton();
	NaverDAO dao = new NaverDAO(conn);
	System.out.println(dto);
	int result = dao.updateData(dto);
	
	DBConn.close();
	
	System.out.print(dto.getMonthSel());

	response.sendRedirect(cp + "/naver/list.jsp");

%>
