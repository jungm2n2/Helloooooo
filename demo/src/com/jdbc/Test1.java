package com.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import com.db.DBConn;

public class Test1 {
	
	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();
		
		if(conn==null) {
			System.out.println("데이터베이스 연결 실패!!");
			System.exit(0);
		}
		
		//DB연결방법
		//1.DriverManager가 Connection을 생성
		//2.Connection이 Statement를 생성(SQL구문을 실행하는 인터페이스)
		//3.Statement가 query를 실행
		
		try {
			
			Statement stmt = conn.createStatement();
			String sql;
			/*
			sql = "insert into score(hak,name,kor,eng,mat) ";
			sql+="values('111','배수지',80,90,60)";
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("추가 성공!");
			}
			*/
			
			/*
			sql = "update score set kor=99,eng=99,mat=99 ";
			sql+="where hak=111";
			
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("수정 성공!!");
			}
			*/
			
			sql = "delete score where hak=111";
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("삭제 성공!!");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		DBConn.close();
		
	}
	
	

}
