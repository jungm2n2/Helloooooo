package com.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.db.DBConn;

public class TclMain {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql;
		
		Scanner sc = new Scanner(System.in);
		
		int id,ch;
		String name,birth,tel;
		
		try {
			while(true) {
				
				do {
					System.out.print("1.입력 2.출력 3.종료");
					ch = sc.nextInt();
				}while(ch<1||ch>3);
				
				switch(ch) {
				
				case 1 :
					conn.setAutoCommit(false); //오토커밋 막기
					
					System.out.println("아이디?"); //test1
					id=sc.nextInt();
					System.out.println("이름?"); //test1
					name=sc.next();
					System.out.println("생일?"); //test2
					birth=sc.next();
					System.out.println("전화?"); //test3
					tel=sc.next();
					
					sql=String.format("insert into test1(id,name) values(%d,'%s')", id,name);
					
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					stmt.close();
					
					sql=String.format("insert into test2(id,birth) values(%d,'%s')", id,birth);
					
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					stmt.close();
					
					
					sql=String.format("insert into test3(id,tel) values(%d,'%s')", id,tel);
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					stmt.close();
					
					conn.commit(); //제대로 다 들어가면 커밋
					break;
					
				case 2 :
					break;
				case 3 :
					DBConn.close();
					System.exit(0);
				
				
				
				}
				
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
