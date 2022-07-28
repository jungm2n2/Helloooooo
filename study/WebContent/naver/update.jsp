
<%@page import="com.naver.NaverDTO"%>
<%@page import="com.score.ScoreDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.naver.NaverDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	String id = request.getParameter("id");
	
	Connection conn = DBConn.getConnecton();

	NaverDAO dao = new NaverDAO(conn);
	

	NaverDTO dto = dao.getReadData(id);
	
	
	
	
	
	
	
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 수정</title>

<script type="text/javascript">
	function goSignUp(){
		
	var f = document.myForm;
		
		f.action = "<%=cp%>/naver/update_ok.jsp";
		f.submit();
	};
	
	function getNumber(){
		
		alert("인증번호 받기");
		
	};
	
	function hello1() {
		var ch = document.myForm;
		
		if(ch.checkid.value==""){
			
			ch.red1.value="필수정보입니다";
			
		}else{
			ch.red1.value="";
		}
	};
	
	function hello2() {
		var ch = document.myForm;
		
		if(ch.checkpw.value==""){
			
			ch.red2.value="필수정보입니다";
			
		}if(ch.checkpw.value!=""){
			ch.red2.value="";
		}
		if((ch.doublecheckid.value)!="" && (ch.doublecheckid.value)!=((ch.checkpw.value))){
			ch.red3.value="비밀번호가 일치하지 않습니다";
		}else{
			ch.red3.value="";
		}
	};
	
	function hello3() {
		var ch = document.myForm;
		
		if(ch.doublecheckid.value==""){
			
			ch.red3.value="필수정보입니다";
			
		}
		if(ch.doublecheckid.value!=""){
			ch.red3.value="";
		}
		if ((ch.doublecheckid.value)!=(ch.checkpw.value)){
			ch.red3.value="비밀번호가 일치하지 않습니다";
		
		}
	};
	
	function hello4() {
		var ch = document.myForm;
		
		if(ch.checkname.value==""){
			
			ch.red4.value="필수정보입니다";
			
		}else{
			ch.red4.value="";
		}
	};
	</script>	

</head>
<body>

<body bgcolor="F5F6f7">

<form action="" name="myForm" method="post">
<center>
<table  bgcolor="#F5F6f7">

<tr><td><div align=center><img src="./image/naver.png" name="img" ></div><td></tr><tr>


<tr>
<td>아이디<br/>
<input type="text" class="box" name="id"
style="background: url('./image/naverdot.jpeg') no-repeat 1px 1px #fff;
border-width: 1px; height:45px;
background-position: right;" size="61" 
value="<%=dto.getId() %>" readonly="readonly"
onblur="hello1();"><br/>


<input type="text" name="red1" class="box" style="background :#F5F6F7;
border:0; color: red;" value="" readonly="readonly"></td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr>
<td>수정할 비밀번호<br/>
<input type="password" class="box" name="pw"
style=" border-width:1px;
 height:45px;" 
value="<%=dto.getPw() %>"
onblur="hello2();" size="61"><br/>
<input type="text" name="red2" class="box" style="background :#F5F6F7;
border:0; color: red;" value="" readonly="readonly"></td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr>
<td>수정할 비밀번호 재확인<br/>
<input type="password" class="box" name="doublecheckid"
style=" border-width:1px;
 height:45px;" onblur="hello3();"
size="61"/><br/>
<input type="text" name="red3" class="box" style="background :#F5F6F7;
border:0; color: red;" value="" readonly="readonly" size="64"></td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr>
<td>이름<br/>
<input type="text" name="name" style="height:45px" 
value="<%=dto.getName() %>" readonly="readonly"
onblur="hello4();" size="61" name="pw"/><br/>
<input type="text" name="red4" class="box" style="background :#F5F6F7;
border:0; color: red;" value="" readonly="readonly"></td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr>
<td>수정할 생년월일<br/>
<input type="text" class="box" name="yearSel"
style=" border-width:1px;
 height:45px;" 
value="<%=dto.getYearSel() %>"
onkeydown="this.style.backgroundImage='';"
 size="17"/>

<select name="monthSel" style="height:50px; width:140px;" onchange="monthCheck();" value="<%=dto.getMonthSel()%>;">
<option value="">월</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>

</select>
<input type="text" class="box" name="daySel"
style=" border-width:1px;
 height:45px;"
value="<%=dto.getDaySel() %>"
onkeydown="this.style.backgroundImage='';"
 size="17"/>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr>
<td>수정할 성별<br/>
<select name="genSel" style="height:50px; width:460px;" value="<%=dto.getGenSel()%>;">
<option value=" ">성별</option>
<option value="남자">남자</option>
<option value="여자">여자</option>
<option value="X">선택안함</option>
</select>
</td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>

<tr>
<td>수정할 본인 확인 이메일
<font size="3" color="#A6A6A6">(선택)</font><br/>
<input type="text" class="box" name="email"
style=" border-width:1px;
 height:45px;"
value="<%=dto.getEmail() %>"
onkeydown="this.style.backgroundImage='';"
 size="60"/>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>

<tr>
	<td>수정할 휴대전화<br/>
<select name="numSel" style="height:50px; width:460px">
<option value="<%=dto.getNumSel()%>">대한민국 +82</option>
<option value="<%=dto.getNumSel()%>">미국/캐나다 +1</option></select><br/><br/>
	
<input type="text" class="box" name="putPhoneNum"
style=" border-width:1px;
 height:45px; margin-right: 10px; float: left; "
value="<%=dto.getPutPhoneNum() %>"
onkeydown="this.style.backgroundImage='';"
 size="43"/>

	<a href="javascript:getNumber();">
	<img src="./image/bring_number.png" ><br/></a><br/><br/>
	
	<input type="text" style="height:45px; background:#F5F6F7; border-width: 1px"
	value="인증번호 입력하세요" size="61" name="pw" readonly="readonly"/></td>
</tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>
<tr><td></td></tr>

<tr>
<td>

<tr align="center">
<td>
<input type="button" class="box" value="수정하기" name="okUp"
style="height:45px; background-color:#03C75A; color: white"  onclick="goSignUp();">

<input  type="button"  class="box" value="수정취소" name="cancleUp"
style="height:45px; background-color:#03C75A; color: white"
onclick="javascript:location.href='<%=cp%>/naver/list.jsp';">
</td>



</tr>

<tr>
<td>
<div align=center>
<a href="https://policy.naver.com/rules/service.html">개인정보처리방침</a>
<a href="https://policy.naver.com/policy/privacy.html">책임의 한계와 법적고지</a>
<a href="https://policy.naver.com/rules/disclaimer.html">회원정보 고객센터</a><br/></div>
</td>
</tr>
<tr><td><div align="center"><img src="./image/end.png"></div></td></tr>

<tr>
<td>

</td>
</tr>

</table>
</center>
</form>

</body>
</html>