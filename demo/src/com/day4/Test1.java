package com.day4;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		
		//�ݺ���(for,while,do~while)
		
		Scanner sc = new Scanner(System.in);
		
		int dan;
		
		System.out.print("�� �Է�?"); //7��
		dan = sc.nextInt();
		
		
		//for(�ʱⰪ;�ִ밪;������) {}
		
		//���۰��� ������ ��Ȯ�� ���� ���϶� ���
		
		for(int i=1;i<=9;i++) { //i=i+1
			
			//System.out.println(dan + "x" + i + "=" + (dan*i));
			System.out.printf("%dx%d=%d\n",dan,i,(dan*i));
		}
		
		System.out.println("----------------------");
		
		
		//�ʱⰪ
		//while(�ִ밪) {������}
		
		//��� �ݺ��ؾ� �ϴ��� �𸦶� ���
		
		int j=0; //�������϶��� 0�� �ʱⰪ
		while(j<9) { //�ʱⰪ�� 0�϶��� =�� ����
			
			j++;
			System.out.println(dan + "x" + j + "=" + (dan*j));
			
			
		}
		
		System.out.println("----------------------");
		
		//�ʱⰪ
		//do{������}while(�ִ밪)
		
		//�ϴ� �ѹ� �����غ���
		
		
		int k=0;
		do {
			k++;
			System.out.println(dan + "x" + k + "=" + (dan*k));
		}while(k<9);
		
		
		
		//do while �� ������ �ѹ��� �����Ѵ�.
		
		
		
		
		
		
		
	
		
	}

}
