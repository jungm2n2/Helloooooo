package com.board;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.join.CustomInfo;
import com.util.DBConn;
import com.util.MyPage;

public class BoardServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	
	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
			
		RequestDispatcher rd = req.getRequestDispatcher(url);
		
		rd.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");
		String cp = req.getContextPath();
		String uri = req.getRequestURI(); //study/bbs/created.do
		
		
		Connection conn = DBConn.getConnecton();
		BoardDAO dao = new BoardDAO(conn);
		
		MyPage myPage = new MyPage();
		
		String url;
		
		
		if(uri.indexOf("created.do")!=-1) {
			
			HttpSession session = req.getSession();
			
			CustomInfo info = 
					(CustomInfo)session.getAttribute("customInfo");
			
			
			if(info==null) {
				
				url = "/member/login.jsp";
				forward(req, resp, url);
				return;
			}
			
			url = "/boardTest/created.jsp";
			forward(req, resp, url); 
			
		}else if(uri.indexOf("created_ok.do")!=-1) {
			
			BoardDTO dto = new BoardDTO();
			
			int maxNum = dao.getMaxNum();
			
			dto.setNum(maxNum + 1);
			dto.setSubject(req.getParameter("subject"));
			dto.setName(req.getParameter("name"));
			dto.setEmail(req.getParameter("email"));
			dto.setPwd(req.getParameter("pwd"));
			dto.setContent(req.getParameter("content"));
			dto.setIpAddr(req.getRemoteAddr());
			
			dao.insertData(dto);
			
			url = cp + "/bbs/list.do"; //리다이렉트는 가상의 주소
			resp.sendRedirect(url); //insert update delete session일때 리다이렉트
			
		}else if(uri.indexOf("list.do")!=-1) {
			
			String pageNum = req.getParameter("pageNum");
			
			int currentPage = 1;
			
			if(pageNum!=null) {
				
				currentPage = Integer.parseInt(pageNum);
				
			}
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue==null) {
				searchKey = "subject";
				searchValue = "";
			}else {
				if(req.getMethod().equalsIgnoreCase("GET")) {
					searchValue = URLDecoder.decode(searchValue, "UTF-8");
					
				}
				
			}
			
			int dataCount = dao.getDataCount(searchKey, searchValue);
			
			int numPerPage = 5;
			
			int totalPage = myPage.getPageCount(numPerPage, dataCount);
			
			if(currentPage>totalPage) {
				
				currentPage = totalPage;
			}
			
			int start = (currentPage-1)*numPerPage+1;
			int end = currentPage*numPerPage;
			
			List<BoardDTO> lists = dao.getLists(start, end, searchKey, searchValue);
			
			String param = "";
			if(searchValue!=null && !searchValue.equals("")) {
				
				param = "searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue,"UTF-8");
			}
			
			String listUrl = cp + "/bbs/list.do";
			
			if(!param.equals("")) { //검색을 했으면
				
				listUrl += "?" + param;
				
			}
			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
			
			
			String articleUrl = cp+"/bbs/article.do?pageNum=" + currentPage;
			
			if(!param.equals("")) {
				articleUrl += "&" + param;
			}
			
			//포워딩하면서 넘길 데이터
			
			req.setAttribute("lists", lists);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("articleUrl", articleUrl);
			req.setAttribute("dataCount", dataCount);
			
			
			url = "/boardTest/list.jsp"; //데이터를 가지고 넘어갈 주소
			forward(req, resp, url); //포워드는 실제주소
			
		}else if (uri.indexOf("article.do")!=-1){
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue!=null && !searchValue.equals("")) {
				
				searchValue = URLDecoder.decode(searchValue,"UTF-8");
				
			}
			
			dao.updateHitCount(num);
			
			BoardDTO dto = dao.getReadData(num);
			
			if(dto==null) {
				
				url=cp+"/bbs/list.do";
				resp.sendRedirect(url);
				
			}
			
			int lineSu = dto.getContent().split("\n").length;
			
			dto.setContent(dto.getContent().replaceAll("\r", "<br/>"));
			
			
			String param = "pageNum=" + pageNum;
			
			if(searchValue!=null && !searchValue.equals("")) {
				
				param+="&searchKey="+searchKey;
				param+="&searchValue="+URLEncoder.encode(searchValue,"UTF-8");
				
			}
			
			req.setAttribute("dto", dto);
			req.setAttribute("params", param); //servlet이 내부적으로 param이라는 변수를 가지고 있기때문에 변수이름을 'param'으로 사용할 수 없음
			req.setAttribute("lineSu", lineSu);
			req.setAttribute("pageNum", pageNum);
			
			
			url = "/boardTest/article.jsp"; //데이터를 가지고 넘어갈 주소
			forward(req, resp, url); //포워드는 실제주소
			
			
		}else if(uri.indexOf("updated.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue!=null && !searchValue.equals("")) {
				
				searchValue = URLDecoder.decode(searchValue,"UTF-8");
			}
			
			BoardDTO dto = dao.getReadData(num);
			
			if(dto==null) {
				url = cp +"/bbs/list.do";
				resp.sendRedirect(url);
			}
			
			String param = "pageNum=" + pageNum;
			
			if(searchValue!=null && !searchValue.equals("")) {
				
				param+="&searchKey="+searchKey;
				param+="&searchValue="+URLEncoder.encode(searchValue,"UTF-8");
				
			}
			
			req.setAttribute("dto", dto);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("params", param);
			req.setAttribute("searchKey", searchKey);
			req.setAttribute("searchValue", searchValue);
			
			url = "/boardTest/updated.jsp";
			forward(req, resp, url);
			
			
			}else if (uri.indexOf("updated_ok.do")!=-1){
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue!=null && !searchValue.equals("")) {
				
				searchValue = URLDecoder.decode(searchValue,"UTF-8");
				
			}
			
			BoardDTO dto = new BoardDTO();
			
			dto.setNum(Integer.parseInt(req.getParameter("num")));
			dto.setSubject(req.getParameter("subject"));
			dto.setName(req.getParameter("name"));
			dto.setEmail(req.getParameter("email"));
			dto.setPwd(req.getParameter("pwd"));
			dto.setContent(req.getParameter("content"));
		
			dao.updateData(dto);
			
			String param = "pageNum=" + pageNum;
			
			if(searchValue!=null && !searchValue.equals("")) {
				
				param+="&searchKey="+searchKey;
				param+="&searchValue="+URLEncoder.encode(searchValue,"UTF-8");
			
			
			}
			


			url = cp + "/bbs/list.do?"+param; //리다이렉트는 가상의 주소
			resp.sendRedirect(url); //insert update delete session일때 리다이렉트
			
		}else if(uri.indexOf("deleted_ok.do")!=-1){
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue!=null && !searchValue.equals("")) {
				
				searchValue = URLDecoder.decode(searchValue,"UTF-8");
				
			}
			dao.deletedData(num);
			
			String param = "pageNum=" + pageNum;
			
			if(searchValue!=null && !searchValue.equals("")) {
				
				param+="&searchKey="+searchKey;
				param+="&searchValue="+URLEncoder.encode(searchValue,"UTF-8");
			
			}
			
			
			url = cp + "/bbs/list.do?"+param; //리다이렉트는 가상의 주소
			resp.sendRedirect(url); //insert update delete session일때 리다이렉트
			
		}
		
		
		
	}

}
