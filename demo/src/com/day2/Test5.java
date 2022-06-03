package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5 {

	public static void main(String[] args) throws IOException {
		
		//선언
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String name;
		int kor,eng,tot;
		
		
		//입력
		System.out.print("이름?"); //suzy
		name = br.readLine();
		
		System.out.print("국어?");//60
		kor = Integer.parseInt(br.readLine());
		
		System.out.print("영어?");//80
		eng = Integer.parseInt(br.readLine());
	
		
		//연산
		tot = kor+eng;
		
		//출력
		System.out.println("이름?:" +name);
	
		System.out.println("총점:" + tot +"점" );
		
		
	
		
		

	}

}
