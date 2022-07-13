package com.score1;

import java.util.Scanner;

public class Pyo {
	
	
	int inwon;
	
	Jungbo jb [];
	Scanner sc = new Scanner(System.in);
	
	
	
	
	public void set () {
	
		do {
			System.out.print("몇명인가요?");
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		jb = new Jungbo[inwon];
		
	
	}
	
	
	public void input() {
		
		String[] title = {"국어점수는?","영어점수는?","수학점수는?"};
		
		for(int i=0;i<inwon;i++) {
			jb[i] = new Jungbo();
			
			System.out.print("이름은?");
			jb[i].name = sc.next();
			
			for(int j=0;j<3;j++) {
				
				System.out.print(title[j]);
				
				jb[i].su[j]= sc.nextInt();
				
				jb[i].tot += jb[i].su[j];
				
			}
			
			
			jb[i].ave = jb[i].tot/3;
			
	       }
		
/*
		private String panjung(int jumsu) {
		
		String pan;
		
		switch(jumsu/10) {
		
		case 10:
		case 9:
			pan = "수"; break;
		case 8:
			pan = "우" ;break;
		case 7:
			pan = "미" ;break;
		case 6:
			pan = "양" ;break;
		default :
			pan = "가"; break;
		
		}
		
		return pan;
	}
		
	*/	
		
		
		
		
		String [] pan1 = {"(수)","(우)","(미)","(양)","(가)"};
		
		for(int i=0;i<inwon;i++) {
			
			for(int j=0;j<3;j++) {
				
			if	(jb[i].su[j]>=90) {
				jb[i].pan[j] = pan1[0];
			}
			else if(jb[i].su[j]>=80) {
				jb[i].pan[j] = pan1[1];
			}
			else if(jb[i].su[j]>=70) {
				jb[i].pan[j] = pan1[2];
			}
			else if(jb[i].su[j]>=60) {
				jb[i].pan[j] = pan1[3];
			}
			else  {
				jb[i].pan[j] = pan1[4];
				
				}
			}
		}
	}

	
	
	public void print() {
		
		for(int i=0;i<inwon;i++) {
			System.out.printf("%6s",jb[i].name);
			
			for(int j=0;j<inwon;j++) {
				System.out.printf("%4d",jb[i].su[j]);
				System.out.printf("%4s",jb[i].pan[j]);
				//System.out.printf("%4s (%s)",jb[i].pan[j],panjung(jb[i].pan[j]));

			}
			
			System.out.printf("%4d",jb[i].tot);
			System.out.printf("%4d\n", jb[i].ave);
	
		}
		
	}
}


