package com.day4;

import java.io.IOException;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		//���� �Է¹޾� 1�������� �Է¹��� �� ������ �հ踦 ���Ͻÿ�
		
		
		Scanner sc = new Scanner(System.in);
		
		int su,sum=0;
		char ch;
		
		
		while(true){ //���ѷ���
			
		
			
			do {
				System.out.print("���� �Է� �Ͻÿ�"); //10
				su = sc.nextInt();
			
			}while(su<1 || su>5000);  //su�� 1���� ������ �ȵ�, su�� 5000���� ũ�� �ȵ�. False�϶� ��������
			                          //True�̸� ���� �ö󰡼� �ٽ� ���� �Է��ϰ� ����� ��.
			
			
			sum=0;
			for(int i=1;i<=su;i++) {
				
				sum=sum+i;
				
			}
			
			
			System.out.println("1~"+su+"������ ��:"+sum);
			
			System.out.print("����ҷ�?[Y/N]"); //y,Y,n,N,1,A,�ƴϿ�
			ch = (char)System.in.read();
			
			if(ch!='y'&&ch!='Y') { //y�� �ƴϰ�, Y�� �ƴϸ�
				                   //������ �����̸� || -> &&
				
				System.out.println("���α׷� ����");
				
				break; //���ѷ����� ���� ��.
				//while,do~while,for,switch ���� �� �� �ִ�
			}
			
		
		}	
		
	}

}
