package com.day13;

//4.���� Ŭ����(������, �͸���, Anonymous)

public class Test7 {
	
	public Object getTitle (){
		
		//String str = "������ Ŭ����";
		
		return new Object() {
			
			@Override
			public String toString() {
				
				return "������ Ŭ����";
			}
			
		};
	}
	

	public static void main(String[] args) {
		
		Test7 ob = new Test7();
		System.out.println(ob.getTitle());

	}

}
