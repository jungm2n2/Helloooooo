package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test8 {

	public static void main(String[] args) throws  IOException {
		
		//�غ�(w)�� ����(h)�� �Է¹޾� �ﰢ���� ����(a) ���ϱ�
				//�غ�?23.5
				//����?34.7
				//����:xxx.xx
				//���� = �غ� * ���� / 2
		

		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int w,h;
		double a;
		
		
		
		System.out.print("�غ�?");
		w = Integer.parseInt(br.readLine());
		
		
		System.out.print("����?");
		h = Integer.parseInt(br.readLine());
		
		
		a = w*h/2.0f;
		
		System.out.println("����=" + a);
	
		
		
		
	
		
		
		
		
		
		

	}

}
