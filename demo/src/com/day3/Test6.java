package com.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//Scanner : 단락문자의 패턴을 사용해 구분
//기본 단락은 공백

public class Test6 {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		
		String name;
		int kor, eng, mat;
		
		System.out.print("이름 국어 영어 수학?");//수지 50 70 80 (한줄에 입력.공백이 구분자)
		
		
		//System.out.print("이름,국어,영어,수학?");//수지,50,70,80 (한줄에 입력.,이 구분자)
		//sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*"); //,를 구분자로 지정하는 방법
		
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		
		
		System.out.println(name+":"+(kor+eng+mat)+"점");
		
		
		//sc.close(); 생략가능
		
		
	

	}

}
