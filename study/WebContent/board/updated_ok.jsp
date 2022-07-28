<%@page import="java.util.Enumeration"%>
<%@page import="com.board.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<jsp:useBean id="dto" class="com.board.BoardDTO" scope="page"/>
<jsp:setProperty property="*" name="dto"/>


<%
Enumeration enums = request.getParameterNames();

while(enums.hasMoreElements()) {

 String key = (String)enums.nextElement();
 String value = request.getParameter(key);
 out.println(key + " : " + value+"<br>");
} 
	String pageNum = request.getParameter("pageNum");
	
	String searchKey = request.getParameter("searchKey");
	String searchValue = request.getParameter("searchValue");
	
	String param ="";
	if(!searchValue.equals("")){
		
		param = "&searchKey="+searchKey;
		param+="&searchValue="+searchValue;
	}

	Connection conn =  DBConn.getConnecton();
	BoardDAO dao = new BoardDAO(conn);
	
	int result = dao.updateData(dto);
	
	DBConn.close();
	
	response.sendRedirect("list.jsp?pageNum=" + pageNum+param);



%>
dd