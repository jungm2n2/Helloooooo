
<%@page import="java.net.URLDecoder"%>
<%@page import="com.board.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	String pageNum = request.getParameter("pageNum");
	int num = Integer.parseInt(request.getParameter("num"));
	
	
	String searchKey = request.getParameter("searchKey");
	String searchValue = request.getParameter("searchValue");
		

	String param ="";
	if(searchValue!=null && !searchValue.equals("")){
		
		param = "&searchKey="+searchKey;
		param+="&searchValue="+searchValue;
	}
	
	Connection conn = DBConn.getConnecton();
	BoardDAO dao = new BoardDAO(conn);
	
	dao.deletedData(num);
	
	DBConn.close();
	
	response.sendRedirect("list.jsp?pageNum="+pageNum+param);
	
%>
