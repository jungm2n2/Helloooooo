package com.jdbc;

import java.sql.Connection;

import com.db.DBConn;

public class TestDB {
	
	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();
		
		if(conn==null) {
			System.out.println("�����ͺ��̽� ���� ����!!");
			System.exit(0);
		}
		System.out.println("�����ͺ��̽� ���� ����!!");
		DBConn.close();
	}

}
