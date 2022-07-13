package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	
	private static Connection dbConn;
	
	//DB���� �޼ҵ�(������ ����)
	public static Connection getConnection() {
		
		if(dbConn==null) {
			
			try {
				String url = "jdbc:oracle:thin:@192.168.16.4:1521:xe"; //type4
				String user = "suzi";
				String pwd = "a123";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Class.forName() �޼ҵ带 ���� DriverManager�� �����ȴ�
				//����Ŭ�� ������ �� �ִ� ����̹��� �ҷ���
				
				dbConn = DriverManager.getConnection(url, user, pwd);
		
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
		}
		
		return dbConn;
	}
	
	
	public static void close() {
		
		if(dbConn!=null) {
			try {
				
				
				if(!dbConn.isClosed()) {
					dbConn.close();
				}
				
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
		}
		
		dbConn=null; //�ݵ�� �η� ������ֱ�
		
	}

}
