package com.day7;

import java.util.Scanner;

class Hap{
	
	int su,sum;
	
	public void input() {
		
		Scanner sc =  new Scanner(System.in);
		
		System.out.print("�����Է�?");
		su = sc.nextInt();
		
		
	}
	
	public int cnt() {
		
		
		for(int i=1;i<=su;i++) {
			sum+=i;
		}
		return sum;
	}
	
	public void print(int i) {
		System.out.println("1���� "+su+"������ ��: "+i);
	}
	
}


public class Test3 {

	public static void main(String[] args) {
		
		Hap h = new Hap();
		
		h.input();
		int i = h.cnt();
		h.print(i);
		
		
		

	}

}
