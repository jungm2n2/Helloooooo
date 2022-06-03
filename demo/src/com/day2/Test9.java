package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test9 {

	public static void main(String[] args) throws  IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name;
		int mat,eng,kor,tot,ave;
		
		
		System.out.print("이름?");
		name = br.readLine();
		
		System.out.print("수학?");
		mat = Integer.parseInt(br.readLine());
		
		System.out.print("영어?");
		eng = Integer.parseInt(br.readLine());
		
		System.out.print("국어?");
		kor = Integer.parseInt(br.readLine());
		
		tot = mat+eng+kor;
		ave = (mat+eng+kor)/3;
		
		System.out.printf("총점:%d점, 평균:%d점 입니다!!\n",tot,ave);
		System.out.printf("총점:"+tot+"점, 평균:"+ave+"점 입니다!!");
		System.out.println();
			

	}

}
