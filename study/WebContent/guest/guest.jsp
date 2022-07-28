<%@page import="com.guest.GuestDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.util.MyPage"%>
<%@page import="com.guest.GuestDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<%

	Connection conn = DBConn.getConnecton();
	GuestDAO dao = new GuestDAO(conn);
	
	MyPage myPage = new MyPage();
	
	//MyPage에서 넘어온 pageNum
	
	String pageNum = request.getParameter("pageNum");
	
	int currentPage = 1;
	
	//처음실행을 검사
	if(pageNum!=null){
		
		currentPage = Integer.parseInt(pageNum);
	}

	
	//전체 데이터 갯수 구하기
	int dataCount = dao.getDataCount();
	
	//하나의 페이지에 보여줄 데이터 갯수
	int numPerPage = 3;
	
	//전체 페이지 갯수
	int totalPage = myPage.getPageCount(numPerPage, dataCount);
	
	//삭제시에 페이지수가 줄었을때 처리
	if(currentPage>totalPage){
		currentPage=totalPage;
		}
	
	//데이터베이스에서 가져올 rownum의 시작과 끝
	int start = (currentPage-1)*numPerPage+1;
	int end = currentPage*numPerPage;
	
	List<GuestDTO> lists = dao.getListData(start, end);
	
	//페이징 처리
	String listUrl = "guest.jsp";
	String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
	
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/guest/data/style.css"/>

<script type="text/javascript" src="<%=cp%>/guest/data/guest.js"></script>
<script type="text/javascript" >


function sendIt() {
	
    f = document.myForm;
    str = f.name.value;
    str = str.trim();
    if(!str) {
        alert("이름을 입력하세요 !!!");
        f.name.focus();
        return;
    }
    f.name.value = str;

    str = f.email.value;
    str = str.trim();
    if(str) {
		if(!isValidEmail(str)) {
            alert("E-Mail을 정확히 입력하세요 !!!");
            f.email.focus();
            return;
		}
    }
    f.email.value = str;

    str = f.content.value;
    str = str.trim();
    if(!str) {
        alert("내용을 입력하세요 !!!");
        f.content.focus();
        return;
    }
     f.content.value = str;
    
    f.action="<%=cp%>/guest/save.jsp";
    f.submit();
}

function deleteIt(num) {
	
	
	if (confirm("위 자료를 삭제하시겠습니까 ?")) {
		location.href="<%=cp%>/guest/delete.jsp?num=" + num;
	}
	
	
}



</script>


</head>

<body>
<br/>&nbsp;<br/>

<table width="560" border="2" cellspacing="0" cellpadding="0" 
borderColor="#D6D4A6" style="margin: auto;">
<tr height="40"> 
<td style="padding-left:20px;">
<b>방 명 록</b>
</td>
</tr>
</table>
<br/>

<form name="myForm" method="post" action="">
  <table width="560" border="0" cellspacing="0" cellpadding="3" style="margin: auto;">

  <tr><td colspan="2" height="3"  bgcolor="#DBDBDB" align="center"></td></tr>

  <tr> 
      <td width="20%" height="30" bgcolor="#EEEEEE" style="padding-left:20px;">작성자</td>
      <td width="80%" style="padding-left:10px;"> 
        <input type="text" name="name" size="35" maxlength="20" class="boxTF"/>
      </td>
  </tr>

   <tr><td colspan="2" height="1"  bgcolor="#DBDBDB"></td></tr>

  <tr> 
      <td width="20%" height="30" bgcolor="#EEEEEE" style="padding-left:20px;">E-Mail</td>
      <td width="80%" style="padding-left:10px;"> 
        <input type="text" name="email" size="35" maxlength="50" class="boxTF" />
	 </td>
  </tr>

   <tr><td colspan="2" height="1"  bgcolor="#DBDBDB"></td></tr>

  <tr> 
      <td width="20%" height="30" bgcolor="#EEEEEE" style="padding-left:20px;">홈페이지</td>
      <td width="80%" style="padding-left:10px;"> 
        <input type="text" name="homepage" size="35" maxlength="50" class="boxTF"/>
	 </td>
  </tr>

   <tr><td colspan="2" height="1"  bgcolor="#DBDBDB"></td></tr>

  <tr> 
      <td width="20%" bgcolor="#EEEEEE" style="padding-left:20px; padding-top:5px;" valign="top">내&nbsp;&nbsp;&nbsp;&nbsp;용</td>
      <td width="80%" valign="top" style="padding-left:10px;"> 
        <textarea name="content" cols="60" rows="7" class="boxTA"></textarea>
      </td>
  </tr>

  <tr><td colspan="2" height="3" bgcolor="#DBDBDB" align="center"></td></tr>

  </table>

  <table width="560" border="0" cellspacing="0" cellpadding="3" style="margin: auto;">
     <tr > 
      <td height="40" align="center" colspan="2">
        <input type="button" value=" 등록하기 " onclick="sendIt()" class="btn1"/>
        <input type="reset"  value=" 다시입력 " onclick="document.myForm.name.focus();" class="btn1"/>
      </td>
    </tr>






<tr>
	<tr height="2">
	<td colspan="2" bgcolor="#cccccc"></td></tr>
	
	<%if (dataCount==0){ %>
	
	<td colspan="2" height="35"  align="center" width="300px" bgcolor="#e6e6e6">
	등록된 자료가 없습니다.</td>
	<%}else{ %>
	
	<%for (GuestDTO dto : lists) {
	dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));%>
	
	<td colspan="" height="10"  align="left" width="300px" bgcolor="#e6e6e6"
	style="padding-left: 5px; ">
	<b>No <%=dto.getNum()%>. <%=dto.getName() %> <%=dto.getEmail() %></b></td>
	
	<% if(dto.getHomepage()==null){%>
	<td colspan="" height="10"  align="right" width="300px" bgcolor="#e6e6e6"
	style="padding-right: 5px"><br/></td>
	<%}else {%>
	<td colspan="" height="10"  align="right" width="300px" bgcolor="#e6e6e6"
	style="padding-right: 5px">
	홈페이지 : <a href="<%=dto.getHomepage() %>" target="_blink" ><%=dto.getHomepage() %></a>
	<%} %>

	<tr><td></td></tr>
	
	<td colspan="" height="10"  align="left" width="300px" bgcolor="#e6e6e6"
	style="padding-left: 5px">
	작성일 :<%=dto.getCreated() %> (<%=dto.getIpAddr() %>)</td>
	<td colspan="" height="10"  align="right" width="300px" bgcolor="#e6e6e6"
	style="padding-right: 5px">
	<a onclick="deleteIt(<%=dto.getNum()%>);">삭제</a>
	
	
<tr>
<td colspan="2" height="auto" style="padding-bottom: 10px; padding-top: 10px;">
<%=dto.getContent()%></td></tr>
<tr height="2">
	<td colspan="2" bgcolor="#cccccc"></td></tr>
<%} %>		
<%} %>
	
	
<tr align="center">
<td colspan="2"><%=pageIndexList %></td>
</table>

	






</form>



</body>
</html>