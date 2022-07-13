package com.day14;

import java.util.Vector;

//Collection

//배열 단점
//크기가 정해지면 늘리거나 줄이거나 삽입이 불가능

//List(I) - ArrayList(C), Vector(C)..
//Map(I) - HashMap(C), HashTable(C)..


public class Test1 {
	
	
	
	
	public static void main(String[] args) {
		
		//<E>:Generic
		Vector v = new Vector<>(); //Object
		
		v.add("서울"); //String - upcast 업캐스트
		v.add(30); //Integer
		v.add('A'); //Character
		
		
		String str = (String)v.get(0); //다운캐스트
		System.out.println(str);

		Integer i = (int) v.get(1);
		System.out.println(i);
		
		Character c = (char) v.get(2);
		System.out.println(c);
		
		
		
		for(int j=0;j<v.size();j++) {
			
			Object ob = v.get(j);
			
			if(ob instanceof String) { //다운캐스팅
				str = (String)ob;
				System.out.println(str);
				
			}else if (ob instanceof Integer) {
				i = (int)ob;
				System.out.println(i);
				
			}else if (ob instanceof Character) {
				c = (char)ob;
				System.out.println(c);
			}
			
		}
		
		
	}

}
