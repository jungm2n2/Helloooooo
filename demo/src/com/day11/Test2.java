package com.day11;

//String : �⺻�ڷ����� �ƴϰ� class�̴�.
//������ �����ʹ� ũ��, ���󵵴� ���⶧����
//String�� �Һ��� ��Ģ�� �������ִ�

public class Test2 {

	public static void main(String[] args) {
		
		String ob1 = "Seoul";//
		String ob2 = "Seoul";//���� ���ڿ��� �ּҸ� ������
		String ob3 = new String("Seoul");
		
		System.out.println("ob1==ob2: "+(ob1==ob2)); //Call by Reference
		System.out.println("ob1==ob3: "+(ob1==ob3));
		System.out.println("ob1.equals(ob3): "+ob1.equals(ob3)); //String�� equals:
		                                                         //�ּҰ� �ƴ� �����͸� ���ϴ� equals.(�������̵�)
		                                                         
		ob2 = "Korea";
		System.out.println("ob1==ob2: "+(ob1==ob2));
		
		ob2 = "Japan";
		System.out.println("ob1==ob2: "+(ob1==ob2));
		
		ob2 = "China";
		System.out.println("ob1==ob2: "+(ob1==ob2));
		
		ob2 = "Seoul";
		System.out.println("ob1==ob2: "+(ob1==ob2));
		
		System.out.println(ob2);
		System.out.println(ob2.toString());
		
		
		
		

	}

}
