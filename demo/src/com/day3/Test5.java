package com.day3;

import java.util.Scanner;

public class Test5 {
	
	// else if �� / ���ǿ����� = �۾�������

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor;
		
		System.out.print("�̸�?");
		name = sc.next();
		
		System.out.print("����?");
		kor = sc.nextInt();
		
		String pan; //"��" �ʱⰪ���� 
		//else if ���� ū ���� ����, ���� ���� �Ʒ��� ������.
		
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
		
		
		
		System.out.println(name+"�� ���� ������ "+kor+"���̰�, "+
		"ȯ�� ������ ("+pan+") �Դϴ�.");
		System.out.printf("%s�� ���� ������ %d���̰�, ȯ�� ������ (%s) �Դϴ�", name,kor,pan);
		
		
	}

}


