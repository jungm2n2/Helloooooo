package com.day9;

public class Test4 {
	
	int a = 5;
	
	//�ʱ�ȭ ��. new�� ������! �� �ѹ��� ����ȴ�(�̸��� ���� ������ ��ȣ�� �Ұ���).
	{
		System.out.println("�ʱ�ȭ ��a : "+ a);
		a = 10;
		System.out.println("�ʱ�ȭ ��a : "+ a);
	}

	//System.out.println("�ʱ�ȭ ��a : "+ a); //������ �ۿ� ���� �� �ִ�.
	
	
	static int b;
	static { //�ε��ϸ� �˾Ƽ� ����. static ���� ������ �� �ѹ��� ����.
		b = 10;
		System.out.println("�ʱ�ȭ ��b : "+ b);
		
	}
	
	final int C; //���. �ʱ�ȭ �ʼ�(C=0). �빮�ڷ� ��.
	
	
	public Test4() { //�⺻������
		
		System.out.println("������..");
		C=100; //�ʱ�ȭ
		System.out.println("C : "+C);
		
	}
	
	
	public static void main(String[] args) {
		
		Test4 ob1 = new Test4();
		Test4 ob2 = new Test4();
		
		//������� : static -> new(instance ����, �޼ҵ�) -> ������

	}

}
