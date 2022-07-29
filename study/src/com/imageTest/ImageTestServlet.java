package com.imageTest;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.DBConn;
import com.util.FileManager;

public class ImageTestServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doPost(req, resp);
		
		
	}
	
	protected void foward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
		
	RequestDispatcher rd =req.getRequestDispatcher(url);
	
	rd.forward(req, resp);
		
		
	}
	
	@Override
	public void destroy() {
		
		DBConn.close();
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		Connection conn = DBConn.getConnecton();
		ImageTestDAO dao = new ImageTestDAO(conn);
		
		String cp = req.getContextPath();
		String uri = req.getRequestURI();
		String url;
		
		//파일 저장 경로 설정
		String root = getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "saveFile";
		
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		
		if(uri.indexOf("write.do")!=-1) {
			
			url = "/fileTest/write.jsp";
			foward(req, resp, url);
			
		
		}else if(uri.indexOf("write_ok.do")!=-1) {
			
			String encType = "UTF-8";
			int maxSize = 10*1024*1024; //10메가
			
			MultipartRequest mr = 
					new MultipartRequest(req,path,maxSize,encType,new DefaultFileRenamePolicy());
			
			if(mr.getFile("upload")!=null) {
				
				
				ImageTestDTO dto = new ImageTestDTO();
				
				int maxNum = dao.getMaxNum();
				
				dto.setNum(maxNum+1);
				dto.setSubject(mr.getParameter("subject"));
				dto.setSaveFileName(mr.getFilesystemName("upload"));
				dto.setOriginalFileName(mr.getOriginalFileName("upload"));
				
				dao.insertData(dto);
			}
				
			url = cp + "/file/list.do";
			resp.sendRedirect(url);
			
		}else if(uri.indexOf("list.do")!=-1) {
			
			List<ImageTestDTO> lists = dao.getlists(1, 3);
			
			
			String deletePath = cp + "/file/deleted.do";
			
			String imagePath = cp +"/pds/saveFile"; //이미지는 실제주소를 써줌
			req.setAttribute("imagePath", imagePath);
			
			
			req.setAttribute("deletePath", deletePath);
			req.setAttribute("lists", lists);
			
			url = "/fileTest/list.jsp";
			foward(req, resp, url);
			
			
		}else if(uri.indexOf("deleted.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			
			ImageTestDTO dto = dao.getReadData(num);
			
			
			//파일 삭제
			FileManager.doFileDelete(dto.getSaveFileName(), path); //실제 물리적 파일 삭제
			
			//DB파일정보삭제
			dao.deleteData(num);
			
			url = cp+"/file/list.do";
			resp.sendRedirect(url);		
			
		}
		
		
		
		
	}
	
	
	
	

}