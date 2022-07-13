package com.day17;

import java.util.Random;
import java.util.Scanner;

class Sadari2 extends Thread{
	
	@Override
	public void run() {
		
	
		System.out.print("고민중");
		
		for(int i=0;i<10;i++) {
			System.out.print(".");
		
		try {
			
			sleep(1000);
				
			}
			
		 catch (Exception e) {
			
		}
		
		
	
	}
		System.out.println();
		System.out.println("축하합니다!! 발표자입니다!!");
		
		
		
		
	}
	
	
	
	
}




public class Test11 {

	public static void main(String[] args) {
		
		Random rd = new Random();
		int num;
		int num2 [];
	
		String[] name = 
			{"오세라","안수언","엄희성","김성현","윤다영",
			"김희진","이동우","최재혁","김홍수","서수현",
			"윤재일","정영진","박선미","전은지","류창주",
			"김수지","이은지","박수정","정성경","심민정",
			"윤채련","김영운","안시연","이정민","박수진",
			"윤서혜","정민정"};
		
		
		//Scanner sc = new Scanner(System.in);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("발표자 인원수?");
		
		num = sc.nextInt();
		num2 = new int[num];
		
		Sadari2 sd= new Sadari2();
		sd.start();
		

	//	try {
	//		Thread.sleep(1000);
			
	//	} catch (Exception e) {
			
	//	}
		

		try {
			sd.join();
		} catch (Exception e) {
		
		}
		
		
		int n;
		n=0;
		
		while(n<num) {
			
			num2[n] = rd.nextInt(27);
			
			for(int i=0;i<n;i++) {
				
				if(num2[i]==num2[n]) {
					n--;
					break;
				}
					
			}
			
			n++;
			
		}
		
		for(int i=0;i<num;i++) {
			
			System.out.printf("%d번 발표자 : %s\n",i+1,name[num2[i]]);
			
		}
		

	
		
	}
		
		

	}


