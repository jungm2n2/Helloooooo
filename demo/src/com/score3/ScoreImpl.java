package com.score3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score{
	
	private List<ScoreVO> lists = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void input() {
		
		int result = 0;
		
		
		
		ScoreVO vo = new ScoreVO();
		
		
		
		System.out.print("학번?");
		vo.setHak(sc.next());
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		System.out.println("국어?");
		vo.setKor(sc.nextInt());
		
		System.out.println("영어?");
		vo.setEng(sc.nextInt());
		
		System.out.println("수학?");
		vo.setMat(sc.nextInt());
		
		lists.add(vo);
		
		//return result;
	}

	@Override
	public void print() {
		
		Iterator<ScoreVO> it = lists.iterator();
		while(it.hasNext()) {
			
			ScoreVO vo = it.next();
			
			System.out.println(vo.toString());
			
			/*System.out.printf("%5s %6s %4d %4d %4d %4d %4.1f\n",
					vo.getHak(),vo.getName(),
					vo.getKor(),vo.getEng(),vo.getMat(),
					(vo.getKor()+vo.getEng()+vo.getMat()),
					(vo.getKor()+vo.getEng()+vo.getMat())/3.0);*/
		}
		
		
		
		
	}

	
	@Override
	public void deleteHak() {
		
		System.out.println("삭제할 학번?");
		String hak = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();
		while(it.hasNext()){
			
			ScoreVO vo = it.next();
			
			if(hak.equals(vo.getHak())) {
				
			lists.remove(vo);
			break;
			
			}	
		
		}
		
	}
	
	
	@Override
	public void searchHak() {
		
		System.out.println("검색할 학번?");
		String hak = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();
		while(it.hasNext()){
			
			ScoreVO vo = it.next();
			
			if(hak.equals(vo.getHak())) {
				
				System.out.println(vo.toString());
				return;
			}
			
		}
		
		
		
		
		
	}
	
	@Override
	public void searchName() {
		
		System.out.println("검색할 이름?");
		String name = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();
		while(it.hasNext()){
			
			ScoreVO vo = it.next();
			
			if(name.equals(vo.getName())) {
				
				System.out.println(vo.toString());
				
			}
		}	
	}

	@Override
	public void descSortTot() {
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			
			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				
				return vo1.getTot()<vo2.getTot()?1:-1;
			}
		};
		
		Collections.sort(lists, comp);
		
		print();
		
		
	}

	@Override
	public void ascSortHak() {
		
	Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			
			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				
				return vo1.getHak().compareTo(vo2.getHak());
			}
		};
		
		Collections.sort(lists, comp);
		
		print();
		/*
		Comparable<ScoreVO> com = new Comparable<ScoreVO>() {

			@Override
			public int compareTo(ScoreVO vo1, ScoreVO vo2) {
				
				return 
			}
		};
		
		
		Collections.sort(lists, com);
		
		print();
		*/
		
		
	}

	
	

}
