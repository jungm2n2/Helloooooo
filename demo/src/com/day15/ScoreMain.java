package com.day15;

import java.util.Scanner;



public class ScoreMain {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		ScoreVO vo = new ScoreVO();
		
		Score ob = new ScoreImpl();
		
		int num;
		
		while(true) {
			
			do {
			
				System.out.print("1.�Է� 2.��� 3.���� 4.���� 5.�й��˻�"+
								" 6.�̸��˻� 7.����");
				num = sc.nextInt();
					
			}while(num<1);
			
			switch(num) {
				case 1:ob.input();break;
				case 2:ob.print();break;
				case 3:ob.delete();break;
				case 4:ob.update();break;
				case 5:ob.findHak();break;
				case 6:ob.findName();break;
				default:
					System.out.println("�ý����� �����մϴ�");
					System.exit(0);
			
			
			
			}
			
			
		}
		

	}

}
