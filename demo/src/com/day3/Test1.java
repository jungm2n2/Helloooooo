package com.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num1, num2;
		
		System.out.print("ù��° ��?");
		num1 = Integer.parseInt(br.readLine());
		
		System.out.print("�ι�° ��?");
		num2 = Integer.parseInt(br.readLine());
		
		System.out.printf("%d + %d = %d\t" , num1,num2,num1+num2); //\n \t(��):����ȭ ǥ����. ���������� �νĉ�
		System.out.printf("%d - %d = %d\n", num1, num2, num1-num2);
		System.out.printf("%d * %d = %d\t", num1, num2, num1*num2);
		System.out.printf("%d / %d = %d\n", num1, num2, num1/num2); //��
		System.out.printf("%d %% %d = %d\n", num1, num2, num1%num2);//������
		
		// �ε�ȣ : >, <, >=, <=, ==
		//���ڸ� �ε�ȣ�� ���ϸ� True �Ǵ� False ���ڰ� �����ȴ�.
		System.out.println("num1>num2 : " + (num1>num2)); //boolean��. True or False
		
		
		
		

	}

}
