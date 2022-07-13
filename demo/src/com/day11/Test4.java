package com.day11;

public class Test4 {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("서울");
		sb.append("부산");
		
		System.out.println(sb); //주소가 아닌 데이터를 보여줌
		
		String str = sb.toString();
		System.out.println(str);

	}

}
