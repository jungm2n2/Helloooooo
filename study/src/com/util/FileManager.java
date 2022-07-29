package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class FileManager {
	
	
	//파일 다운로드
	public static boolean doFileDownload(HttpServletResponse response,
			String saveFileName, String originalFileName, String path) {
		//서버가 클라이언트한테 보내주니까 response, 위치는 path, 
		
		try {
			
			// path = D:\java\work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\study\pds\saveFile
			String fullPath = path + File.separator + saveFileName;
			
			if(originalFileName==null || originalFileName.equals("")) {
				
				originalFileName = saveFileName;
			}
			//한글파일이름 깨짐 방지
			originalFileName =
					new String(originalFileName.getBytes("euc-kr"),"ISO-8859-1");
			
			File f = new File(fullPath);
			
			if(!f.exists()) {
				return false;
			}
			
			//파일 다운로드
			
			response.setContentType("application/octet-stream");
			
			response.setHeader("Content-disposition",
					"attachment;fileName="+originalFileName);
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
			
			OutputStream out = response.getOutputStream();
			
			int data;
			byte[] bytes = new byte[4096];
			while((data=bis.read(bytes, 0, 4096))!=-1) {
				
				out.write(bytes,0,data);
				
			}
			
			out.flush();
			out.close();
			bis.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		return true;
		
	}
	
	
	
	
	//파일삭제
	
	public static void doFileDelete(String fileName, String path) {
		
		try {
			
			String filePath = path + File.separator + fileName;
			
			File f = new File(filePath);
			
			if(f.exists()) {
				f.delete(); //DB가 아닌 실제 파일 삭제
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}

}
