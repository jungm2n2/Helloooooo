
package com.day12;
//final을 사용할 수 있는 세가지 경우.
//변수에 final을 사용하면 단 한번만 초기화 가능
//메소드에 final을 사용하면 Override가 불가능
//클래스에 final을 붙이면 상속이 불가능

//final class Super{
class Super{
	
	public static final double PI; //final 변수에 초기화
	
	static {
		PI = 3.14;
		
	}
	
	public double area;
	
	public final void write(String title) {
		System.out.println(title+":"+area);
		
		
	}
	


}
public class Test6 extends Super{
	
	//public void write(String title){ 오버라이드 불가능
		
	public void circleArea(int r) {
		
		area = (double)r*r*PI;
	}
		
	

	public static void main(String[] args) {
		
		
		Test6 ob = new Test6();
		
		
		ob.circleArea(10);
		ob.write("원");
		

	}

}
