package com.day18;

import java.io.File;
import java.io.IOException;
import java.util.Date;

//File
//파일 및 폴더를 관리할 수 있는 기능을 제공하는 클래스
//파일 내용을 입출력, 수정, 삭제하기 위한 메소드는 없다(filelnput/fileOutput)


public class Test11 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("c:\\doc\\test.txt"); //File f = new File(f);
		
		System.out.println("파일명: "+ f.getName());
		System.out.println("파일 사이즈: "+ f.length());
		System.out.println("파일경로: "+ f.getAbsolutePath());
		System.out.println("표준경로: "+ f.getCanonicalPath());
		System.out.println("만든날: "+ new Date(f.lastModified()));
		System.out.println("폴더경로: "+ f.getParent());
		System.out.println("읽기속성: "+ f.canRead());
		System.out.println("쓰기속성: "+ f.canWrite());
		

	}

}
