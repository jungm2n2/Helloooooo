<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	String checkid = request.getParameter("checkid");
	String checkpw = request.getParameter("checkpw");
	String checkname = request.getParameter("checkname");
	String yearSel = request.getParameter("yearSel");
	String monthSel = request.getParameter("monthSel");
	String daySel = request.getParameter("daySel");
	String genSel = request.getParameter("genSel");
	String checkEmail = request.getParameter("checkEmail");
	String numSel = request.getParameter("numSel");
	String putPhoneNum = request.getParameter("putPhoneNum");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>

아이디:<%=checkid %><br/>
비밀번호:<%=checkpw %><br/>
이름:<%=checkname %><br/>
생년월일:<%=yearSel %>년&nbsp;<%=monthSel %>월&nbsp;<%=daySel %>일<br/>
성별:<%=genSel %><br/>
이메일:<%=checkEmail %><br/>
국가번호:<%=numSel %><br/>
전화번호:<%=putPhoneNum %>

</body>
</html>