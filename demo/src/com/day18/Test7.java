package com.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		
		//���� ���� ���α׷�
		//��������? c:\\doc\\test.txt
		//�������? c:\\doc\\out1.txt
		//����Ϸ�!!
		
		Scanner sc = new Scanner(System.in);
		
		
		int data; //������ �о��
		
		
		try {
			
			System.out.print("��������?");
			String file1 = sc.next();
			
			System.out.println("�������?");
			String file2 = sc.next();
			
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			
			
			while((data=fis.read())!=-1) {
				
				fos.write(data); //�о�� �����͸� fos.write�� ������
				fos.flush();
			
			}
			
			fis.close();
			fos.close();
			System.out.println("���� �Ϸ�!");
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
