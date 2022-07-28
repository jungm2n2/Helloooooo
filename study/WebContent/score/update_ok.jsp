<%@page import="com.score.scoreDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<jsp:useBean id="dto" class="com.score.ScoreDTO" scope="page"/>
<jsp:setProperty property="*" name="dto"/>

<%

	Connection conn = DBConn.getConnecton();
	scoreDAO dao = new scoreDAO(conn);
	
	int result = dao.updateData(dto);
	
	DBConn.close();
	
	//System.out.print(dto.getKor());

	response.sendRedirect(cp + "/score/list.jsp");

%>
