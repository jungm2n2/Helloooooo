package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int su = 0;
		
		System.out.print("�� �Է�?");
		su = Integer.parseInt(br.readLine());
		
		String str;
		
		//���׿�����(����? ������ ���� true : ������ ���� false)
		str = su % 2 == 0 ? "¦��" : "Ȧ��";
		
		str = su>0 ? "���" : (su <0 ?"����" : "��");
		
		
		//A(����) && B(����) (A and B) : A,B �Ѵ� true�϶� true
		//A || B (A or B) : A �Ǵ� B ���߿� �ϳ��� ture �̸� ture
		str = su % 4 == 0 && su % 100 !=0 || su % 400 == 0 ? "����" : "���";
			//!= (���� �ʴ�) == <-> !=
		
		
		System.out.println(su+":"+str);
		
		
		
		
		
		
		
		
	}

}
