package com.day15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.SynchronousQueue;





public class Test3 {

	public static void main(String[] args) {
		
		//Set : 중복값 허용 안함
		
		Set<String> s = new HashSet<>();
		
	
		s.add("서울");
		s.add("부산");
		s.add("대구");
		
		System.out.println(s);
		
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
		
		s.add("서울");
		System.out.println(s);
		
		//Stack
		Stack<String> st = new Stack<>();
		
		st.push("서울");
		st.push("부산");
		st.add("광주");
		
		while(!st.empty()) { //st의 내용이 비어있지 않을때까지 -> 출력 데이터가 있을때까지
			System.out.println(st.pop() +" "); //반대로 출력
			
		}
		
		
		//Queue
		Queue<String> q = new LinkedList<>();
		q.offer("부산");
		q.offer("대구");
		q.add("울산");
		
		while(q.peek()!=null) {//데이터가 있을때까지
			System.out.print(q.poll() + " ");
			
		}
		
		List<String> list1 = new LinkedList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");
		list1.add("f");
		list1.add("g");
		list1.add("h");
		list1.add("i");
		
		List<String> list2 = new LinkedList<>();
		list2.add("서울");
		list2.add("부산");
		list2.add("대구");
		
		list2.addAll(list1);
		
		System.out.println("\nlist1");
		for(String ss : list1) {
			System.out.print(ss+" ");
		}
		System.out.println("\n-------");
		System.out.println("list2");
		for(String ss : list2) {
			System.out.print(ss+" ");
		}
		System.out.println("\n-------\n");
		
		list2.subList(2,5).clear(); //2부터 5의 전까지 삭제
		for(String ss : list2) {
			System.out.print(ss+" "); 
		}
		System.out.println("\n-------\n");
		
		//배열
		String[] str = {"마","바","라","나","다","가"};
		
		for(String sss : str) 
			System.out.print(sss+" ");
			System.out.println();
			
		Arrays.sort(str);
		for(String sss : str) 
			System.out.print(sss+" ");
			System.out.println();
			
		}
	

	

}
