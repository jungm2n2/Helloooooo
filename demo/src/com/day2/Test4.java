package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		//system.in : 키보드로 입력한 1byte 문자를 입력 받음
		//InputStreamreader : System.in으로 받은 캐릭터를 문자 2byte로 변경
		//BufferedReader : 2byte로 변경된 문자를 저장
		
		int r;
		double area,length;
		
		System.out.print("반지름?"); //20,2십
				
		r = Integer.parseInt(br.readLine());
		//Integer.parseInt = int로 바꿔라
		//r = Double.parseDouble(br.readLine());
				

		area = r*r*3.14;
		length = r*2*3.14;
		
		System.out.println("반지름:" + r);
		System.out.println("넓이:" + area);
		System.out.println("둘레:" + length);
	}

}
