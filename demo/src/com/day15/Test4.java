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
		
		
		Box b1 = new Box(); //�ڷ����� ������ �ʾ����Ƿ� Object
		
		b1.set(30); //Integer,upcast
		Integer i = (Integer)b1.get(); //Object�� 30�̹Ƿ� Integer�� downcast
		System.out.println(i);
		
		Box<Integer> b2 = new Box(); //T�� Integer�� �ٲ�
		b2.set(20);
		i = b2.get();
		System.out.println(i);
		
		Box<String> b3 = new Box<String>();
		b3.set("����");
		String s = b3.get();
		System.out.println(s);
		
		
		
		
		
		

	}

}
