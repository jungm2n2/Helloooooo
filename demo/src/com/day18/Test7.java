package com.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		
		//파일 복사 프로그램
		//원본파일? c:\\doc\\test.txt
		//대상파일? c:\\doc\\out1.txt
		//복사완료!!
		
		Scanner sc = new Scanner(System.in);
		
		
		int data; //데이터 읽어내는
		
		
		try {
			
			System.out.print("원본파일?");
			String file1 = sc.next();
			
			System.out.println("대상파일?");
			String file2 = sc.next();
			
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			
			
			while((data=fis.read())!=-1) {
				
				fos.write(data); //읽어온 데이터를 fos.write로 내보냄
				fos.flush();
			
			}
			
			fis.close();
			fos.close();
			System.out.println("복사 완료!");
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
