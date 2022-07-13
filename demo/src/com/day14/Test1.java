package com.day14;

import java.util.Vector;

//Collection

//�迭 ����
//ũ�Ⱑ �������� �ø��ų� ���̰ų� ������ �Ұ���

//List(I) - ArrayList(C), Vector(C)..
//Map(I) - HashMap(C), HashTable(C)..


public class Test1 {
	
	
	
	
	public static void main(String[] args) {
		
		//<E>:Generic
		Vector v = new Vector<>(); //Object
		
		v.add("����"); //String - upcast ��ĳ��Ʈ
		v.add(30); //Integer
		v.add('A'); //Character
		
		
		String str = (String)v.get(0); //�ٿ�ĳ��Ʈ
		System.out.println(str);

		Integer i = (int) v.get(1);
		System.out.println(i);
		
		Character c = (char) v.get(2);
		System.out.println(c);
		
		
		
		for(int j=0;j<v.size();j++) {
			
			Object ob = v.get(j);
			
			if(ob instanceof String) { //�ٿ�ĳ����
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
