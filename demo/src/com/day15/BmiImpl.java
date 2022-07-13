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
	
		System.out.println("ȸ����ȣ?");
		num = sc.next();
		
		if(searchNum(num)) {
			System.out.println("�Է��Ͻ� ȸ����ȣ�� �����մϴ�.");
			return;
		}
		
		BmiVO vo = new BmiVO();
		
		System.out.println("�̸�?");
		vo.setName(sc.next());
		
		System.out.println("������?");
		vo.setWeg(sc.nextDouble());
		
		System.out.println("Ű?");
		vo.setHei(sc.nextDouble());
		
		hMap.put(num, vo);
		
		System.out.println("ȸ����ȣ �߰� �Ϸ�");
		
		
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
		System.out.println("������ ȸ����ȣ?");
		num = sc.next();
		
		if(!searchNum(num)) {
			System.out.println("�Է��Ͻ� ȸ����ȣ�� �������� �ʽ��ϴ�");
			return;
		}else {
			hMap.remove(num);
			System.out.println("ȸ����ȣ ���� �Ϸ�");
		}
		
		
		
	}

	@Override
	public void update() {
		System.out.println("������ ȸ����ȣ?");
		num = sc.next();
		
		if(!searchNum(num)) {
			System.out.println("�Է��Ͻ� ȸ����ȣ�� �������� �ʽ��ϴ�");
			return;
		}
		
		
		BmiVO vo =  hMap.get(num);
		
		System.out.println("������?");
		vo.setWeg(sc.nextDouble());
		
		System.out.println("Ű?");
		vo.setHei(sc.nextDouble());
		
		hMap.put(num, vo);
		System.out.println("���� �Ϸ�");
		
		
		
		
	}

	@Override
	public void findnum() {
		System.out.println("�˻��� ȸ����ȣ?");
		num = sc.next();
		
		if(!searchNum(num)) {
			System.out.println("�Է��Ͻ� ȸ����ȣ�� �����ϴ�");
			return;
		}
		BmiVO vo = hMap.get(num);
		System.out.println(num+" : "+vo.toString());
		
		
		
	}

	@Override
	public void findName() {
		
		System.out.println("�˻��� �̸�?");
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
			System.out.println("�˻� ����");
		
			
		}else {
			System.out.println("�Է��Ͻ� �̸��� �������� �ʽ��ϴ�");
		}

		
	}
	
	

}
