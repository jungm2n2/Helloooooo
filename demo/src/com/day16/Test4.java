package com.day16;

import java.util.Scanner;

//5~10�� �̳��� ���ڿ��� �Է� �޾Ƽ� ��� ���α׷�
//����
//1.5~10�� �̳��� ���ڿ�
//2.�����ڸ� �Է�

class MyAuthen{
	
	public void inputFormat(String str) throws Exception{
		
		//1.5~10�� �̳��� ���ڿ�
		//���ڿ��� ���̴� 5~10�� �Դϴ�.
	
		if(str.length()<5 || str.length()>10) {
			throw new Exception("���ڿ��� ���̴� 5~10�� �Դϴ�");
		}
		
		//2.�����ڸ� �Է�
		//�����ڸ� �����մϴ�.

		
/*		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			
			if((ch<65||ch>90) && (ch<97||ch>122)) {
				
				throw new Exception("�����ڸ� �Է� �����մϴ�");
				
			}
			
		}
		 
*/
			int eng=0;
			int num=0;
			
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
				
				if((ch>='A'&&ch<='Z') || (ch>='a'&&ch<='z')) {
					eng++;
					
				}else if((ch>='0'&&ch<='9')) {
					num++;
					
				}
	
			}

			if(eng==0 || num==0) {
				throw new Exception("������ �Ǵ� ���� ȥ�� �Է¸� �����մϴ�");
			}
			
	}
}
public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str;
		
		MyAuthen auth = new MyAuthen();
		
		try {
			
			System.out.print("���ڿ�?");
			str = sc.next();
			
			auth.inputFormat(str);
			
			System.out.println(str);
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}


