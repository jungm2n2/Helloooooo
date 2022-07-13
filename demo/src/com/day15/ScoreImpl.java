package com.day15;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class ScoreImpl implements Score {
	
	private Map<String, ScoreVO> hMap = new TreeMap<>();
	
	Scanner sc = new Scanner(System.in);
	public String hak;
	ScoreVO vo = new ScoreVO();

	@Override
	public void input() {
		System.out.print("학번?");
		hak = sc.next();
		
		if(searchHak(hak)) {
			
			System.out.println("학번이 존재합니다. 추가 실패");
			return;
		}
		
		ScoreVO vo = new ScoreVO();
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		System.out.println("국어?");
		vo.setKor(sc.nextInt());
		
		System.out.println("영어?");
		vo.setEng(sc.nextInt());
		
		System.out.println("수학?");
		vo.setMat(sc.nextInt());
		
		hMap.put(hak, vo);
		System.out.println("학번 추가 성공");
		
	}

	@Override
	public boolean searchHak(String hak) {
		
		return hMap.containsKey(hak);
	}

	@Override
	public void print() {
		
		Iterator<String> it = hMap.keySet().iterator();
		
		while(it.hasNext()) {
			
			String hak = it.next();
			ScoreVO vo = hMap.get(hak);
			System.out.println(hak + ":" + vo.toString());
		}
		
	}

	@Override
	public void delete() {
		
		System.out.println("삭제할 학번?");
		hak = sc.next();
		
		if(searchHak(hak)) {
			hMap.remove(hak);
			System.out.println("삭제 완료!");
		}else {
			System.out.println("입력하신 학번이 존재하지 않습니다.");
		}
		
		
	}

	@Override
	public void update() {
		System.out.println("수정할 학번?");
		hak = sc.next();
		
		if(!searchHak(hak)) {
			System.out.println("입력하신 학번이 존재하지 않습니다");
			return;
		}
		
		ScoreVO vo = hMap.get(hak); //value값 가져옴
		
		System.out.println("국어");
		vo.setKor(sc.nextInt());
		
		System.out.println("수학");
		vo.setMat(sc.nextInt());
		
		System.out.println("영어");
		vo.setEng(sc.nextInt());
		
		hMap.put(hak, vo);
		
		System.out.println("수정 성공");
			
		}
		

		
		
	
		
	

	@Override
	public void findHak() {
		System.out.println("검색할 학번?");
		hak = sc.next();
		
		if(!searchHak(hak)) {
			System.out.println("입력하신 학번이 존재하지 않습니다.");
			return;
		}else {
			ScoreVO vo = hMap.get(hak);
			System.out.println(hak + ":" + vo.toString());
		}
		
		
		
	}

	@Override
	public void findName() {
		
		System.out.println("검색할 이름?");
		String name = sc.next();
		
		boolean flag = false;

		Iterator<String> it = hMap.keySet().iterator();
		
		while(it.hasNext()) {
			
			String hak = it.next();
			ScoreVO vo = hMap.get(hak);
			
			if(name.equals(vo.getName())) {
				System.out.println(hak + ":" + vo.toString());
				flag = true;
			}
			
			
			
		}
		
		if(flag) {
			System.out.println("검색 성공");
		
			
		}else {
			System.out.println("입력하신 이름이 존재하지 않습니다");
		}
		
	}

	
	

}
