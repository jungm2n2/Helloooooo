package com.score4;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreImpl implements Score {
	
	private Map<String, ScoreVO> hMap = new TreeMap<>();
	
	Scanner sc = new Scanner(System.in);
	String hak;
	

	@Override
	public void input() {
		System.out.print("학번?"); //key값
		hak = sc.next();
		
		if(searchHak(hak)) {
			System.out.println("학번이 존재합니다. 추가 실패");
			return;
		}
		
		ScoreVO vo = new ScoreVO(); //Value에 넣어야 하므로
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		System.out.println("국어");
		vo.setKor(sc.nextInt());
		
		System.out.println("수학");
		vo.setMat(sc.nextInt());
		
		System.out.println("영어");
		vo.setEng(sc.nextInt());
		
		
		hMap.put(hak, vo); //Map에 입력값 집어넣기
		System.out.println("추가 성공");
		
	}

	@Override
	public boolean searchHak(String hak) {
		
		/*if(hMap.containsKey(hak)) {
			return true;
		}

		return false;*/
		
		return hMap.containsKey(hak); //결과값이 True or False
		
	}

	@Override
	public void print() {
		
		Iterator<String> it = hMap.keySet().iterator(); //key
		
		while(it.hasNext()) {
			
			String hak = it.next(); //key값
			ScoreVO vo = hMap.get(hak); //value값 
			
			System.out.println(hak + ":" + vo.toString());
			
			
			
		}
		
	}

	@Override
	public void delete() {
		
		System.out.println("삭제할 학번?");
		hak = sc.next();
		
			if(searchHak(hak)) {
				 hMap.remove(hak);
				 System.out.println("삭제 성공");
			}else 
				System.out.println("입력하신 학번이 존재하지 않습니다");
			
	}
		
	@Override
	public void update() {
		System.out.println("수정할 학번?");
		hak = sc.next();
		
		if(!searchHak(hak)) {
			System.out.println("수정할 학번이 존재하지 않습니다");
			return;
		}
		
		
/*		방법1
		ScoreVO pVO = hMap.get(hak);//value
		
		
		ScoreVO vo = new ScoreVO();
		
		vo.setName(pVO.getName());
		
		System.out.println("국어");
		vo.setKor(sc.nextInt());
		
		System.out.println("수학");
		vo.setMat(sc.nextInt());
		
		System.out.println("영어");
		vo.setEng(sc.nextInt());
		
		hMap.put(hak, vo);
*/
		
		
		//방법2
		
		
		ScoreVO vo = hMap.get(hak);
		
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
			System.out.println("입력하신 학번이 존재하지 않습니다");
			return;
		}else {
			ScoreVO vo = hMap.get(hak); //value값 
			System.out.println(hak + ":" + vo.toString());
		}
		
	}

	@Override
	public void findName() {
		System.out.println("검색할 이름?");
		String name = sc.next();
		
		
		Iterator<String> it = hMap.keySet().iterator(); //key
		
		
		boolean flag = false; //기본값
		
		
		while(it.hasNext()) {
			
			String hak = it.next(); //key값
			ScoreVO vo = hMap.get(hak); //value값 
			
			
			if(name.equals(vo.getName())) {
				System.out.println(hak + ":" + vo.toString());
				flag = true;
			}
			
		
		}
		
		if(flag) {
			System.out.println("검색성공!");
		}else {
			System.out.println("입력하신 이름이 존재하지 않습니다");
		}
	}

}
