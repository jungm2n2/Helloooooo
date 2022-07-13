package com.day18;

import java.io.IOException;

//Stream
//데이터 입출력시 모든 데이터의 형태와는 관계없이
//단방향 흐름으로 데이터를 전송하는 클래스이다

//in : 기본 입력 stream (바이트로 읽어냄. 바이트 스트림)



public class Test1 {

	public static void main(String[] args) throws IOException {
		
		int data;
		
		System.out.println("문자열?"); //abcd
		
		while((data=System.in.read())!=-1) {  // in 키보드에 입력한 1byte의 문자를 읽어낼때
			
			char ch = (char)data;
			System.out.print(ch);
			
			
		}
		
		
		
		
		
		
		
		

	}

}
