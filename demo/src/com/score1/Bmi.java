package com.score1;

import java.util.Scanner;

public class Bmi {
	
	
	int inwon;
	
	Inform rd [];
	Scanner sc = new Scanner(System.in);
	
	
	
	
	public void set () {
	
		do {
			System.out.print("����ΰ���?");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		rd = new Inform[inwon];
		
	
	}
	
	
	public void input() {
		
		
		for(int i=0;i<inwon;i++) {
			rd[i] = new Inform();
			
			System.out.print("�̸���?");
			rd[i].name = sc.next();
			System.out.print("�����Դ�?");
			rd[i].w = sc.nextInt();
			System.out.print("Ű��?");
			rd[i].h = sc.nextInt();
			
			rd[i].bmi = rd[i].w/(rd[i].h*0.01*rd[i].h*0.01);
			
	       	}
		
		String [] pan1 = {"����","��","��ü��","����","��ü��"};
		
		for(int i=0;i<inwon;i++) {
			
			if	(rd[i].bmi>=30) {
				rd[i].pan = pan1[0];
			}else if(rd[i].bmi>=25) {
				rd[i].pan = pan1[1];
			}else if(rd[i].bmi>=23) {
				rd[i].pan = pan1[2];
			}else if(rd[i].bmi>=18.5) {
				rd[i].pan = pan1[3];
			}else  {
				rd[i].pan = pan1[4];
		}
				
		}
	}
		
	
	
	public void print() {
		
		for(int i=0;i<inwon;i++) {
			System.out.printf("%s�� bmi�� %.2f�̸� %s�Դϴ�.\n",rd[i].name,rd[i].bmi,rd[i].pan);
			
			
			
		}
		}
	}


