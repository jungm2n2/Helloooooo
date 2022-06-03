package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test10 {

	public static void main(String[] args) throws  IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int mat,eng,kor,tot,ave;
		
		System.out.print("Math?");
		mat = Integer.parseInt(br.readLine());
		
		System.out.print("English?");
		eng = Integer.parseInt(br.readLine());
		
		System.out.print("Korean?");
		kor = Integer.parseInt(br.readLine());
		
		tot = mat+eng+kor;
		ave = (mat+eng+kor)/2;
		
		System.out.printf("√—¡°:%d¡°, ∆Ú±’:%d¡° ¿‘¥œ¥Ÿ!",tot,ave);
		
	
				

	}

}
