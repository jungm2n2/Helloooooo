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
		System.out.println("---------�α����� ���ּ���-------");
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.next();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw = sc.next();
		
		dto = dao.getLists(id,pw);
		
		if(dto!=null) {
			System.out.println("���̵� Ȯ�� �Ϸ�!");
			
			System.out.println("������ �Է��ϼ���(100�� �̳�)");
			dto.setContent(sc.next());
			
			int result = dao.insertData(dto);
			
			if (result==1)
				System.out.println("��� �Ϸ�!");
			else {
				System.out.println("�̹� ����ϼ̽��ϴ�.");
				System.out.println("��� ����!");
			}
		}else
			System.out.println("�α��� ����!");
	}
	
	
	//��ȸ
	public void search() {
		
		System.out.println("---------�α����� ���ּ���-------");
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.next();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw = sc.next();
		
		GuestDTO dto = dao.getLists(id,pw);
		
		if(dto!=null) {
			System.out.println("���̵� Ȯ�� �Ϸ�!");
			GuestDTO dto1 = dao.getList(dto);
			if(dto1!=null) {
			System.out.println(dto1.toString());
			}
		}else
			System.out.println("�α��� ����!");
		
	}
	
	
	//��ü��ȸ
	
	public void printAll() {
		
		System.out.println("---------�α����� ���ּ���-------");
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.next();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw = sc.next();
		
		GuestDTO dto = dao.getLists(id,pw);
	
			if(dto==null) {
				System.out.println("�α��� ����!");
			}else {
				System.out.println("���̵� Ȯ�� �Ϸ�!");
				
				List<GuestDTO> lists = dao.getList3(dto);
				
				Iterator<GuestDTO> it = lists.iterator();
				
				while(it.hasNext()) {
				
					GuestDTO dto1 = it.next();
				
						System.out.println(dto1.toString());
				
			}
	}		
	}
	//����
	
	public void update() {
		
		GuestDTO dto = new GuestDTO();
		System.out.println("---------�α����� ���ּ���-------");
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.next();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw = sc.next();
		
		dto = dao.getLists(id,pw);
		
		if(dto!=null) { 
			System.out.println("���̵� Ȯ�� �Ϸ�!");
			System.out.println("������ �����ϼ���");
			dto.setContent(sc.next());
			
			int result = dao.updateData(dto);
			
			if(result!=0) {
				System.out.println("���� ����!!");
			}else {
				System.out.println("���� ����!!");
			}
			
		}else {
			System.out.println("�α��� ����!");
		}
		
		
		
		
		
	}
	
	
	//����
	public void delete() {
		
		
		GuestDTO dto = new GuestDTO();
		System.out.println("---------�α����� ���ּ���-------");
		System.out.print("���̵� �Է��ϼ���");
		String id = sc.next();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw = sc.next();
		
		dto = dao.getLists(id,pw);
		
		
		
		if(dto!=null) {
			System.out.println("���̵� Ȯ�� �Ϸ�!");
			int result = dao.deleteData(dto);
				if (result==1) {
					System.out.println("���� ����!!");
				}	else {
				System.out.println("���� ����! ������ �����Ͱ� �����ϴ�!!");
				}
		}else
			System.out.println("�α��� ����!");
	
	
	
/*	
	public void check() {
		
	
		GuestDTO dto = new GuestDTO();
		System.out.println("---------�α����� ���ּ���-------");
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.next();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw = sc.next();
		
		dto = dao.getLists(id,pw);
		
		
		
		
		
		
	}
	
	*/
	}
}