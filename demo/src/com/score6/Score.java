package com.score6;

import java.net.StandardSocketOptions;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Score { //��������� �����͸� �޾Ƴ��� ������ Ŭ����
	
	Scanner sc = new Scanner(System.in);
	ScoreDAO dao = new ScoreDAO();
	List<ScoreDTO> lists = null;
	
	
	//�Է�
	public void insert () {
		
		ScoreDTO dto = new ScoreDTO();
		
		System.out.print("�й�?");
		dto.setHak(sc.next());
		
		System.out.print("�̸�?");
		dto.setName(sc.next());
		
		System.out.print("����?");
		dto.setKor(sc.nextInt());
		
		System.out.print("����?");
		dto.setEng(sc.nextInt());
		
		System.out.print("����?");
		dto.setMat(sc.nextInt());
		
		//dao.insertData(dto); //scoredao���� dto�ֱ�
		
		int result = dao.insertData(dto); //��ȯ���� 1 or 0
		
		if(result!=0) {
			System.out.println("�߰� ����!!");
		}else {
			System.out.println("�߰� ����!!");
		}
		
		
	}
	
	//����
	public void update() {
		
		ScoreDTO dto = new ScoreDTO();
		
		System.out.print("������ �й�?");
		dto.setHak(sc.next());
		
		System.out.print("����?");
		dto.setKor(sc.nextInt());
		
		System.out.print("����?");
		dto.setEng(sc.nextInt());
		
		System.out.print("����?");
		dto.setMat(sc.nextInt());
		
		int result = dao.updateData(dto);
		
		if(result!=0) {
			System.out.println("���� ����!!");
		}else {
			System.out.println("���� ����!!");
		}
		
		
		
	}
	
	
	
	
	//����
	public void delete() {
	
	/*
		ScoreDTO dto = new ScoreDTO();
		
		System.out.print("������ �й�?");
		dto.setHak(sc.next());
		
		int result = dao.deleteData(dto);
		
		if(result!=0) {
			System.out.println("���� ����!!");
		}else {
			System.out.println("���� ����!!");
		}
	*/
		
		
		System.out.print("������ �й�?");
		String hak = sc.next();
		
		int result = dao.deleteData(hak);
		
		if(result!=0) {
			System.out.println("���� ����!!");
		}else {
			System.out.println("���� ����!!");
		}
		
		

	
	
	}
	
	public void print() { //�ݺ� ����ϴ� �޼ҵ� ���� ����
		
		Iterator<ScoreDTO> it = lists.iterator();
		
		while(it.hasNext()) {
		
			ScoreDTO dto = it.next();
			
			if(dto.getRank()==0) 
		
				System.out.println(dto.toString());
			
			else
				System.out.println(dto.toString() + "  "+dto.getRank());
		
		
	}
		
		
		
		
		
	}
	
	//�̸��˻�
	public void searchName() {
		
		System.out.print("�˻��� �̸�?");
		String name = sc.next();
		
		lists = dao.getList(name);
		
		if(lists.size()!=0)
			print();
		else
			System.out.println("ã�� �̸��� �����ϴ�");
		
		

		
	}
	
	
	//��ü���
	public void selectAll() {
			
		lists = dao.getList();
			
		print();
				
				
		}
		
	//�й��˻�
	public void searchHak() {
		
		System.out.print("�˻��� �й�?");
		String hak = sc.next();
		
		ScoreDTO dto = dao.getLists(hak);
		
		if(dto!=null) {
			System.out.println(dto.toString());
		}else {
			System.out.println("ã�� �й��� �����ϴ�.");
		}
		
		
		
	}
		
		
		
		
		
	
	}
	

