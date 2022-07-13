package com.day11;

//Wrapper Ŭ����
//�⺻ �ڷ����� ��ü�� ����� �� �ְ� ���ش�.

//�ڷ���: boolean,byte,char,short,int,long,float,double

//reference(class) �ڷ���
//Boolean, Byte,Character,Short,Integer,Float,Double

//Auto-Boxing : (stack -> heap)
//Auto-UnBoxing : (heap->stack)


public class Test7 {

	public static void main(String[] args) {
		
		
		int a = 24;
		
		
		System.out.println(a+10);
		System.out.println(Integer.toString(a)+10);
		System.out.println(Integer.toString(a, 2)); //2������ �ٲ��
		System.out.println(Integer.toString(a, 16));
		
		
		int n1 = 10;
		int n2;
		Integer num1;
		Integer num2 = new Integer(20);
		
		num1 = n1; //����ڽ�
		n2 = num2; //�����ڽ�
		
		System.out.println(n1+":"+num1);
		System.out.println(n2+":"+num2);

	}

}



/*

int a = 10;
float b;

b = a;        �Ͻ��� ����ȯ(10.0) 
b = (float)a; ����� ����ȯ
a = b;        ����
a = (int)b;   ����� ����ȯ

-----------------------------------------------------
B(�θ�) = A(�ڽ�)

B = A;         UPCAST(10.0)
B = (B)A;      ����� UPCAST
A = B;         ����
A = (A)B;      ����� DOWNCAST



*/
