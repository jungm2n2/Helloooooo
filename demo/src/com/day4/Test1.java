package com.day4;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		
		//반복문(for,while,do~while)
		
		Scanner sc = new Scanner(System.in);
		
		int dan;
		
		System.out.print("단 입력?"); //7단
		dan = sc.nextInt();
		
		
		//for(초기값;최대값;증가값) {}
		
		//시작값과 끝값이 명확히 눈에 보일때 사용
		
		for(int i=1;i<=9;i++) { //i=i+1
			
			//System.out.println(dan + "x" + i + "=" + (dan*i));
			System.out.printf("%dx%d=%d\n",dan,i,(dan*i));
		}
		
		System.out.println("----------------------");
		
		
		//초기값
		//while(최대값) {증가값}
		
		//몇번 반복해야 하는지 모를때 사용
		
		int j=0; //구구단일때는 0이 초기값
		while(j<9) { //초기값이 0일때는 =을 뺀다
			
			j++;
			System.out.println(dan + "x" + j + "=" + (dan*j));
			
			
		}
		
		System.out.println("----------------------");
		
		//초기값
		//do{증가값}while(최대값)
		
		//일단 한번 실행해볼때
		
		
		int k=0;
		do {
			k++;
			System.out.println(dan + "x" + k + "=" + (dan*k));
		}while(k<9);
		
		
		
		//do while 은 무조건 한번은 실행한다.
		
		
		
		
		
		
		
	
		
	}

}
