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
		System.out.println("---------로그인을 해주세요-------");
		System.out.println("아이디를 입력하세요");
		String id = sc.next();
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.next();
		
		dto = dao.getLists(id,pw);
		
		if(dto!=null) {
			System.out.println("아이디 확인 완료!");
			
			System.out.println("방명록을 입력하세요(100자 이내)");
			dto.setContent(sc.next());
			
			int result = dao.insertData(dto);
			
			if (result==1)
				System.out.println("등록 완료!");
			else {
				System.out.println("이미 등록하셨습니다.");
				System.out.println("등록 실패!");
			}
		}else
			System.out.println("로그인 실패!");
	}
	
	
	//조회
	public void search() {
		
		System.out.println("---------로그인을 해주세요-------");
		System.out.println("아이디를 입력하세요");
		String id = sc.next();
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.next();
		
		GuestDTO dto = dao.getLists(id,pw);
		
		if(dto!=null) {
			System.out.println("아이디 확인 완료!");
			GuestDTO dto1 = dao.getList(dto);
			if(dto1!=null) {
			System.out.println(dto1.toString());
			}
		}else
			System.out.println("로그인 실패!");
		
	}
	
	
	//전체조회
	
	public void printAll() {
		
		System.out.println("---------로그인을 해주세요-------");
		System.out.println("아이디를 입력하세요");
		String id = sc.next();
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.next();
		
		GuestDTO dto = dao.getLists(id,pw);
	
			if(dto==null) {
				System.out.println("로그인 실패!");
			}else {
				System.out.println("아이디 확인 완료!");
				
				List<GuestDTO> lists = dao.getList3(dto);
				
				Iterator<GuestDTO> it = lists.iterator();
				
				while(it.hasNext()) {
				
					GuestDTO dto1 = it.next();
				
						System.out.println(dto1.toString());
				
			}
	}		
	}
	//수정
	
	public void update() {
		
		GuestDTO dto = new GuestDTO();
		System.out.println("---------로그인을 해주세요-------");
		System.out.println("아이디를 입력하세요");
		String id = sc.next();
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.next();
		
		dto = dao.getLists(id,pw);
		
		if(dto!=null) { 
			System.out.println("아이디 확인 완료!");
			System.out.println("방명록을 수정하세요");
			dto.setContent(sc.next());
			
			int result = dao.updateData(dto);
			
			if(result!=0) {
				System.out.println("수정 성공!!");
			}else {
				System.out.println("수정 실패!!");
			}
			
		}else {
			System.out.println("로그인 실패!");
		}
		
		
		
		
		
	}
	
	
	//삭제
	public void delete() {
		
		
		GuestDTO dto = new GuestDTO();
		System.out.println("---------로그인을 해주세요-------");
		System.out.print("아이디를 입력하세요");
		String id = sc.next();
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.next();
		
		dto = dao.getLists(id,pw);
		
		
		
		if(dto!=null) {
			System.out.println("아이디 확인 완료!");
			int result = dao.deleteData(dto);
				if (result==1) {
					System.out.println("삭제 성공!!");
				}	else {
				System.out.println("삭제 실패! 삭제할 데이터가 없습니다!!");
				}
		}else
			System.out.println("로그인 실패!");
	
	
	
/*	
	public void check() {
		
	
		GuestDTO dto = new GuestDTO();
		System.out.println("---------로그인을 해주세요-------");
		System.out.println("아이디를 입력하세요");
		String id = sc.next();
		System.out.println("비밀번호를 입력하세요");
		String pw = sc.next();
		
		dto = dao.getLists(id,pw);
		
		
		
		
		
		
	}
	
	*/
	}
}