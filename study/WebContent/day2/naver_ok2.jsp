<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<jsp:useBean id="vo" class="com.calc.NaverVO" scope="page"/>
<jsp:setProperty property="*" name="vo"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>

아이디:<%=vo.getCheckid() %><br/>
비밀번호:<%=vo.getCheckpw() %><br/>
이름:<%=vo.getCheckname() %><br/>
생년월일:<%=vo.getYearSel() %>년&nbsp;<%=vo.getMonthSel() %>월&nbsp;<%=vo.getDaySel() %>일<br/>
성별:<%=vo.getGenSel() %><br/>
이메일:<%=vo.getCheckEmail() %><br/>
국가번호:<%=vo.getNumSel() %><br/>
전화번호:<%=vo.getPutPhoneNum() %>

</body>
</html>