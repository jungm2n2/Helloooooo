package com.day3;

import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		
		//1.������ �Է� �޾Ƽ� ¦��, Ȧ���� �����ؼ� ���.
		//��) 3 �Է½� -> 3 => Ȧ��
		//��) 4 �Է½� -> 4 => ¦��
		
		Scanner sc = new Scanner(System.in);
		
		int su;
		
		System.out.print("����?");
		su = sc.nextInt();
		
		String str;
		
		str = su % 2 == 0? "¦��":"Ȧ��";
		
		System.out.println(su+":"+str);
		
		
		
		
		

	}

}
