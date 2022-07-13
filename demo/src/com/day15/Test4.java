package com.day15;

//Generic

class Box<T> {
	
	private T t;
	
	public void set(T t) { //setter
		this.t=t;
	
	}
	
	public T get() { //getter
		return t;
		
	}
	
	
	
}




public class Test4 {

	public static void main(String[] args) {
		
		
		Box b1 = new Box(); //자료형을 정하지 않았으므로 Object
		
		b1.set(30); //Integer,upcast
		Integer i = (Integer)b1.get(); //Object의 30이므로 Integer로 downcast
		System.out.println(i);
		
		Box<Integer> b2 = new Box(); //T가 Integer로 바뀜
		b2.set(20);
		i = b2.get();
		System.out.println(i);
		
		Box<String> b3 = new Box<String>();
		b3.set("서울");
		String s = b3.get();
		System.out.println(s);
		
		
		
		
		
		

	}

}
