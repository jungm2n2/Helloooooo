package com.day18;

import java.io.IOException;

//Stream
//������ ����½� ��� �������� ���¿ʹ� �������
//�ܹ��� �帧���� �����͸� �����ϴ� Ŭ�����̴�

//in : �⺻ �Է� stream (����Ʈ�� �о. ����Ʈ ��Ʈ��)



public class Test1 {

	public static void main(String[] args) throws IOException {
		
		int data;
		
		System.out.println("���ڿ�?"); //abcd
		
		while((data=System.in.read())!=-1) {  // in Ű���忡 �Է��� 1byte�� ���ڸ� �о��
			
			char ch = (char)data;
			System.out.print(ch);
			
			
		}
		
		
		
		
		
		
		
		

	}

}
