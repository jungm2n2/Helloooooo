package com.day8;

import java.util.Scanner;

//this : Ŭ����. �ڱ� �ڽ�. ME	
class Circle{
	
	private int r; //�ܺο��� ��� ���ϵ���. ������ ����(ĸ��ȭ)
	
	public void setData(int a) { //����ڰ� �� ���� private r�� �ִ� �޼ҵ�. ��ȸ����
		r = a;  
	
		
	//this : Ŭ����. �ڱ� �ڽ�. ME	
	
	//public void setData(int r) { //setData(int r, Circle this)
	//	this.r(Class�� r) = r(�Է¹��� r);	
	
	}
	
	public double area() { //area(Circle this)
		
		return r*r*3.14;
		//return this.r*this.r*3.14;
		
	}
	
	public void write(double b) { //write(double a,Circle this)
		//System.out.println("������: "+ this.r);
		System.out.println("������: "+ r);
		System.out.println("����: "+ b);
		
	}
	

}

public class Test1 {

	public static void main(String[] args) {
		
		Circle ob = new Circle();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������?");
		int r = sc.nextInt();
		
		
		ob.setData(r); //setData(r,ob)
		double b = ob.area(); //area(ob)
		ob.write(b); //wirte(a,ob)
		
	}

}
