package com.day11;

//Wrapper 클래스
//기본 자료형을 객체로 사용할 수 있게 해준다.

//자료형: boolean,byte,char,short,int,long,float,double

//reference(class) 자료형
//Boolean, Byte,Character,Short,Integer,Float,Double

//Auto-Boxing : (stack -> heap)
//Auto-UnBoxing : (heap->stack)


public class Test7 {

	public static void main(String[] args) {
		
		
		int a = 24;
		
		
		System.out.println(a+10);
		System.out.println(Integer.toString(a)+10);
		System.out.println(Integer.toString(a, 2)); //2진수로 바꿔라
		System.out.println(Integer.toString(a, 16));
		
		
		int n1 = 10;
		int n2;
		Integer num1;
		Integer num2 = new Integer(20);
		
		num1 = n1; //오토박싱
		n2 = num2; //오토언박싱
		
		System.out.println(n1+":"+num1);
		System.out.println(n2+":"+num2);

	}

}



/*

int a = 10;
float b;

b = a;        암시적 형변환(10.0) 
b = (float)a; 명시적 형변환
a = b;        에러
a = (int)b;   명시적 형변환

-----------------------------------------------------
B(부모) = A(자식)

B = A;         UPCAST(10.0)
B = (B)A;      명시적 UPCAST
A = B;         에러
A = (A)B;      명시적 DOWNCAST



*/
