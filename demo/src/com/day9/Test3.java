package com.day9;

class RectA{
	
	private int w,h;
	
	public RectA() {} //기본생성자
		
	public RectA(int w, int h) { //우회도로 없이 바로 초기화. 오버로딩된 생성자
		
		this.w = w;
		this.h = h;
				
	}
	
	public void set(int w, int h) {//기본생성자 -> 우회도로. 초기화 메소드
		this.w = w;
		this.h = h;
	}
	
	public int area() {
		return w*h;
	}
	
	public int length() {
		return (w+h)*2;
	}
	
	public void print(int a) {
		System.out.println("가로: "+w+",세로: "+h);
		System.out.println("넓이: "+a);

	}
	
	//메소드 오버로딩
	public void print(int a, int l) {//매개변수 갯수를 다르게 해서 오버로딩
		System.out.println("가로: "+w+",세로: "+h);
		System.out.println("넓이: "+a);
		System.out.println("둘레: "+l);
		
	}
	
	
}

public class Test3 {

	public static void main(String[] args) {
		
		RectA ob1 = new RectA(); //기본생성자
		ob1.set(10, 20); //기본생성자는 우회도로를 통해 초기화.
		int a = ob1.area();
		int l = ob1.length();
		ob1.print(a);
		ob1.print(a, l);
		
		System.out.println("-----------------------");
		
		RectA ob2 = new RectA(100, 200); //오버로딩된 
		a = ob2.area();
		l = ob2.length();
		ob2.print(a);
		ob2.print(a, l);
		
		
		
		
		
		
		

	}

}
