package com.day7;

import java.util.Scanner;

public class Rect {
	
	int w,h; //��������,instance ����. �ʱⰪ�� �ڵ����� ������.
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		//int w,h; //��������
		
		System.out.print("���ΰ�?");//10
		w = sc.nextInt();
		
		System.out.print("���ΰ�?");//20
		h = sc.nextInt();
		
		//return; void���� ��������. ��ȯ���� ���� ����.
	}
	
	//���� ���ϱ�
	public int area() {
		
		
		int result;
		
		result = w*h;
		
		return result;
		
		
		
		
	}
	
	//�ѷ����ϱ�
	public int length() {
		
		return (w+h)*2;
		
		
		
	}
	
	//���
	public void print (int a, int l) {//�Ű�����
		
		System.out.println("����: "+ w);
		System.out.println("����: "+ h);
		System.out.println("����: "+ a);
		System.out.println("�ѷ�: "+ l);
		
		
	}

}

//Class�� �ڷ���
