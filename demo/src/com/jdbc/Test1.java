package com.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import com.db.DBConn;

public class Test1 {
	
	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();
		
		if(conn==null) {
			System.out.println("�����ͺ��̽� ���� ����!!");
			System.exit(0);
		}
		
		//DB������
		//1.DriverManager�� Connection�� ����
		//2.Connection�� Statement�� ����(SQL������ �����ϴ� �������̽�)
		//3.Statement�� query�� ����
		
		try {
			
			Statement stmt = conn.createStatement();
			String sql;
			/*
			sql = "insert into score(hak,name,kor,eng,mat) ";
			sql+="values('111','�����',80,90,60)";
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("�߰� ����!");
			}
			*/
			
			/*
			sql = "update score set kor=99,eng=99,mat=99 ";
			sql+="where hak=111";
			
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("���� ����!!");
			}
			*/
			
			sql = "delete score where hak=111";
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("���� ����!!");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		DBConn.close();
		
	}
	
	

}
