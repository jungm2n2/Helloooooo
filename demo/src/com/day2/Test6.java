package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {

	public static void main(String[] args) throws IOException {
		
		//�غ�(w)�� ����(h)�� �Է¹޾� �ﰢ���� ����(a) ���ϱ�
		//�غ�?23.5
		//����?34.7
		//����:xxx.xx
		//���� = �غ� * ���� / 2
		
		
		//����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		float w,h,a;
		
		
		//�Է�
		System.out.print("�غ�?");
		w = Float.parseFloat(br.readLine());
		
		System.out.print("����?");
		h = Float.parseFloat(br.readLine());
		
		//����
		a = w*h/2; 
		
		//a = w*h/2.0; (����)
		
		//���
		System.out.println("����:"+a);

	}

}
