package com.day15;

import java.util.Scanner;

public class BmiMain {

	public static void main(String[] args) {
		
		int num;
		Scanner sc = new Scanner(System.in);
		BmiVO vo = new BmiVO();
		Bmi ob = new BmiImpl();
		
		while(true) {
			
			do {
				System.out.println("1.�Է� 2.��� 3.���� 4.���� 5.ȸ���˻� 6.�̸��˻� 7.����");
				num = sc.nextInt();
			}while(num<1);
			
			
			switch (num) {
			case 1:
				ob.input();
				break;
			case 2:
				ob.print();
				break;
			case 3:
				ob.delet();			
				break;
			case 4:
				ob.update();
				break;
			case 5:
				ob.findnum();
				break;
			case 6:
				ob.findName();
				break;
			default:
				System.out.println("�ý����� �����մϴ�");
				System.exit(0);
		
			}
			
			
		}
		
		

	}

}
