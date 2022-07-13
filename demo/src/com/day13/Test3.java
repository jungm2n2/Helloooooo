package com.day13;

import java.util.Scanner;

interface FruitA{
	
	String Won = "��";
	
	public int getPrice();
	public String getName();
	
	
}

interface ItemFruit extends FruitA{
	
	public String getItems();
	
}

class Orange implements ItemFruit{

	@Override
	public int getPrice() {
		
		return 1000;
	}

	@Override
	public String getName() {
		
		return "������";
	}

	@Override
	public String getItems() {
		
		return "����";
	}
	
	
}

class Apple implements ItemFruit{

	@Override
	public int getPrice() {
		
		return 1500;
	}

	@Override
	public String getName() {
		
		return "���";
	}

	@Override
	public String getItems() {
		
		return "����";
	}
	
	
	
	
}

public class Test3 {
	
	public void packing (ItemFruit ob) {
		
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
		
	}
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Test3 t = new Test3();
		
		System.out.print("1.������ 2.���?");
		int n = sc.nextInt();
		
		
		if(n==1)
			t.packing(new Orange());
	
		else if(n==2)
		
			t.packing(new Apple());
		

		
		
		
		
		/*
		  
		int ob1;
		ob1 = 10;
		System.out.println(ob1);
		
		ob1 = 20;
		System.out.println(ob1);
		 
		*/
		
		

	}

}
