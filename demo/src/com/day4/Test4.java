package com.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.xml.sax.InputSource;

public class Test4 {

	public static void main(String[] args) throws IOException {
		
		//���� �Է¹޾� 1�������� �Է¹��� �� ������ �հ踦 ���Ͻÿ�
		
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		
		
		
		int su,sum=0;
		char ch;
		
		
		while(true){ //���ѷ���
			
		
			
			do {
				System.out.print("���� �Է� �Ͻÿ�"); //10
				su = Integer.parseInt(br.readLine());
			
			}while(su<1 || su>5000);  //su�� 1���� ������ �ȵ�, su�� 5000���� ũ�� �ȵ�. False�϶� ��������
			                          //True�̸� ���� �ö󰡼� �ٽ� ���� �Է��ϰ� ����� ��.
			
			
			sum=0;
			for(int i=1;i<=su;i++) {
				
				sum=sum+i;
				
			}
			
			
			System.out.println("1~"+su+"������ ��:"+sum);
			
			System.out.print("����ҷ�?[Y/N]"); //y,Y,n,N,1,A,�ƴϿ�
			ch = (char)System.in.read();
			
			if(ch!='y'&&ch!='Y') { //������ �����̸� || -> &&
				
				System.out.println("���α׷� ����");
				
				break;
				//while,do~while,for,switch ���� �� �� �ִ�
			}
			
			
			System.in.skip(2);
			
			
		
		}	
		

	}

}
