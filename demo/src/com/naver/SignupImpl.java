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
			throw new Exception("문자열의 길이는 8~15자 입니다");
			
		
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
				throw new Exception("영문자 또는 숫자 혼용 입력만 가능합니다");
				
			}else {
				System.out.println("아이디 입력 완료");
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
				System.out.print("회원가입 할 ID를 입력해 주세요");
				vo.setId(sc.next());
				
				auth.inputFormat(vo.getId());
				
				break;
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
				
			}
		}	
		
		
			System.out.println("비밀번호를 입력해 주세요");
			vo.setPw(sc.next());
			
			System.out.println("이름을 입력해 주세요");
			vo.setName(sc.next());
				
			System.out.println("성별을 입력해 주세요");
			vo.setGender(sc.next());
			
			System.out.println("생년월일을 입력해 주세요");
			vo.setBirth(sc.next());
			
			System.out.println("이메일을 입력해 주세요");
			vo.setEmail(sc.next());
			
			System.out.println("휴대폰 번호를 입력해 주세요");
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
		System.out.println("검색하고 싶은 ID를 입력하세요");
		String id = sc.next();
		
		Iterator<SignupVO> it = lists.iterator();
		
		while(it.hasNext()){
			SignupVO vo = it.next();
			
			if(id.equals(vo.getId())) {
			System.out.println(vo.toString());
			System.out.println("아이디 검색 성공");
			break;
			
		}else {
			System.out.println("입력하신 아이디가 존재하지 않습니다");
		}
		
		
		}		
		
		
	}

	@Override
	public void findName() {
		System.out.println("검색할 회원의 이름을 입력해주세요");
		String name = sc.next();
		
		Iterator<SignupVO> it = lists.iterator();
		while(it.hasNext()){
			
			SignupVO vo = it.next();
			
			if(name.equals(vo.getName())) {
			System.out.println(vo.toString());
		}else {
			System.out.println("입력하신 이름이 존재하지 않습니다");
		}
		
		}
	}

	@Override
	public void updateId() {
		
		System.out.println("수정하고싶은 회원의 아이디를 입력해주세요");
		String id = sc.next();
		
		Iterator<SignupVO> it = lists.iterator();
		while(it.hasNext()){
			SignupVO vo = it.next();
			
			if(!(id.equals(vo.getId()))) {
				System.out.println("입력하신 아이디가 존재하지 않습니다");
				break;
			}
		
		
		System.out.println("비밀번호를 입력해 주세요");
		vo.setPw(sc.next());
		
		System.out.println("성별을 입력해 주세요");
		vo.setGender(sc.next());
		
		System.out.println("생년월일을 입력해 주세요");
		vo.setBirth(sc.next());
		
		System.out.println("이메일을 입력해 주세요");
		vo.setEmail(sc.next());
		
		System.out.println("휴대폰 번호를 입력해 주세요");
		vo.setTel(sc.next());
		
		//lists.add(vo); 리스트는 값을 새로 생성함 add를 하면 안됌
		
		
		}
		
		
		
		
		
		
		
	}

	@Override
	public void deleteId() {
		
		System.out.println("삭제할 회원의 아이디를 입력해주세요");
		String id = sc.next();
		
		Iterator<SignupVO> it = lists.iterator();
		
		while(it.hasNext()){
			
			SignupVO vo = it.next();
			
			//if(!(id.equals(vo.getId()))) {
				//System.out.println("입력하신 아이디가 존재하지 않습니다");
				
			
			if(id.equals(vo.getId())){
				lists.remove(vo);
				break;
			}else{
				System.out.println("입력하신 아이디가 존재하지 않습니다");
			
				
			}
		
		}
	}

}
