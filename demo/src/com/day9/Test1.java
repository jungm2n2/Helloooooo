package com.day9;

//Overload = Overloading
//메소드 중복 정의
//하나의 클래스 안에서 비슷한 작업을 하는 메소드의 이름은 동일하지만
//매개변수의 갯수가 다르거나 자료형이 다르면
//다른 메소드로 인식한다

class Rect{
	
	private int w,h;
	
	public void set(int w, int h) { //우회도로
		this.w = w; //입력받은 int w와 구분해주기 위해 this 사용
		this.h = h;//입력받은 int h와 구분해주기 위해 this 사용
		
	}
	
	
	public int area() {
		return w*h;
		
	}
	
	public int length() {
		return (w+h)*2;
		
	}
	
	public void print (int a, int l) {
		System.out.println("가로: "+ w);
		System.out.println("세로: "+ h);
		System.out.println("넓이: "+ a);
		System.out.println("둘레: "+ l);
		
	}
	
	public void print() {
		System.out.println("가로: "+ w);
		System.out.println("세로: "+ h);
		
		
	}
	
	public void print(int a) {
		System.out.println("가로: "+ w);
		System.out.println("세로: "+ h);
		System.out.println("넓이: "+ a);
		
	}
	
	//public void dul(int l) { //위의 메소드의 자료형과 갯수가 같기때문에 dul을 print로 바꿀 수 없다.
	public void print(double l) {	//그래서 자료형을 double로 바꿔주고 메소드를 동일한 print로 바꿈
		System.out.println("가로: "+ w);
		System.out.println("세로: "+ h);
		System.out.println("둘레: "+ l);
		
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		Rect ob = new Rect(); //객체생성
		
		ob.set(10, 20);
		
		int area = ob.area();
		int length = ob.length();
		
		
		ob.print();
		ob.print(area);
		ob.print(area,length);
		ob.print((double)length);
	
		
	}

}
