package com.day14;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Test2 {
	
	private static String city[] = {"서울","부산","대구","인천","광주","대전","울산"};

	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>();
		System.out.println("초기용량: "+v.capacity() + "개");
		
		for(String c : city) {
			v.add(c);
		}
		
		//v.add(10); String 형태만 들어갈 수 있음. 정수형태x
		
		
		
		String str;
		
		str = v.firstElement(); //index 0
		System.out.println(str);
		
		str = v.get(1);
		System.out.println(str);
		
		str = v.lastElement(); //6
		System.out.println(str);
		
		System.out.println(v.size() + "개");
		
		for(int i=0;i<v.size();i++) {
			
			System.out.print(v.get(i) + " ");
			
		}
		
		System.out.println();
		//----------------------------------------
		for(String c : v) {
			System.out.print(c + " ");
			
		}
		
		System.out.println();
		
		//----------------------------------
		//반복자. Collection의 전용 반복문
		
		Iterator<String> it = v.iterator();
		
		while(it.hasNext()) {//it안에 데이터를 가지고있을때까지
			
			str = it.next(); //하나 꺼내라
			System.out.print(str + " ");
			
		}
		
		while(it.hasNext()) {
			
			str = it.next(); 
			System.out.print(str + " ");
			
		}
		System.out.println();
		
		//변경
		v.set(0, "Seoul");
		v.set(1, "Pusan");
		
		for(String c : v) {
			System.out.print(c + " ");
		}
		
		
		System.out.println();
		
		//삽입
		v.insertElementAt("대한민국", 0);
		System.out.println(v.size() + "개");
		
		for(String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		
		//검색
		int idx = v.indexOf("대구");
		if(idx != -1) {
			System.out.print("검색성공 : " +idx);
		}else {
			
			System.out.println("검색실패 : " + idx);
			
		}
		System.out.println();
		
		
		//오름차순(1->10, a->z)
		Collections.sort(v);
		
		for(String c : v) {
			System.out.print(c + " ");
		
		}
		
		System.out.println();
		
		//내림차순(10->1, z->a)
		Collections.sort(v, Collections.reverseOrder());
		for(String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//삭제
		v.remove("Pusan");
		for(String c : v) {
			System.out.print(c + " ");
		
		}
		System.out.println();
		
		
		System.out.println("공간갯수 : "+v.capacity());
		System.out.println("데이터 갯수 : "+v.size());
		
		//공간 증가
		for(int i=1;i<=20;i++) {
			v.add(Integer.toString(i));
		}
		
		for(String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();

		System.out.println("공간갯수 : "+v.capacity());
		System.out.println("데이터 갯수 : "+v.size());
		
		
		//범위 삭제
		for(int i=1;i<=10;i++) {
			v.remove(5);
		}
		
		
		for(String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();

		System.out.println("공간갯수 : "+v.capacity());
		System.out.println("데이터 갯수 : "+v.size());
		
		
		//빈 공간 삭제
		v.trimToSize();
		System.out.println("공간갯수 : "+v.capacity());
		System.out.println("데이터 갯수 : "+v.size());
		
		//모든 데이터 삭제
		v.clear();
		System.out.println("공간갯수 : "+v.capacity());
		System.out.println("데이터 갯수 : "+v.size());
		
	
	
	
	
	}
}