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
		System.out.print("�й�?");
		hak = sc.next();
		
		if(searchHak(hak)) {
			
			System.out.println("�й��� �����մϴ�. �߰� ����");
			return;
		}
		
		ScoreVO vo = new ScoreVO();
		
		System.out.println("�̸�?");
		vo.setName(sc.next());
		
		System.out.println("����?");
		vo.setKor(sc.nextInt());
		
		System.out.println("����?");
		vo.setEng(sc.nextInt());
		
		System.out.println("����?");
		vo.setMat(sc.nextInt());
		
		hMap.put(hak, vo);
		System.out.println("�й� �߰� ����");
		
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
		
		System.out.println("������ �й�?");
		hak = sc.next();
		
		if(searchHak(hak)) {
			hMap.remove(hak);
			System.out.println("���� �Ϸ�!");
		}else {
			System.out.println("�Է��Ͻ� �й��� �������� �ʽ��ϴ�.");
		}
		
		
	}

	@Override
	public void update() {
		System.out.println("������ �й�?");
		hak = sc.next();
		
		if(!searchHak(hak)) {
			System.out.println("�Է��Ͻ� �й��� �������� �ʽ��ϴ�");
			return;
		}
		
		ScoreVO vo = hMap.get(hak); //value�� ������
		
		System.out.println("����");
		vo.setKor(sc.nextInt());
		
		System.out.println("����");
		vo.setMat(sc.nextInt());
		
		System.out.println("����");
		vo.setEng(sc.nextInt());
		
		hMap.put(hak, vo);
		
		System.out.println("���� ����");
			
		}
		

		
		
	
		
	

	@Override
	public void findHak() {
		System.out.println("�˻��� �й�?");
		hak = sc.next();
		
		if(!searchHak(hak)) {
			System.out.println("�Է��Ͻ� �й��� �������� �ʽ��ϴ�.");
			return;
		}else {
			ScoreVO vo = hMap.get(hak);
			System.out.println(hak + ":" + vo.toString());
		}
		
		
		
	}

	@Override
	public void findName() {
		
		System.out.println("�˻��� �̸�?");
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
			System.out.println("�˻� ����");
		
			
		}else {
			System.out.println("�Է��Ͻ� �̸��� �������� �ʽ��ϴ�");
		}
		
	}

	
	

}
