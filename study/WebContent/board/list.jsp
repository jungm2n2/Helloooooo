
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.util.MyPage"%>
<%@page import="com.board.BoardDTO"%>
<%@page import="java.util.List"%>
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
	
	Connection conn = DBConn.getConnecton();
	BoardDAO dao = new BoardDAO(conn);
	
	MyPage myPage = new MyPage();
	
	//MyPage에서 넘어온 pageNum
	
	String pageNum = request.getParameter("pageNum");
	
	int currentPage = 1;
	
	//처음실행을 검사
	if(pageNum!=null){
		
		currentPage = Integer.parseInt(pageNum);
		
	}
	
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
	
	//전체 데이터 갯수 구하기
	int dataCount = dao.getDataCount(searchKey, searchValue);
	
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
	
	List<BoardDTO> lists = dao.getLists(start, end, searchKey, searchValue);
	
	
	//페이징 처리
	
	String param = "";
	if(!searchValue.equals("")){ //검색을 했으면
		param = "?searchKey="+searchKey;
		param+= "&searchValue="+URLEncoder.encode(searchValue,"UTF-8");
		
	}
	
	
	String listUrl = "list.jsp" + param;
	String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
	
	
	//글보기 주소
	
	String articleUrl = cp + "/board/article.jsp";
	
	if(param.equals("")){
		articleUrl +="?pageNum="+currentPage;
		
	}else{
		articleUrl += param+"&pageNum="+currentPage;
	}
	
	DBConn.close();
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게  시  판</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/board/css/style.css"/>
<link rel="stylesheet" type="text/css" href="<%=cp%>/board/css/list.css"/>

<script type="text/javascript">
	function sendIt() {
		
		var f = document.searchForm;
		
		f.action = "<%=cp%>/board/list.jsp";
		f.submit();
	}




</script>

</head>
<body>

<div id="bbsList">

	<div id="bbsList_title">
	게  시  판
	</div>
	
	<div id="bbsList_header">
	
		<div id="leftHeader">
			<form action="" method="post" name="searchForm">
				<select name="searchKey" class="selectField">
					<option value="subject">제목</option>
					<option value="name">작성자</option>
					<option value="content">내용</option>
				</select>
				
				<input type="text" name="searchValue" class="textField"/>
				<input type="button" value=" 검 색 " class="btn2" onclick="sendIt();"/>
			</form>
		
		</div>
		
		<div id="rightHeader">
			<input type="button" value=" 글올리기 " class="btn2"
			onclick="javascript:location.href='<%=cp%>/board/created.jsp';"/>
		</div>
	
	</div>
	
	<div id="bbsList_list">
	
		<div id="title">
		
			<dl>
				<dt class="num">번호</dt>
				<dt class="subject">제목</dt>
				<dt class="name">작성자</dt>
				<dt class="created">작성일</dt>
				<dt class="hitCount">조회수</dt>
			</dl>
		</div>	
		
		
		<div id="lists">
		
		<%for(BoardDTO dto : lists){ %>
			<dl>
				<dd class="num"><%=dto.getNum() %></dd>
				<dd class="subject">
				<a href="<%=articleUrl %>&num=<%=dto.getNum() %>">
				<%=dto.getSubject() %>
				</a>
				</dd>
				<dd class="name"><%=dto.getName() %></dd>
				<dd class="created"><%=dto.getCreated() %></dd>
				<dd class="hitCount"><%=dto.getHitcount() %></dd>
			
			</dl>
		<%} %>
		</div>
		<div id="footer">
			<p>
				<%=pageIndexList %>
			</p>
		
		</div>
	
	
	</div>
	
	
</div>



</body>
</html>