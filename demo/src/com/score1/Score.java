package com.score1;

import java.util.Scanner;

public class Score {//�����ϴ� �۾�
	
	
	int inwon;
	//private int inwon; �ܺο��� ������� ���ϰ� private�� ���� �� �ִ�
	
	
	Record[] rec;
	//Record rec; // 7�� ������ �����͸� ������ �� �ִ�.
	//Record[] rec; class ������ �迭�� ����
	
	Scanner sc = new Scanner(System.in);
	
	
	public void set() {
		
		do {
			System.out.print("�ο���?"); //3
			inwon = sc.nextInt();
		}while (inwon<1||inwon>10);
		
		rec = new Record[inwon]; //�迭 ����
		
	}
	
	
	
	public void input() {
		
		
		String[] title = {"����������?","����������?","����������?"}; 
		
		for(int i=0;i<inwon;i++) {
			
			rec[i] = new Record(); //��ü����
			
			System.out.print("�̸��� ����?"); //suzi
			rec[i].name = sc.next();
			
			for(int j=0;j<3;j++) {
				
				System.out.print(title[j]); //30
				rec[i].score[j] = sc.nextInt();
				
				/*System.out.print("����������?"); //30
				rec[i].score[j] = sc.nextInt();
		
				System.out.print("����������?"); //40
				rec[i].score[j] = sc.nextInt();
				
				System.out.print("����������?"); //50
				rec[i].score[j] = sc.nextInt();*/
				
				
				rec[i].tot += rec[i].score[j];
				//rec[0].tot = rec[0].score[0] + rec[0].score[1] + rec[0].score[2];	
				
				//rec[0].ave = rec[0].tot / 3; ������ ������ ���� ��� �ؾ��ϹǷ� ������ ���� 
			
			}
			
			rec[i].ave = rec[i].tot / 3; //������ ������ ���� ��� �ؾ��ϹǷ� ������ ����
		
		}
		
	}
	
	
	private void ranking () { //�ܺ� class���� ���� �Ұ���
		
		int i,j;
		
		//rank �ʱ�ȭ
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
		
		ranking(); //public�޼ҵ忡�� private �޼ҵ带 ȣ���� �� �ִ�.
		
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
