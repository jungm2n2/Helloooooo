package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5 {

	public static void main(String[] args) throws IOException {
		
		//����
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String name;
		int kor,eng,tot;
		
		
		//�Է�
		System.out.print("�̸�?"); //suzy
		name = br.readLine();
		
		System.out.print("����?");//60
		kor = Integer.parseInt(br.readLine());
		
		System.out.print("����?");//80
		eng = Integer.parseInt(br.readLine());
	
		
		//����
		tot = kor+eng;
		
		//���
		System.out.println("�̸�?:" +name);
	
		System.out.println("����:" + tot +"��" );
		
		
	
		
		

	}

}
