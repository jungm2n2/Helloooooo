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
		System.out.print("�й�?"); //key��
		hak = sc.next();
		
		if(searchHak(hak)) {
			System.out.println("�й��� �����մϴ�. �߰� ����");
			return;
		}
		
		ScoreVO vo = new ScoreVO(); //Value�� �־�� �ϹǷ�
		
		System.out.println("�̸�?");
		vo.setName(sc.next());
		
		System.out.println("����");
		vo.setKor(sc.nextInt());
		
		System.out.println("����");
		vo.setMat(sc.nextInt());
		
		System.out.println("����");
		vo.setEng(sc.nextInt());
		
		
		hMap.put(hak, vo); //Map�� �Է°� ����ֱ�
		System.out.println("�߰� ����");
		
	}

	@Override
	public boolean searchHak(String hak) {
		
		/*if(hMap.containsKey(hak)) {
			return true;
		}

		return false;*/
		
		return hMap.containsKey(hak); //������� True or False
		
	}

	@Override
	public void print() {
		
		Iterator<String> it = hMap.keySet().iterator(); //key
		
		while(it.hasNext()) {
			
			String hak = it.next(); //key��
			ScoreVO vo = hMap.get(hak); //value�� 
			
			System.out.println(hak + ":" + vo.toString());
			
			
			
		}
		
	}

	@Override
	public void delete() {
		
		System.out.println("������ �й�?");
		hak = sc.next();
		
			if(searchHak(hak)) {
				 hMap.remove(hak);
				 System.out.println("���� ����");
			}else 
				System.out.println("�Է��Ͻ� �й��� �������� �ʽ��ϴ�");
			
	}
		
	@Override
	public void update() {
		System.out.println("������ �й�?");
		hak = sc.next();
		
		if(!searchHak(hak)) {
			System.out.println("������ �й��� �������� �ʽ��ϴ�");
			return;
		}
		
		
/*		���1
		ScoreVO pVO = hMap.get(hak);//value
		
		
		ScoreVO vo = new ScoreVO();
		
		vo.setName(pVO.getName());
		
		System.out.println("����");
		vo.setKor(sc.nextInt());
		
		System.out.println("����");
		vo.setMat(sc.nextInt());
		
		System.out.println("����");
		vo.setEng(sc.nextInt());
		
		hMap.put(hak, vo);
*/
		
		
		//���2
		
		
		ScoreVO vo = hMap.get(hak);
		
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
			System.out.println("�Է��Ͻ� �й��� �������� �ʽ��ϴ�");
			return;
		}else {
			ScoreVO vo = hMap.get(hak); //value�� 
			System.out.println(hak + ":" + vo.toString());
		}
		
	}

	@Override
	public void findName() {
		System.out.println("�˻��� �̸�?");
		String name = sc.next();
		
		
		Iterator<String> it = hMap.keySet().iterator(); //key
		
		
		boolean flag = false; //�⺻��
		
		
		while(it.hasNext()) {
			
			String hak = it.next(); //key��
			ScoreVO vo = hMap.get(hak); //value�� 
			
			
			if(name.equals(vo.getName())) {
				System.out.println(hak + ":" + vo.toString());
				flag = true;
			}
			
		
		}
		
		if(flag) {
			System.out.println("�˻�����!");
		}else {
			System.out.println("�Է��Ͻ� �̸��� �������� �ʽ��ϴ�");
		}
	}

}
