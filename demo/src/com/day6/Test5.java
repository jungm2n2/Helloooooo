package com.day6;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		
		//jumin : 900110-2053126
		//index : 1234567890123
		//chk   : 234567 892345
		
		//��=(9*2)+(0*3)+...+(2*5)
		//��=11-��%11
		//��=��%10
		//��==6
		
		
		String jumin;
		int chk[] = {2,3,4,5,6,7,8,9,2,3,4,5}; 
		int i,tot,su;
	
		
		System.out.print("�ֹι�ȣ[xxxxxx-xxxxxxx]?");
		jumin = sc.next();
		
		if(jumin.length()!=14) {
			System.out.println("�Է� ����!!");
			return; //stop = ���α׷� ����
		
		}
		
		tot=0;
		
		
		//jumin : 900110-2053126
		//index : 1234567890123
		//chk   : 234567 892345
		
		
		
		for(i=0;i<12;i++) {
			
			if(i>=6) {//���ڸ�
				tot += chk[i]*Integer.parseInt(jumin.substring(i+1,i+2));
				
			}else {//�������
				tot += chk[i]*Integer.parseInt(jumin.substring(i,i+1));
			}
			
			
		}
		
		
		
		su = 11 - tot % 11;
		su = su % 10;
		
		if(su==Integer.parseInt(jumin.substring(13))) {
			System.out.println("���ѹα� �����Դϴ�");
		}else {
			System.out.println("�� ������?");
		}

	}

}



/*
		
		String str = "seoul korea";
		//index :     01234567890 
		
		System.out.println(str.substring(0,3));//0��°~3��° index ���
		System.out.println(str.substring(6,8));
		System.out.println(str.substring(6)); //6��° index ���� ������ ���
		

*/