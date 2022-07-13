package com.score6;

import java.net.StandardSocketOptions;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Score { //사용자한테 데이터를 받아내는 역할의 클래스
	
	Scanner sc = new Scanner(System.in);
	ScoreDAO dao = new ScoreDAO();
	List<ScoreDTO> lists = null;
	
	
	//입력
	public void insert () {
		
		ScoreDTO dto = new ScoreDTO();
		
		System.out.print("학번?");
		dto.setHak(sc.next());
		
		System.out.print("이름?");
		dto.setName(sc.next());
		
		System.out.print("국어?");
		dto.setKor(sc.nextInt());
		
		System.out.print("영어?");
		dto.setEng(sc.nextInt());
		
		System.out.print("수학?");
		dto.setMat(sc.nextInt());
		
		//dao.insertData(dto); //scoredao한테 dto주기
		
		int result = dao.insertData(dto); //반환값은 1 or 0
		
		if(result!=0) {
			System.out.println("추가 성공!!");
		}else {
			System.out.println("추가 실패!!");
		}
		
		
	}
	
	//수정
	public void update() {
		
		ScoreDTO dto = new ScoreDTO();
		
		System.out.print("수정할 학번?");
		dto.setHak(sc.next());
		
		System.out.print("국어?");
		dto.setKor(sc.nextInt());
		
		System.out.print("영어?");
		dto.setEng(sc.nextInt());
		
		System.out.print("수학?");
		dto.setMat(sc.nextInt());
		
		int result = dao.updateData(dto);
		
		if(result!=0) {
			System.out.println("수정 성공!!");
		}else {
			System.out.println("수정 실패!!");
		}
		
		
		
	}
	
	
	
	
	//삭제
	public void delete() {
	
	/*
		ScoreDTO dto = new ScoreDTO();
		
		System.out.print("삭제할 학번?");
		dto.setHak(sc.next());
		
		int result = dao.deleteData(dto);
		
		if(result!=0) {
			System.out.println("삭제 성공!!");
		}else {
			System.out.println("삭제 실패!!");
		}
	*/
		
		
		System.out.print("삭제할 학번?");
		String hak = sc.next();
		
		int result = dao.deleteData(hak);
		
		if(result!=0) {
			System.out.println("삭제 성공!!");
		}else {
			System.out.println("삭제 실패!!");
		}
		
		

	
	
	}
	
	public void print() { //반복 출력하는 메소드 따로 빼기
		
		Iterator<ScoreDTO> it = lists.iterator();
		
		while(it.hasNext()) {
		
			ScoreDTO dto = it.next();
			
			if(dto.getRank()==0) 
		
				System.out.println(dto.toString());
			
			else
				System.out.println(dto.toString() + "  "+dto.getRank());
		
		
	}
		
		
		
		
		
	}
	
	//이름검색
	public void searchName() {
		
		System.out.print("검색할 이름?");
		String name = sc.next();
		
		lists = dao.getList(name);
		
		if(lists.size()!=0)
			print();
		else
			System.out.println("찾는 이름이 없습니다");
		
		

		
	}
	
	
	//전체출력
	public void selectAll() {
			
		lists = dao.getList();
			
		print();
				
				
		}
		
	//학번검색
	public void searchHak() {
		
		System.out.print("검색할 학번?");
		String hak = sc.next();
		
		ScoreDTO dto = dao.getLists(hak);
		
		if(dto!=null) {
			System.out.println(dto.toString());
		}else {
			System.out.println("찾는 학번이 없습니다.");
		}
		
		
		
	}
		
		
		
		
		
	
	}
	

