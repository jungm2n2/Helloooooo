package com.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//Scanner : �ܶ������� ������ ����� ����
//�⺻ �ܶ��� ����

public class Test6 {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		
		String name;
		int kor, eng, mat;
		
		System.out.print("�̸� ���� ���� ����?");//���� 50 70 80 (���ٿ� �Է�.������ ������)
		
		
		//System.out.print("�̸�,����,����,����?");//����,50,70,80 (���ٿ� �Է�.,�� ������)
		//sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*"); //,�� �����ڷ� �����ϴ� ���
		
		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		
		
		System.out.println(name+":"+(kor+eng+mat)+"��");
		
		
		//sc.close(); ��������
		
		
	

	}

}
