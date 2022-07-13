package com.day8;

import java.util.Scanner;

//this : 클래스. 자기 자신. ME	
class Circle{
	
	private int r; //외부에서 사용 못하도록. 정보의 은닉(캡슐화)
	
	public void setData(int a) { //사용자가 준 값을 private r에 넣는 메소드. 우회도로
		r = a;  
	
		
	//this : 클래스. 자기 자신. ME	
	
	//public void setData(int r) { //setData(int r, Circle this)
	//	this.r(Class의 r) = r(입력받은 r);	
	
	}
	
	public double area() { //area(Circle this)
		
		return r*r*3.14;
		//return this.r*this.r*3.14;
		
	}
	
	public void write(double b) { //write(double a,Circle this)
		//System.out.println("반지름: "+ this.r);
		System.out.println("반지름: "+ r);
		System.out.println("넓이: "+ b);
		
	}
	

}

public class Test1 {

	public static void main(String[] args) {
		
		Circle ob = new Circle();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름?");
		int r = sc.nextInt();
		
		
		ob.setData(r); //setData(r,ob)
		double b = ob.area(); //area(ob)
		ob.write(b); //wirte(a,ob)
		
	}

}
