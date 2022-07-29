
<%@page import="java.util.List"%>
<%@page import="com.util.MyPage"%>

<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이미지 게시판</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/imageTest/data/style.css"/>

<script type="text/javascript" src="<%=cp%>/imageTest/data/image.js"></script>
<script type="text/javascript" >

function sendIt() {
    f = document.myForm;
    
    str = f.subject.value;
    str = str.trim();
    if(!str) {
        alert("제목을 입력하세요 !!!");
        f.subject.focus();
        return;
    }
    f.subject.value = str;

    str = f.upload.value;
    if(!str) {
        alert("이미지 파일을 선택 하세요 !!!");
        f.upload.focus();
        return;
    }
    
    f.action="/study/image/write_ok.do";
    f.submit();
}

</script>


</head>

<body>
<br/>&nbsp;<br/>

<table width="560" border="2" cellspacing="0" cellpadding="0" 
borderColor="#D6D4A6" style="margin: auto;">
<tr height="40"> 
<td style="padding-left:20px;">
<b>이미지 게시판</b>
</td>
</tr>
</table>
<br/>

<form name="myForm" method="post" action="" enctype="multipart/form-data">
  <table width="560" border="0" cellspacing="0" cellpadding="3" style="margin: auto;">

  <tr><td colspan="2" height="3"  bgcolor="#DBDBDB" align="center"></td></tr>

  <tr> 
      <td width="20%" height="30" bgcolor="#EEEEEE" style="padding-left:20px;">제&nbsp;&nbsp;&nbsp;&nbsp;목</td>
      <td width="80%" style="padding-left:10px;"> 
        <input type="text" name="subject" size="60"  class="boxTF"/>
      </td>
  </tr>

   <tr><td colspan="2" height="1"  bgcolor="#DBDBDB"></td></tr>

  <tr> 
      <td width="20%" height="30" bgcolor="#EEEEEE" style="padding-left:20px;">파&nbsp;&nbsp;&nbsp;&nbsp;일</td>
      <td width="80%" style="padding-left:10px;"> 
        <input type="file" name="upload" size="60" class="boxTF" />
	 </td>
  </tr>
<tr><td colspan="2" height="3"  bgcolor="#DBDBDB" align="center"></td></tr>

  </table>

  <table width="560" border="0" cellspacing="0" cellpadding="3" style="margin: auto;">
     <tr > 
      <td height="40" align="center" colspan="2">
        <input type="button" value=" 등록하기 " onclick="sendIt()" class="btn1"/>
        <input type="reset"  value=" 다시입력 " onclick="document.myForm.name.focus();" class="btn1"/>
        <input type="button"  value=" 작성취소 " onclick="location='<%=cp %>';" class="btn1"/>
      </td>
    </tr>
</table>






</form>



</body>
</html>