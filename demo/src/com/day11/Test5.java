package com.day11;

public class Test5 {

	public static void main(String[] args) {
		
		String s1 = "서울,부산,대구";
		String ss [] = s1.split(","); //s1 안에 있는 데이터를 쉼표(,)로 구분해서 배열에 넣어라.
		
		for(String s : ss) {
			System.out.print(s + " ");
			
		}
		
		System.out.println();
		
		String s2 = "seoul";
		String s3 = "Seoul";
		System.out.println(s2==s3); //주소 비교. false
		System.out.println(s2.equals(s3)); //데이터 비교. false
		System.out.println(s2.equalsIgnoreCase(s3)); //대소문자 가리지 말고 비교하라
		
		String s4 = "abc.def.hij";
		//index :    01234567890 //String은 자동으로 index번호를 갖는다
		System.out.println(s4.indexOf(".")); //앞에서부터 첫번째로 만나는 '.'의 index 위치. 3
		System.out.println(s4.lastIndexOf(".")); //뒤에서부터 첫번째로 만나는 '.'의 index 위치. 7
		System.out.println(s4.indexOf("def")); //def로 시작되는 시작 index 값. 4
		System.out.println(s4.indexOf("x")); //x를 찾아라. 데이터가 없으니까 -1
		
		
		String s5 = "우리나라 대한민국 좋은나라 대한민국";
		String s6 = s5.replaceAll("대한", "大韓"); //대한을 한자로 바꿔라
		System.out.println(s6);
		
		String s7 = "  a  b  c  ";
		System.out.println(s7);
		System.out.println(s7.trim());//양쪽의 공백을 없애라
		System.out.println(s7.replaceAll(" ", ""));
		System.out.println(s7.replaceAll("\\s", "")); //모든 언어에서 공통으로 사용하는 문자. 정규화 표현식
		
		
		char ch = "abcdefg".charAt(2);
		System.out.println(ch);
		System.out.println(Integer.toString(ch));
		
		
		System.out.println("abcdefg".startsWith("abc")); //abc로 시작 하는가. true
		System.out.println("자바프로그램".startsWith("자바"));
		
		System.out.println("abcdefg".length()); //7
		
		String s8 = "abcdefg";
		String s9 = "abcdffg";
		
		//사전식 정렬 ((ASCII)코드값의 차이)
		System.out.println(s8.compareTo(s9)); //-1 아스키값으로 비교
		System.out.println(s9.compareTo(s8)); //1
		

	}

}
