package com.day3;

import java.io.IOException;

public class Test3 {

	public static void main(String[] args) throws IOException {
		
		char ch, result;
		
		//ch = 'a'; //97(ascii)
		//System.out.println(ch); //a
		//System.out.println(Integer.toString(ch)); //97
		
		System.out.print("�Ѱ��� ����?"); //a(97), A(65)
		ch = (char)System.in.read(); //97(57, 55)
	
		result = ch >=65 && ch<=90?(char)(ch+32) : 
			(ch>='a' && ch <='z'?(char)(ch-32):ch); 
			
		System.out.println(ch + ":" + result);			
		
		
		
	}

}

        //ch = "a"; (���ڸ� �����Ҷ��� ū����ǥx. ū����ǥ�� String�� ����.)
		//ch = 'abcd'; (�ϳ��� ���ڸ� ���� ����)
		//ch = 'a'; ���� 1byte
		//ch = '��' �ѱ� 2byte
		