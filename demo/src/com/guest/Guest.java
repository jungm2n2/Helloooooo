package com.guest;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.score6.ScoreDTO;

public class Guest {
	
	Scanner sc = new Scanner(System.in);
	GuestDAO dao = new GuestDAO();
	List<GuestDTO> lists = null;
	
	//���
	public void write() {
		
		GuestDTO dto = new GuestDTO();
		
		
		
		if(!check())
			
		System.out.println("������ �Է��ϼ���(100�� �̳�)");
		dto.setContent(sc.next());
		
		int result = dao.insertData(dto);
		
		if (result==1)
			System.out.println("��� �Ϸ�!");
		else
			System.out.println("��� ����!");
		
	}
	
	
	//��ȸ
	public void search() {
		
	
		System.out.print("���̵� �Է��ϼ���");
		String id = sc.next();
		
		GuestDTO dto = dao.getList(id);
		
		if(dto!=null) 
			System.out.println(dto.toString());
		else
			System.out.println("�����ϴ� ���̵� �����ϴ�.");
			
		
		
		
		
	}
		

	//����
	
	public void update() {
		
		GuestDTO dto = new GuestDTO();
		
		System.out.println("���̵� �Է��ϼ���");
		dto.setId(sc.next());
		
		System.out.print("������ �����ϼ���");
		dto.setContent(sc.next());
		
		int result = dao.updateData(dto);
		
		if(result!=0) {
			System.out.println("���� ����!!");
		}else {
			System.out.println("���� ����!!");
		}
		
		
		
	}
	
	
	//����
	public void delete() {
		
		
		GuestDTO dto = new GuestDTO();
		
		System.out.println("���̵� �Է��ϼ���");
		dto.setId(sc.next());
		
		int result = dao.deleteData(dto);
		
		if(result!=0) {
			System.out.println("���� ����!!");
		}else {
			System.out.println("���� ����!!");
		}
	}
	
	
	//�ݺ� ����ϴ� �޼ҵ� ���� ����
	public void print() { 
		
		Iterator<GuestDTO> it = lists.iterator();
		
		
		while(it.hasNext()) {
		
			GuestDTO dto = it.next();
		
	}
	}
	
	public boolean check() {
		
	
			
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.next();
		GuestDTO dto = dao.getLists(id);
		
		if(dto==null) {
			System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�");
			return false;
			
		}System.out.println("���̵� Ȯ�� �Ϸ�");
		
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw = sc.next();
		
		if(!dto.getPwd().equals(pw)) {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
			return false;
		}
		return true;
		
		
		
		
	}

}