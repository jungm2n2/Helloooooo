package com.day20;

import java.net.InetAddress;
import java.util.Scanner;

//Network





public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String host;
		
		System.out.println("ȣ��Ʈ[www.naver.com]");
		host = sc.next();
		
		try {
			
			InetAddress ia = InetAddress.getByName(host);
			System.out.println("ip�ּ�: "+ia.getHostAddress());
			System.out.println("ȣ��Ʈ: "+ia.getHostName());
			
		} catch (Exception e) {
		
		}
		
		
		
		
		
		
		

	}

}
