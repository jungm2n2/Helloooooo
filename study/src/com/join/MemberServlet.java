package com.join;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.score.ScoreDTO;
import com.util.DBConn;

public class MemberServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
		
	}
	
	protected void foward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		Connection conn = DBConn.getConnecton();
		MemberDAO dao = new MemberDAO(conn);
		
		String cp = req.getContextPath();
		String uri = req.getRequestURI();
		
		String url;
		
		
		if(uri.indexOf("created.do")!=-1) {
			url = "/member/created.jsp";
			foward(req, resp, url);
			
		}else if (uri.indexOf("created_ok.do")!=-1){
			
			MemberDTO dto = new MemberDTO();
			
			dto.setUserId(req.getParameter("userId"));
			dto.setUserPwd(req.getParameter("userPwd"));
			dto.setUserName(req.getParameter("userName"));
			dto.setUserBirth(req.getParameter("userBirth"));
			dto.setUserTel(req.getParameter("userTel"));
			
			dao.insertData(dto);
			
			url = cp;
			resp.sendRedirect(url);
			
		}else if(uri.indexOf("login.do")!=-1) {
			
			url = "/member/login.jsp";
			foward(req, resp, url);
			
		}else if(uri.indexOf("login_ok.do")!=-1) {
			
			String userId = req.getParameter("userId");
			String userPwd = req.getParameter("userPwd");
			
			MemberDTO dto = dao.getReadData(userId);
			
			//로그인 실패
			if(dto==null||!dto.getUserPwd().equals(userPwd)) {
				
				req.setAttribute("message",
						"아이디 또는 패스워드를 정확히 입력해주세요");
				
				url = "/member/login.jsp";
				foward(req, resp, url);
				
				return;
				
			}
			
			//로그인 성공
			
			//세션에 올릴 데이터 객체
			CustomInfo info = new CustomInfo();
			
			info.setUserId(dto.getUserId());
			info.setUserName(dto.getUserName());
			
			//세션 생성
			HttpSession session = req.getSession();
			
			session.setAttribute("customInfo", info);
			
			url = cp;
			resp.sendRedirect(url);
			
		}else if(uri.indexOf("logout.do")!=-1) {
			
			HttpSession session = req.getSession();
			
			session.removeAttribute("customInfo");
			session.invalidate();
			
			url = cp;
			resp.sendRedirect(url);
			
			
		}else if(uri.indexOf("updated.do")!=-1) {
			
			//String userId = req.getParameter("userId"); 
			
			HttpSession session = req.getSession();
			
			CustomInfo info = 
					(CustomInfo)session.getAttribute("customInfo");
			
			
			MemberDTO dto = dao.getReadData(info.getUserId());
			
			if(dto==null) {
				
				url = cp;
				resp.sendRedirect(url);
			}
			
			req.setAttribute("dto", dto);
			
			url = "/member/updated.jsp";
			foward(req, resp, url);
			
		}else if(uri.indexOf("updated_ok.do")!=-1) {
			
			MemberDTO dto = new MemberDTO();
								
			dto.setUserId(req.getParameter("userId"));
			dto.setUserPwd(req.getParameter("userPwd"));
			dto.setUserName(req.getParameter("userName"));
			dto.setUserBirth(req.getParameter("userBirth"));
			dto.setUserTel(req.getParameter("userTel"));
		
		
			dao.updateData(dto);
			
			url = cp;
			resp.sendRedirect(url);
			
		}else if(uri.indexOf("searchPwd.do")!=-1) {
		
			url = "/member/searchPwd.jsp";
			foward(req, resp, url);
			
		}else if(uri.indexOf("searchPwd_ok.do")!=1){
			
			String userId = req.getParameter("userId");
			String userTel = req.getParameter("userTel");
			
			MemberDTO dto = dao.getReadData(userId);
			
				//로그인 실패
				if(dto==null||!dto.getUserTel().equals(userTel)) {
					
					req.setAttribute("message",
							"회원번호가 존재하지 않습니다");
					
					url = "/member/login.jsp";
					foward(req, resp, url);
					
					return;
				
				}else {
					
					req.setAttribute("message",
							"비밀번호는 ["+ dto.getUserPwd() +"] 입니다");
					
					url = "/member/login.jsp";
					foward(req, resp, url);
					
					return;
					
				}
				
				
		
		}
			
		
	}	
		
		
}	
		
		
		
		
		
		
		
	
	
	
	


