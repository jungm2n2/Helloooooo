package com.day7;

import java.util.Scanner;

public class Sumyg {
	
	
	String name,pan;
	int kor;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸�?");
		name = sc.next();
		System.out.print("���� ����?");
		kor = sc.nextInt();
		
	}
	
	public String pan() {
		
		if(kor>=90) {
			pan = "��";
		}else if(kor>=80) {
			pan = "��";
		}else if(kor>=70) {
			pan = "��";
		}else if(kor>=60) {
			pan = "��";
		}else {
			pan= "��";
		}
		String result;
		result = pan;
		return pan;
	}
	
	public void print(String pan) {
		
		System.out.printf("%s�� ���� ������ %d���̰�, ȯ�� ������ %s �Դϴ�", name,kor,pan);
		
	}

}
