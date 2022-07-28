
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.board.BoardDTO"%>
<%@page import="com.board.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	Enumeration enums = request.getParameterNames();
	 
	 while(enums.hasMoreElements()) {
	 
	  String key = (String)enums.nextElement();
	  String value = request.getParameter(key);
	  out.println(key + " : " + value+"<br>");
	 } 
	
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	
	//검색----------------------------------------------
	
	
	
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue!=null){ //검색을 했을경우
			
			//Get방식은 한글을 인코딩해서 보낸다
			if(request.getMethod().equalsIgnoreCase("GET")){ //포스트방식인지 겟방식인지 알아보는 메소드
				
				searchValue = URLDecoder.decode(searchValue,"UTF-8");
				
			}
			
		}else{
			
			searchKey = "subject";
			searchValue = "";
			
		}
		
		
		
		//검색----------------------------------------------
		
	String param ="";
	if(!searchValue.equals("")){
		
		param = "&searchKey="+searchKey;
		param+="&searchValue="+searchValue;
	}
	
	Connection conn = DBConn.getConnecton();
	BoardDAO dao = new BoardDAO(conn);
	
	BoardDTO dto = dao.getReadData(num);
	
	DBConn.close();
	
	if(dto==null){
		
		response.sendRedirect("list.jsp");
	}
	
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게  시  판</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/board/css/style.css"/>
<link rel="stylesheet" type="text/css" href="<%=cp%>/board/css/created.css"/>

<script type="text/javascript" src="<%=cp%>/board/js/util.js"></script>
<script type="text/javascript">

	function sendIt() {
		
		var f = document.myForm;
		
		str = f.subject.value;
		str = str.trim();
		if(!str){
			alert("\n제목을 입력하세요.")
			f.subject.focus();
			return;
		}
		f.subject.value = str;
		
		
		str = f.name.value;
		str = str.trim();
		if(!str){
			alert("\n이름을 입력하세요.")
			f.name.focus();
			return;
		}
		/*
		if(!isValidKorean(str)){
			
			alert("\n이름을 정확히 입력하세요.")
			f.name.focus();
			return;
		}
		*/
		f.name.value = str;
		
		if(f.email.value){
			if(!isValidEmail(f.email.value)){
				alert("\n정상적인 E-mail을 입력하세요.")
				f.email.focus();
				return;
			}
		
		}
		
		str = f.content.value;
		str = str.trim();
		if(!str){
			alert("\내용을 입력하세요.")
			f.content.focus();
			return;
		}
		f.content.value = str;
		
		str = f.pwd.value;
		str = str.trim();
		if(!str){
			alert("\n패스워드를 입력하세요.")
			f.pwd.focus();
			return;
		}
		
		if(str!="<%=dto.getPwd()%>"){
			
			alert("패스워드가 일치하지 않습니다.")
			f.pwd.focus();
			return;
			
		}
		
		f.action = "<%=cp%>/board/updated_ok.jsp";
		f.submit();
		
	}

</script>


</head>
<body>

<div id="bbs">
	<div id="bbs_title">
	게 시 판
	</div>
	
	<form action="" method="post" name="myForm">
	<div id="bbsCreated">
	
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
				<dd>
					<input type="text" name="subject" size="60"
					maxlength="100" class="boxTF" value="<%=dto.getSubject()%>"/>
				</dd>
			</dl>		
		</div>
		
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>
					<input type="text" name="name" size="35"
					maxlength="20" class="boxTF" value="<%=dto.getName()%>"/>
				</dd>
			</dl>		
		</div>
		
		
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>E-Mail</dt>
				<dd>
					<input type="text" name="email" size="35"
					maxlength="50" class="boxTF" 
					value="<%=dto.getEmail()==null?"":dto.getEmail()%>"/>
				</dd>
			</dl>		
		</div>
		
		<div id="bbsCreated_content">
			<dl>
				<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
				<dd>
					<textarea rows="12" cols="63" name="content" class="boxTA"><%=dto.getContent() %>
					</textarea>
					
				</dd>
			</dl>		
		</div>
		
		<div class="bbsCreated_noLine">
			<dl>
				<dt>패스워드</dt>
				<dd>
					<input type="password" name="pwd" size="35" 
					maxlength="7" class="boxTF"/>&nbsp;(게시물 수정 및 삭제시 필요!!)
				</dd>
			</dl>		
		</div>
		
	</div>
	
	<div id="bbsCreated_footer">
		
		<input type="hidden" name="num" value="<%=dto.getNum()%>"/>
		<input type="hidden" name="pageNum" value="<%=pageNum%>"/>
		<input type="hidden" name="searchKey" value="<%=searchKey%>"/>
		<input type="hidden" name="searchValue" value="<%=searchValue%>"/> 
	
		<input type="button" value="수정하기" class="btn2"
			onclick="sendIt();"/>
		<input type="button" value="수정취소" class="btn2"
			onclick="javascript:location.href='<%=cp%>/board/list.jsp?pageNum=<%=pageNum%><%=param%>';"/>	
	</div>
	
	</form>
	
</div>




</body>
</html>