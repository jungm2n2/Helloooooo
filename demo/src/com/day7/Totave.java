package com.day7;

import java.util.Scanner;

public class Totave {
	
	String name;
	int math,eng,kor;
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸�? ����? ����? ����?");
		name = sc.next();
		math = sc.nextInt();
		eng = sc.nextInt();
		kor = sc.nextInt();

	}
	
	public int tot() {
		
		int result;
		result = math+eng+kor;
		return result;
		
		
	}
	
	public int ave() {
		
		return (math+eng+kor)/3;
		
	}
	
	public void print(int t, int a) {
		
		System.out.println("�̸� : "+name);
		System.out.println("���� ����? : "+math);
		System.out.println("���� ����? : "+eng);
		System.out.println("���� ����? : "+kor);
		System.out.println("���� : "+t);
		System.out.println("��� : "+a);
	}

}
