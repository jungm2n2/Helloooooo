package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

	public static void main(String[] args) throws  IOException {
		
		//���
		//if, �ݺ���(for, while, do~while), switch
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num;
		String  str = ""; //null�� �ʱ�ȭ
		
		System.out.print("�� �Է�");
		num = Integer.parseInt(br.readLine());
		
		//if(���ǽ�){�۾�} = ����if�� ����1�� �۾�1 //����if���� �ʱ�ȭ ��Ű��
		
		/*if(num%2==0) {
			str = "¦��";
			
		}
		
		if(num%2!=0) // or (num%2==1) {
			str = "Ȧ��";
			
		}
		*/
		
		
		//if~else (����1�� ����2)
		
		if(num%2==0) {
			str = "¦��";
		}else {
			str = "Ȧ��";
		
		}
		
		System.out.println(num + ":" + str);
		
		

	}

}
