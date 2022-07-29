package com.fileTest;

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

public class FileTestServlet extends HttpServlet{

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
		FileTestDAO dao = new FileTestDAO(conn);
		
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
				
				
				FileTestDTO dto = new FileTestDTO();
				
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
			
			List<FileTestDTO> lists = dao.getlists();
			
			String downloadPath = cp + "/file/download.do";
			String deletePath = cp + "/file/deleted.do";
			
			String imagePath = cp +"/pds/saveFile"; //이미지는 실제주소를 써줌
			req.setAttribute("imagePath", imagePath);
			
			
			req.setAttribute("deletePath", deletePath);
			req.setAttribute("downloadPath", downloadPath);
			req.setAttribute("lists", lists);
			
			url = "/fileTest/list.jsp";
			foward(req, resp, url);
			
			
		}else if(uri.indexOf("download.do")!=-1) {
			
			
			int num = Integer.parseInt(req.getParameter("num"));
			
			FileTestDTO dto = dao.getReadData(num);
			
			if(dto==null) {
				return;
			}
			
			boolean flag = 
					FileManager.doFileDownload(resp, dto.getSaveFileName(), 
							dto.getOriginalFileName(), path);
					
			if(flag==false) {
				
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				
				out.print("<script type='text/javascript'>");
				out.print("alert('Download Error');");
				out.print("history.back();");
				out.print("</script>");
				
			}
			
		}else if(uri.indexOf("deleted.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			
			FileTestDTO dto = dao.getReadData(num);
			
			
			//파일 삭제
			FileManager.doFileDelete(dto.getSaveFileName(), path); //실제 물리적 파일 삭제
			
			//DB파일정보삭제
			dao.deleteData(num);
			
			url = cp+"/file/list.do";
			resp.sendRedirect(url);		
			
		}
		
		
		
		
	}
	
	
	
	

}
