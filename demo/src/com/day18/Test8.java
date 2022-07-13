package com.day18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test8 {
	
	public boolean fileCopy(String str1, String str2) {
		
		File f = new File(str1);
		
		if(!f.exists()) {
			return false;
		}
		
		try {
			
			
			FileInputStream fis = new FileInputStream(str1);
			FileOutputStream fos = new FileOutputStream(str2);
			
			int data;
			byte[] buffer = new byte[1024];
			
			while((data=fis.read(buffer, 0, 1024))!=-1) {
				fos.write(buffer, 0, data);
				
			}
			fos.close();
			fis.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
	
	return true;
	
	}
	

	public static void main(String[] args) {
		
		
		Test8 ob = new Test8();
		
		Scanner sc = new Scanner(System.in);
		int data; //데이터 읽어내는
		
		
	
			
			System.out.print("원본파일?");
			String file1 = sc.next();
			
			System.out.println("대상파일?");
			String file2 = sc.next();
			
			if(ob.fileCopy(file1, file2)) {

				System.out.println("파일복사 성공");
			
			}else {
				System.out.println("파일복사 실패");
				
			}
			
		
		
		

	}

}
