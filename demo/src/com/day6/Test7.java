package com.day6;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) throws IOException {
		
		//1~10������ ������ �߻����� �߻���Ų ������ 3���ȿ� �˾� ���ߴ� ����
		//(3���ȿ� �˾Ƹ����� ���ϸ� �߻��� ������ ���)
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int i,j,answer;
		char yn;
		int num = rd.nextInt(10)+1;
		
		
		while (true) {
			for(i=1;i<=3;i++) {
				System.out.printf("�����Է�?[%d��°��ȸ]",i);
				answer = sc.nextInt();
				
				if(answer!=num) {
					System.out.println("Ʋ�Ⱦ��!");
				} else {
					System.out.println("�¾Ҿ��");
					
		
				
				}
				
			}
			System.out.println("������"+num+"�Դϴ�.");
			
			System.out.print("����ҷ�?[Y/N]"); 
			yn = (char)System.in.read();
			
			if(yn=='n'|| yn=='N') {
				
				System.out.println("���α׷� ����");
				break;
			}
			else if (yn=='y' || yn=='Y');
			System.out.println("---------------------");
					
				
				
				
		}
			
			
			
		}
	
		
		
	

	

}
