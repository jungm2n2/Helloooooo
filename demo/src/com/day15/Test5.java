package com.day15;

class Box2<T>{
	
	private T t;
	
	public void set(T t) {
		this.t = t;
		
	}
	
	public T get() {
		return t;
	}
	
	public<U> void print(U u) {//메소드의 자료형을 
		
		System.out.println(u);
		System.out.println("t 클래스: "+t.getClass().getName());
		System.out.println("u 메소드: "+u.getClass().getName());
		
	}
	
	
	
}



public class Test5 {

	public static void main(String[] args) {
		
		Box2<Integer> b = new Box2<Integer>(); //T는 전부 Integer
		
		b.set(30);
		b.print("test");
		b.print(50);
		b.print('a');

	}

}
