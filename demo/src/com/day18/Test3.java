package com.day18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//inputStreamReader
//1byte stream�� 2byte�� ��Ʈ������ ��ȯ
//bridge stream
//��ȯ�Ѱ� �������� �� �ʿ��� = Reader

public class Test3 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.println("���ڿ� �Է�");
		
		Reader rd = new InputStreamReader(System.in);
	// 3. �����    2. 2����Ʈ�� ��ȯ�ؼ�  1.1����Ʈ�� �޾Ƽ�	
		while((data=rd.read())!=-1) {
			char ch = (char)data;
			System.out.print(ch);
		}

	}

}
