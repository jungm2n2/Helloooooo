package com.naver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



class Myauthen {
	
	
	public void put(String str) throws Exception{
		

		
		
		
	}
	
	
	public void inputFormat(String str) throws Exception{
		
		
		
		if(str.length()<8 || str.length()>15) {
			throw new Exception("���ڿ��� ���̴� 8~15�� �Դϴ�");
			
		
		}
		
		
			int eng=0;
			int num=0;
			
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
				
				if((ch>='A'&&ch<='Z') || (ch>='a'&&ch<='z')) {
					eng++;
					
				}else if((ch>='0'&&ch<='9')) {
					num++;
					
				}
	
			}

			if(eng==0 || num==0) {
				throw new Exception("������ �Ǵ� ���� ȥ�� �Է¸� �����մϴ�");
				
			}else {
				System.out.println("���̵� �Է� �Ϸ�");
			}
	}
	
	
	
	
	
}



public class SignupImpl implements Signup{
	
	private List<SignupVO> lists = new ArrayList<>();
	
	Scanner sc =  new Scanner(System.in);
	
	Myauthen auth = new Myauthen(); 
	
	
	@Override
	public void input() {
		
		int result = 0;
		SignupVO vo = new SignupVO();
		
	
		while(true){
			try {
				System.out.print("ȸ������ �� ID�� �Է��� �ּ���");
				vo.setId(sc.next());
				
				auth.inputFormat(vo.getId());
				
				break;
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
				
			}
		}	
		
		
			System.out.println("��й�ȣ�� �Է��� �ּ���");
			vo.setPw(sc.next());
			
			System.out.println("�̸��� �Է��� �ּ���");
			vo.setName(sc.next());
				
			System.out.println("������ �Է��� �ּ���");
			vo.setGender(sc.next());
			
			System.out.println("��������� �Է��� �ּ���");
			vo.setBirth(sc.next());
			
			System.out.println("�̸����� �Է��� �ּ���");
			vo.setEmail(sc.next());
			
			System.out.println("�޴��� ��ȣ�� �Է��� �ּ���");
			vo.setTel(sc.next());

				lists.add(vo);
			
			}
		

	


		
	

	@Override
	public void print() {
		
		Iterator<SignupVO> it = lists.iterator();
		
		while(it.hasNext()){
			
			SignupVO vo = it.next();
			
			System.out.println(vo.toString());
		}
		
		
	}
		
		
	
		
		
	

	@Override
	public void findId() {
		System.out.println("�˻��ϰ� ���� ID�� �Է��ϼ���");
		String id = sc.next();
		
		Iterator<SignupVO> it = lists.iterator();
		
		while(it.hasNext()){
			SignupVO vo = it.next();
			
			if(id.equals(vo.getId())) {
			System.out.println(vo.toString());
			System.out.println("���̵� �˻� ����");
			break;
			
		}else {
			System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�");
		}
		
		
		}		
		
		
	}

	@Override
	public void findName() {
		System.out.println("�˻��� ȸ���� �̸��� �Է����ּ���");
		String name = sc.next();
		
		Iterator<SignupVO> it = lists.iterator();
		while(it.hasNext()){
			
			SignupVO vo = it.next();
			
			if(name.equals(vo.getName())) {
			System.out.println(vo.toString());
		}else {
			System.out.println("�Է��Ͻ� �̸��� �������� �ʽ��ϴ�");
		}
		
		}
	}

	@Override
	public void updateId() {
		
		System.out.println("�����ϰ���� ȸ���� ���̵� �Է����ּ���");
		String id = sc.next();
		
		Iterator<SignupVO> it = lists.iterator();
		while(it.hasNext()){
			SignupVO vo = it.next();
			
			if(!(id.equals(vo.getId()))) {
				System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�");
				break;
			}
		
		
		System.out.println("��й�ȣ�� �Է��� �ּ���");
		vo.setPw(sc.next());
		
		System.out.println("������ �Է��� �ּ���");
		vo.setGender(sc.next());
		
		System.out.println("��������� �Է��� �ּ���");
		vo.setBirth(sc.next());
		
		System.out.println("�̸����� �Է��� �ּ���");
		vo.setEmail(sc.next());
		
		System.out.println("�޴��� ��ȣ�� �Է��� �ּ���");
		vo.setTel(sc.next());
		
		//lists.add(vo); ����Ʈ�� ���� ���� ������ add�� �ϸ� �ȉ�
		
		
		}
		
		
		
		
		
		
		
	}

	@Override
	public void deleteId() {
		
		System.out.println("������ ȸ���� ���̵� �Է����ּ���");
		String id = sc.next();
		
		Iterator<SignupVO> it = lists.iterator();
		
		while(it.hasNext()){
			
			SignupVO vo = it.next();
			
			//if(!(id.equals(vo.getId()))) {
				//System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�");
				
			
			if(id.equals(vo.getId())){
				lists.remove(vo);
				break;
			}else{
				System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�");
			
				
			}
		
		}
	}

}
