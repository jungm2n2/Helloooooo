package com.day17;

import java.util.Random;
import java.util.Scanner;

class Sadari2 extends Thread{
	
	@Override
	public void run() {
		
	
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
		
		
		
		
	}
	
	
	
	
}




public class Test11 {

	public static void main(String[] args) {
		
		Random rd = new Random();
		int num;
		int num2 [];
	
		String[] name = 
			{"������","�ȼ���","����","�輺��","���ٿ�",
			"������","�̵���","������","��ȫ��","������",
			"������","������","�ڼ���","������","��â��",
			"�����","������","�ڼ���","������","�ɹ���",
			"��ä��","�迵��","�Ƚÿ�","������","�ڼ���",
			"������","������"};
		
		
		//Scanner sc = new Scanner(System.in);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǥ�� �ο���?");
		
		num = sc.nextInt();
		num2 = new int[num];
		
		Sadari2 sd= new Sadari2();
		sd.start();
		

	//	try {
	//		Thread.sleep(1000);
			
	//	} catch (Exception e) {
			
	//	}
		

		try {
			sd.join();
		} catch (Exception e) {
		
		}
		
		
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


