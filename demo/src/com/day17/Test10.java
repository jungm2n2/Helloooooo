package com.day17;

import java.util.Random;
import java.util.Scanner;

class Sadari extends Thread{
	
	private static String[] name = 
		{"������","�ȼ���","����","�輺��","���ٿ�",
		"������","�̵���","������","��ȫ��","������",
		"������","������","�ڼ���","������","��â��",
		"�����","������","�ڼ���","������","�ɹ���",
		"��ä��","�迵��","�Ƚÿ�","������","�ڼ���",
		"������","������"};
	
	
	
	int [] num2;
	
	//Scanner sc = new Scanner(System.in);
	
	
	Random rd = new Random();
	
	private int num;
	
	
	@Override
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǥ�� �ο���?");
		num = sc.nextInt();
		num2 = new int[num];
		
		System.out.print("�����");
		
		for(int i=0;i<10;i++) {
			System.out.print(".");
		
		try {
			
			sleep(1000);
				
			}
			
		 catch (Exception e) {
			
		}
		
		
	
	}
		System.out.println();
		System.out.println("�����մϴ�!! ��ǥ���Դϴ�!!");
		print();
	
}

	
	public void print() {
		
		int n;
		n=0;
		
		while(n<num) {
			
			num2[n] = rd.nextInt(27);
			
			for(int i=0;i<n;i++) {
				
				if(num2[i]==num2[n]) {
					n--;
					break;
				}
					
			}
			
			n++;
			
		}
		
		for(int i=0;i<num;i++) {
			
			System.out.printf("%d�� ��ǥ�� : %s\n",i+1,name[num2[i]]);
			
		}
	
	
		
		
		
	}


}
public class Test10 {

	public static void main(String[] args) {
		
		
		Sadari sd1 = new Sadari();
		
		
		sd1.start();
		
		

	}

}
