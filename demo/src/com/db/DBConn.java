package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	
	private static Connection dbConn;
	
	//DB연결 메소드(연결자 생성)
	public static Connection getConnection() {
		
		if(dbConn==null) {
			
			try {
				String url = "jdbc:oracle:thin:@192.168.16.4:1521:xe"; //type4
				String user = "suzi";
				String pwd = "a123";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Class.forName() 메소드를 통해 DriverManager가 생성된다
				//오라클에 접속할 수 있는 드라이버를 불러옴
				
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
		
		dbConn=null; //반드시 널로 만들어주기
		
	}

}
