package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class FileManager {
	
	
	//���� �ٿ�ε�
	public static boolean doFileDownload(HttpServletResponse response,
			String saveFileName, String originalFileName, String path) {
		//������ Ŭ���̾�Ʈ���� �����ִϱ� response, ��ġ�� path, 
		
		try {
			
			// path = D:\java\work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\study\pds\saveFile
			String fullPath = path + File.separator + saveFileName;
			
			if(originalFileName==null || originalFileName.equals("")) {
				
				originalFileName = saveFileName;
			}
			//�ѱ������̸� ���� ����
			originalFileName =
					new String(originalFileName.getBytes("euc-kr"),"ISO-8859-1");
			
			File f = new File(fullPath);
			
			if(!f.exists()) {
				return false;
			}
			
			//���� �ٿ�ε�
			
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
	
	
	
	
	//���ϻ���
	
	public static void doFileDelete(String fileName, String path) {
		
		try {
			
			String filePath = path + File.separator + fileName;
			
			File f = new File(filePath);
			
			if(f.exists()) {
				f.delete(); //DB�� �ƴ� ���� ���� ����
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}

}
