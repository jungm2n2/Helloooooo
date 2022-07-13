package com.score1;

import java.util.Scanner;

public class Score {//실행하는 작업
	
	
	int inwon;
	//private int inwon; 외부에서 사용하지 못하게 private로 만들 수 있다
	
	
	Record[] rec;
	//Record rec; // 7개 형태의 데이터를 저장할 수 있다.
	//Record[] rec; class 형태의 배열을 만듬
	
	Scanner sc = new Scanner(System.in);
	
	
	public void set() {
		
		do {
			System.out.print("인원수?"); //3
			inwon = sc.nextInt();
		}while (inwon<1||inwon>10);
		
		rec = new Record[inwon]; //배열 생성
		
	}
	
	
	
	public void input() {
		
		
		String[] title = {"국어점수는?","영어점수는?","수학점수는?"}; 
		
		for(int i=0;i<inwon;i++) {
			
			rec[i] = new Record(); //객체생성
			
			System.out.print("이름이 뭐니?"); //suzi
			rec[i].name = sc.next();
			
			for(int j=0;j<3;j++) {
				
				System.out.print(title[j]); //30
				rec[i].score[j] = sc.nextInt();
				
				/*System.out.print("국어점수는?"); //30
				rec[i].score[j] = sc.nextInt();
		
				System.out.print("영어점수는?"); //40
				rec[i].score[j] = sc.nextInt();
				
				System.out.print("수학점수는?"); //50
				rec[i].score[j] = sc.nextInt();*/
				
				
				rec[i].tot += rec[i].score[j];
				//rec[0].tot = rec[0].score[0] + rec[0].score[1] + rec[0].score[2];	
				
				//rec[0].ave = rec[0].tot / 3; 총점이 나오고 나서 계산 해야하므로 밖으로 빼기 
			
			}
			
			rec[i].ave = rec[i].tot / 3; //총점이 나오고 나서 계산 해야하므로 밖으로 빼기
		
		}
		
	}
	
	
	private void ranking () { //외부 class에서 접근 불가능
		
		int i,j;
		
		//rank 초기화
		for(i=0;i<inwon;i++) {
			rec[i].rank = 1;
		}
		
		
		for(i=0;i<inwon-1;i++) {
			for(j=i+1;j<inwon;j++) {
				
				if(rec[i].tot>rec[j].tot)
					rec[j].rank++;
				else if (rec[i].tot<rec[j].tot)
				rec[i].rank++;
				
				
			}
		
		}
		
	}
	
	
	public void print() { 
		
		ranking(); //public메소드에서 private 메소드를 호출할 수 있다.
		
		for(int i=0;i<inwon;i++) {
			System.out.printf("%6s",rec[i].name);
			
			for(int j=0;j<3;j++) {
				System.out.printf("%4d",rec[i].score[j]);
				
			}
			
			System.out.printf("%4d",rec[i].tot);
			System.out.printf("%4d",rec[i].ave);
			System.out.printf("%4d\n",rec[i].rank);
	
		}
		
	}
	
}
