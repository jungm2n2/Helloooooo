package com.naver;

import java.util.Scanner;



public class SignupMain {

	public static void main(String[] args) {
		
		SignupVO vo = new SignupVO();
		SignupImpl ob = new SignupImpl();
		Scanner sc = new Scanner(System.in);
		int ch;
		
		
		while(true) {
			
			do {
				System.out.print("1.�Է� \n2.��� \n3.���̵� �˻� \n4.�̸��˻� \n5.�������� "+
								"\n6.ȸ������ \n7.����");
				System.out.print("\n------------------------------\n");
				System.out.print(":  ");
				ch = sc.nextInt();
				
			} while(ch<1);
			
			
			switch(ch) {
				case 1:
					ob.input();break;
				case 2:
					ob.print();break;
				case 3:
					ob.findId();break;
				case 4:
					ob.findName();break;
				case 5:
					ob.updateId();break;
				case 6:
					ob.deleteId();break;
				default:
					System.out.println("�ý����� �����մϴ�");
							System.exit(0);

	}
}
}
}