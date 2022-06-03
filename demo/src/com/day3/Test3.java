package com.day3;

import java.io.IOException;

public class Test3 {

	public static void main(String[] args) throws IOException {
		
		char ch, result;
		
		//ch = 'a'; //97(ascii)
		//System.out.println(ch); //a
		//System.out.println(Integer.toString(ch)); //97
		
		System.out.print("한개의 문자?"); //a(97), A(65)
		ch = (char)System.in.read(); //97(57, 55)
	
		result = ch >=65 && ch<=90?(char)(ch+32) : 
			(ch>='a' && ch <='z'?(char)(ch-32):ch); 
			
		System.out.println(ch + ":" + result);			
		
		
		
	}

}

        //ch = "a"; (문자를 저장할때는 큰따옴표x. 큰따옴표는 String에 저장.)
		//ch = 'abcd'; (하나의 문자만 저장 가능)
		//ch = 'a'; 영어 1byte
		//ch = '가' 한글 2byte
		