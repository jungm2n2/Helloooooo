package com.day15;

import java.util.Hashtable;
import java.util.Iterator;

//Map<key,value> key는 자료형을 많이 쓰지만 value는 거의 class.
//Hashtable(C) - Vector (동기화)
//HashMap(C) - ArrayList

//key는 중복값을 가질수 없다. key-Set(인터페이스)
//key가 중복값을 가지게 되면 제일 마지막 값을 저장하게 된다(수정)
//Map은 iterator가 없다
//(데이터 추가)put-(데이터 가져오기)get


public class Test2 {
	
	public static final String tel1[] = 
		{"111-111","222-222","333-333","111-111","444-444"}; //key
	
	public static final String name[] = 
		{"배수지","유인나","정인선","강아랑","박신혜"}; //value


	public static void main(String[] args) {
		
		Hashtable<String, String> h = new Hashtable<>(); //들어갈 자료형 입력
		
		for(int i=0;i<name.length;i++) {
		h.put(tel1[i],name[i]);
		
		}
		
		System.out.println(h);
		
		String str;
		str=h.get("111-111"); //()안에 key값을 입력하면 value값을 준다
		
		if(str==null) {
			System.out.println("자료 없음!");
		}else {
			System.out.println(str);
		}
		
		if(h.containsKey("222-222")) { //()안에 key값을 입력하면 key값이 존재하는지 찾아주는 메소드
			System.out.println("222-222 있다");
		}else {
			System.out.println("222-222 없다");
		}
		
		if(h.containsValue("강아랑")) { //()안에 value값을 입력하면 value값이 존재하는지 찾아주는 메소드
			System.out.println("강아랑 있다");
		}else {
			System.out.println("강아랑 없다");
		}
		
		Iterator<String> it = h.keySet().iterator(); //Map은 keySet의 iterator를 사용
		
		while(it.hasNext()) {
			
			String key = it.next(); //it.next() 는 key값을 꺼냄. value값 가져올 수 없음.
			String value = h.get(key); //value를 가져옴. str = h.get() 위에참고하기
			
			System.out.print(key+" "+value);
			
		}
		
		
		
		
		
		
		
		
	}

}
