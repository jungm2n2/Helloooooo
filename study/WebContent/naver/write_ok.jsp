
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

	int result = dao.insertData(dto);
	
	DBConn.close();
	
	if(result!=0){
		response.sendRedirect("list.jsp"); //i u d s 했을때 redirect(시선돌리기.새로운 창 띄우기)
	}


%>


입력오류
