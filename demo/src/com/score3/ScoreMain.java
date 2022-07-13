package com.score3;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		
		ScoreVO vo = new ScoreVO();

		Scanner sc = new Scanner(System.in);
		
		Score ob = new ScoreImpl();
		
		int ch;
		
		while(true) {
			
			do {
				System.out.print("1.입력 \n2.출력 \n3.학번삭제 \n4.학번검색 \n5.이름검색 "+
								"\n6.총점내림차순정렬 \n7.학번오름차순정렬 \n8.종료 ?");
				System.out.print("\n------------------------------\n");
				System.out.print(":  ");
				ch = sc.nextInt();
			} while(ch<1);
			
			
			switch(ch) {
				case 1:
					ob.input();break;
				case 2:
					ob.print();break;
				case 3:
					ob.deleteHak();break;
				case 4:
					ob.searchHak();break;
				case 5:
					ob.searchName();break;
				case 6:
					ob.descSortTot();break;
				case 7:	
					ob.ascSortHak();break;
				default:
					System.out.println("시스템을 종료합니다");
					System.exit(0);
				
			}
			
		}
		
	}

}




		
		/*vo.setHak("a123");
		vo.setName("배수지");
		vo.setKor(90);
		vo.setEng(80);
		vo.setMat(70);
		
		String str = vo.toString();
		
		System.out.println(str);
		
		System.out.println(vo.getHak());
		System.out.println(vo.getKor());
		
		//-------------------
		
		ScoreVO vo1 = new ScoreVO("222", "강아랑", 80 , 90, 70);
		
		str = vo1.print();
		System.out.println(str);*/

