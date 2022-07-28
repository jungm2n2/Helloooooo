<%@page import="com.guest.GuestDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.util.DBConn"%>
<%@page import="com.util.MyPage"%>
<%@page import="com.guest.GuestDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();

GuestDAO dao = new GuestDAO(DBConn.getConnecton());

MyPage myPage = new MyPage();

List <GuestDTO> lists = null;

int totalDataCount = 0;
              
    totalDataCount = dao.getDataCount();
    
    String pageNum = request.getParameter("pageNum");
    
    int currentPage = 1;
    if(pageNum != null)
  	  currentPage = Integer.parseInt(pageNum);
    
    int numPerPage = 5; // 한페이지에 표시할 게시물 수
    int totalPage = 0;
    
    if(totalDataCount != 0){  //페이징 작업
  	  totalPage = 
  	 	 myPage.getPageCount(numPerPage, totalDataCount);
    }
    
    if(currentPage > totalPage) //데이터 삭제시 페이지 정렬
  	  currentPage = totalPage;
    
    int start = (currentPage - 1) * numPerPage + 1;
    int end = currentPage * numPerPage;
    
    lists = dao.getListData(start, end);
    
    String urlList = cp + "/guest/guest.jsp";
    String pageIndexList = 
  		  myPage.pageIndexList(currentPage, totalPage, urlList);
    
    DBConn.close();
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>

<link rel="stylesheet" href="<%=cp%>/guest/data/style.css" type="text/css">

<script type="text/javascript" src="<%=cp%>/guest/data/guest.js"></script>

<script type="text/javascript">
    function isDelete(num)  {
    	
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
        <input type="text" name="email" size="35" maxlength="50" class="boxTF"/>
	 </td>
  </tr>

   <tr><td colspan="2" height="1"  bgcolor="#DBDBDB"></td></tr>

  <tr> 
      <td width="20%" height="30" bgcolor="#EEEEEE" style="padding-left:20px;">홈페이지</td>
      <td width="80%" style="padding-left:10px;"> 
        <input type="text" name="homepage" size="35" maxlength="50" class="boxTF" value="http://"/>
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
     <tr align="center"> 
      <td height="40">
        <input type="button" value=" 등록하기 " onclick="sendIt()" class="btn1"/>
        <input type="reset"  value=" 다시입력 " onclick="document.myForm.name.focus();" class="btn1"/>
      </td>
    </tr>
  </table>
</form>

<table width="560" border="0" cellpadding="0" cellspacing="0" style="margin: auto;">
  <tr><td height="3" bgcolor="#DBDBDB" align="center"></td></tr>
</table>

<%for(GuestDTO dto : lists) {%>
<table width="560" border="3" cellpadding="0" cellspacing="0" bgcolor="#EEEEEE" style="margin: auto;">
 <tr height="20">
    <td width="50%" style="padding:5px;">
    
<%if(dto.getEmail()==null) {%>
	  <b>No <%=dto.getNum()%>. <%=dto.getName()%></b>
<%}else{%>
      <b>No <%=dto.getNum()%>. <%=dto.getName()%>(<a href="mailto:<%=dto.getEmail()%>"><%=dto.getEmail()%></a>)</b>
<%}%>
    </td>

    <td align="right" style="padding:5px;">
    
<%if(!dto.getHomepage().equals("")) {%>
          홈페이지 : <a href="<%=dto.getHomepage()%>" target="_blank"><%=dto.getHomepage()%></a>
<%
}else{
		  out.print("&nbsp;");
} 
%>
     </td>
  </tr>
  <tr height="20">
    <td style="padding:5px;">
     작성일 : <%=dto.getCreated()%> (<%=dto.getIpAddr()%>)
    </td>
    <td align="right" style="padding:5px;">
       <a href="javascript:isDelete('<%=dto.getNum()%>')">삭제</a>
    </td>
  </tr>
  <tr><td colspan="2" bgcolor="#DBDBDB" height="1"></td></tr>

  <tr>
    <td bgcolor="#ffffff" colspan="2" height="20" valign="top" style="padding:5px;">
      <%=dto.getContent().replaceAll("\r\n", "<br/>") %>
	</td>
  </tr>
  <tr><td colspan="2" bgcolor="#DBDBDB" height="3"></td></tr>

</table>
<%}%>

<% if(totalDataCount == 0) { %>
  <table width="560" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEEEEE" style="margin: auto;">
      <tr align="center" height="50"> 
       <td>
         <b>등록된 자료가 없습니다.</b>
       </td>
     </tr>
  </table>
  <table width="560" border="0" cellpadding="0" cellspacing="0" style="margin: auto;">
  <tr><td colspan="2" bgcolor="#DBDBDB" height="3"></td></tr>
  </table>
  
<%}else{%>
  <table width="560" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="margin: auto;">
      <tr align="center" height="30"> 
       <td>
         <%=pageIndexList%>
       </td>
     </tr>
  </table>
<%} %>

