package com.day9;

//������
//1.�޸� �Ҵ�(��ü����)
//2.���� �ʱ�ȭ
//Ŭ������ �̸��� ����
//���ϰ��� ���� ������ property�� ����.
//�ߺ� ���ǰ� �����ϴ�.
//�����ڿ��� �ٸ� �����ڸ� ȣ�� �� �� �ִ�.
//��, �ڵ��� �� ���ο��� �ѹ��� ȣ�� �����ϴ�.



public class Test2 {
	
	private int x;
	
	public Test2() {} //�����ε� �Ҷ� �⺻ �����ڸ� ����ϸ� �⺻ ������ ��� ����. �������� �����ε� �� �����ڸ� ����Ѵ�.
	
	//public Test2() { //�⺻ ������, �μ��� ���� ������. ��� Ŭ������ �����ִ�. �ʿ��Ҷ� ���� ����
		
		//this(30); //�⺻���� �����ε� ȣ��. ���ο����� ����
		
		//System.out.println("�⺻������~!~!!!~~!!~~~!!");
		
		//x = 10; //�ʱ�ȭ. ��ȸ���� ���̵� �ʱ�ȭ �����ϴ�. ������ ���� �����ȴ�. �׷��� ��ȸ���� ���
		//System.out.println("x : " + x);
		
	//}
	
	public Test2(int x) {//������ �ߺ�����
		
		//this(); //�����ε� �����ڿ��� �⺻������ ȣ��.
	
		//System.out.println("�����ε� �� ������~~~!~!!~!~!~!!");
		
		this.x = x ;
		//System.out.println("x : " + x);
	
	}
	
	
	public void setData(int x) { //��ȸ����
		this.x = x;
		
	}
	
	

	public static void main(String[] args) {

		Test2 ob1 = new Test2(); //�⺻������
		
		System.out.println(ob1.x); //0
		
		ob1.setData(100);
		
		System.out.println(ob1.x); //100
		
		//--------------------------------------
		
		Test2 ob2 = new Test2(20); //�ѹ��� ���
		System.out.println(ob2.x);
		
		ob2.setData(4); //��ü�� �����ϸ鼭 20->4 �ϱ�. ��ȸ���ο��� ����
		System.out.println(ob2.x);
		
		Test2 ob3 = new Test2();
		Test2 ob4 = new Test2(60);
	}

}
