package com.day9;

import java.util.Calendar;

//Call By Value
//stack������ value�� heap �������� �Ѿ

//Call By Reference
//heap������ �ּҰ� stack �������� �Ѿ


class Test{
	
	public int x = 10;
	
	public void sub(int a) {
		x+=a;  //x=x+a;
	}
	
}


public class Test6 {

	public static void main(String[] args) {
		
		Test ob = new Test(); //��ü ����
		
		//call by value
		int a = 20;
		
		System.out.println("sub()�޼ҵ� ������ x: "+ob.x);
		ob.sub(a);
		System.out.println("sub()�޼ҵ� ������ x: "+ob.x);
		
		//Call By Reference
		
		Test ob1;
		ob1 = ob; //�ּҰ���
		
		System.out.println("ob.x : "+ob.x);
		System.out.println("ob1.x : "+ob1.x);
		
		ob1.x=100;
		System.out.println("ob.x : "+ob.x);
		System.out.println("ob1.x : "+ob1.x);
		
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
	
		
		

	}

}
