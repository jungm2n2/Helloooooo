package com.day18;



import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) throws Exception {
		
		ScoreVO vo = new ScoreVO();
		Scanner sc = new Scanner(System.in);
		ScoreImpl ob = new ScoreImpl();
		
		int su;
		
		while(true) {
			
			do {
				System.out.print("1.�Է� 2.��� 3.���� 4.����");
				su = sc.nextInt();
				
			}while(su<1||su>4);
			
			switch(su) {
			
			case(1):
				ob.input();break;
			case(2):
				ob.print();break;
			case(3):
				ob.save();break;
			case(4):
				ob.save();
				System.out.println("�ý����� �����մϴ�");
				System.exit(0);
			}
			
			
			
		}
		
		

	}

}
