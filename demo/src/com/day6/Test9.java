package com.day6;

import java.util.Random;
import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		String[] str = {"����","����","��"};
		
		Random rd = new Random();
		
		int com,user;
		
		com = rd.nextInt(3);
		System.out.println(str[com]);
		
		do {
			System.out.print("1:����, 2:����, 3:��. ����� ������?");
			user = sc.nextInt()-1;
		}while(user<0||user>2);
		
		System.out.println("���: "+str[user]+" ��ǻ��: "+str[com]);
		
		String result = "";
		
		if(com==user)
			result="���º� �Դϴ�";
		else if((user+2)%3==com)
			result="����� �̰���ϴ�";
		else
			result="��ǻ�Ͱ� �̰���ϴ�";
		
		System.out.println("���: "+result);
		

	}

}
