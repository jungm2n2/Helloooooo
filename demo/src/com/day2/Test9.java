package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test9 {

	public static void main(String[] args) throws  IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name;
		int mat,eng,kor,tot,ave;
		
		
		System.out.print("�̸�?");
		name = br.readLine();
		
		System.out.print("����?");
		mat = Integer.parseInt(br.readLine());
		
		System.out.print("����?");
		eng = Integer.parseInt(br.readLine());
		
		System.out.print("����?");
		kor = Integer.parseInt(br.readLine());
		
		tot = mat+eng+kor;
		ave = (mat+eng+kor)/3;
		
		System.out.printf("����:%d��, ���:%d�� �Դϴ�!!\n",tot,ave);
		System.out.printf("����:"+tot+"��, ���:"+ave+"�� �Դϴ�!!");
		System.out.println();
			

	}

}
