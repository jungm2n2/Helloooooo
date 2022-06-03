package com.day6;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		//열명 이내의 이름과 점수를 입력 받아
		//석차 구하기
		
		Scanner sc = new Scanner(System.in);
		
		String[] name; //몇개 입력할지 모르니까 아래에서 선언해줄거임.
		int[] score ;
		int[] rank;
		
		
		
		int i,j,temp1,inwon;
		String temp2;
		
		
		do {
			System.out.print("인원수?[1~10]"); //3
			inwon = sc.nextInt();
		}while(inwon<1||inwon>10);
		
		//배열의 메모리 할당(배열 객체생성)
		name = new String [inwon];
		score = new int [inwon];
		rank = new int [inwon];
		
		for(i=0;i<inwon;i++) {
			System.out.print((i+1)+"번째 이름?");
			name[i]=sc.next();
			
			System.out.print("점수?");
			score[i]=sc.nextInt();
			
		}
		//석차(rank) 초기화 작업. +1해주기
		
		for(i=0;i<inwon;i++) {  //{}삭제 가능
			rank[i]=1;
		}
		
		//Selection sort(정렬) 
		//석차계산
		
		
		for(i=0;i<inwon-1;i++) {
			for(j=i+1;j<inwon;j++) {
				
				
				//낮은 점수의 rank+1 해줌
				
					
				if(score[i]>score[j]) 
					rank[j]++;
				
				else if(score[i]<score[j])
					rank[i]++;
					
					
				}		
					
				
			}
		
		
	
		
		
		
		//출력
		for(i=0;i<inwon;i++) {
			System.out.printf("%6s %4d %4d\n",name[i],score[i],rank[i]);
		}
		
		
		
		
		
		
		
		}

	

}
