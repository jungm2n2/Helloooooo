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
		int data; //������ �о��
		
		
	
			
			System.out.print("��������?");
			String file1 = sc.next();
			
			System.out.println("�������?");
			String file2 = sc.next();
			
			if(ob.fileCopy(file1, file2)) {

				System.out.println("���Ϻ��� ����");
			
			}else {
				System.out.println("���Ϻ��� ����");
				
			}
			
		
		
		

	}

}
