package com.day7;

import java.util.Scanner;

public class Order {
	
	
	int num1,num2,num3,temp;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("���� 3����?");
		num1=sc.nextInt();
		num2=sc.nextInt();
		num3=sc.nextInt();
		
	}
	
	public void pan() {
		
		if (num1>num2){
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if (num2>num3){
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		if (num1>num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		
		
	}
	
	public void print () {
		
		System.out.printf("%d,%d,%d", num1,num2,num3);
		
	}
	
	

}



/*3���� ���� �Է¹޾� ���� ������ ū �� ������ ����

Scanner sc =  new Scanner(System.in);

int num1,num2,num3,temp;

System.out.print("���� 3����?");
num1=sc.nextInt();
num2=sc.nextInt();
num3=sc.nextInt();

if (num1>num2){
	temp = num1;
	num1 = num2;
	num2 = temp;
}
if (num2>num3){
	temp = num2;
	num2 = num3;
	num3 = temp;
}
if (num1>num2) {
	temp = num1;
	num1 = num2;
	num2 = temp;
}


System.out.printf("%d,%d,%d", num1,num2,num3);*/