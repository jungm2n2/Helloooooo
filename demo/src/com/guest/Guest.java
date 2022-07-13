package com.guest;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.score6.ScoreDTO;

public class Guest {
	
	Scanner sc = new Scanner(System.in);
	GuestDAO dao = new GuestDAO();
	List<GuestDTO> lists = null;
	
	//등록
	public void write() {
		
		GuestDTO dto = new GuestDTO();
		
		
		
		if(!check())
			
		System.out.println("방명록을 입력하세요(100자 이내)");
		dto.setContent(sc.next());
		
		int result = dao.insertData(dto);
		
		if (result==1)
			System.out.println("등록 완료!");
		else
			System.out.println("등록 실패!");
		
	}
	
	
	//조회
	public void search() {
		
	
		System.out.print("아이디를 입력하세요");
		String id = sc.next();
		
		GuestDTO dto = dao.getList(id);
		
		if(dto!=null) 
			System.out.println(dto.toString());
		else
			System.out.println("존재하는 아이디가 없습니다.");
			
		
		
		
		
	}
		

	//수정
	
	public void update() {
		
		GuestDTO dto = new GuestDTO();
		
		System.out.println("아이디를 입력하세요");
		dto.setId(sc.next());
		
		System.out.print("방명록을 수정하세요");
		dto.setContent(sc.next());
		
		int result = dao.updateData(dto);
		
		if(result!=0) {
			System.out.println("수정 성공!!");
		}else {
			System.out.println("수정 실패!!");
		}
		
		
		
	}
	
	
	//삭제
	public void delete() {
		
		
		GuestDTO dto = new GuestDTO();
		
		System.out.println("아이디를 입력하세요");
		dto.setId(sc.next());
		
		int result = dao.deleteData(dto);
		
		if(result!=0) {
			System.out.println("삭제 성공!!");
		}else {
			System.out.println("삭제 실패!!");
		}
	}
	
	
	//반복 출력하는 메소드 따로 빼기
	public void print() { 
		
		Iterator<GuestDTO> it = lists.iterator();
		
		
		while(it.hasNext()) {
		
			GuestDTO dto = it.next();
		
	}
	}
	
	public boolean check() {
		
	
			
		System.out.println("아이디를 입력하세요");
		String id = sc.next();
		GuestDTO dto = dao.getLists(id);
		
		if(dto==null) {
			System.out.println("입력하신 아이디가 존재하지 않습니다");
			return false;
			
		}System.out.println("아이디 확인 완료");
		
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.next();
		
		if(!dto.getPwd().equals(pw)) {
			System.out.println("비밀번호가 일치하지 않습니다");
			return false;
		}
		return true;
		
		
		
		
	}

}