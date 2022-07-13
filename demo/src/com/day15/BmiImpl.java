package com.day15;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class BmiImpl implements Bmi {
	
	private Map<String, BmiVO> hMap = new TreeMap<>();
	
	String num;
	Scanner sc = new Scanner(System.in);

	@Override
	public void input() {
	
		System.out.println("회원번호?");
		num = sc.next();
		
		if(searchNum(num)) {
			System.out.println("입력하신 회원번호가 존재합니다.");
			return;
		}
		
		BmiVO vo = new BmiVO();
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		System.out.println("몸무게?");
		vo.setWeg(sc.nextDouble());
		
		System.out.println("키?");
		vo.setHei(sc.nextDouble());
		
		hMap.put(num, vo);
		
		System.out.println("회원번호 추가 완료");
		
		
	}

	@Override
	public boolean searchNum(String num) {
		
		return hMap.containsKey(num);
	}

	@Override
	public void print() {
		Iterator<String> it = hMap.keySet().iterator();
		
		while(it.hasNext()) {
			
			String num = it.next();
			BmiVO vo = hMap.get(num);
			
			System.out.println(num+" : "+vo.toString());
			
			
		}
		
		
	}

	@Override
	public void delet() {
		System.out.println("삭제할 회원번호?");
		num = sc.next();
		
		if(!searchNum(num)) {
			System.out.println("입력하신 회원번호가 존재하지 않습니다");
			return;
		}else {
			hMap.remove(num);
			System.out.println("회원번호 삭제 완료");
		}
		
		
		
	}

	@Override
	public void update() {
		System.out.println("수정할 회원번호?");
		num = sc.next();
		
		if(!searchNum(num)) {
			System.out.println("입력하신 회원번호가 존재하지 않습니다");
			return;
		}
		
		
		BmiVO vo =  hMap.get(num);
		
		System.out.println("몸무게?");
		vo.setWeg(sc.nextDouble());
		
		System.out.println("키?");
		vo.setHei(sc.nextDouble());
		
		hMap.put(num, vo);
		System.out.println("수정 완료");
		
		
		
		
	}

	@Override
	public void findnum() {
		System.out.println("검색할 회원번호?");
		num = sc.next();
		
		if(!searchNum(num)) {
			System.out.println("입력하신 회원번호가 없습니다");
			return;
		}
		BmiVO vo = hMap.get(num);
		System.out.println(num+" : "+vo.toString());
		
		
		
	}

	@Override
	public void findName() {
		
		System.out.println("검색할 이름?");
		String name = sc.next();
		
		boolean flag = false;

		Iterator<String> it = hMap.keySet().iterator();
		
		while(it.hasNext()) {
			
			String num = it.next();
			BmiVO vo = hMap.get(num);
			
			if(name.equals(vo.getName())) {
				System.out.println(num + ":" + vo.toString());
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
