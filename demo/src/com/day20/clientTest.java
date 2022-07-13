package com.day20;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class clientTest extends Frame implements ActionListener, Runnable {

	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	
	private Socket sc = null;
	private int port = 7777;
	private String host = "192.168.16.4"; //localhost(127.0.0.1)
	
	public clientTest() {
		
		
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		
		tf.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);;
			}
		});
		
		setTitle("채팅 클라이언트");
		setSize(300,400);
		setVisible(true);
	
	}
	
	
	
	
	
	
	@Override
	public void run() {
		//메세지 받기
		
		String msg;
		
		
		try {
			
			if(sc==null) {
				return;
			}
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			
			
			while((msg=br.readLine())!=null) {
				
				ta.append("\r\n"+msg);
				
			}
			
		} catch (Exception e) {
			ta.append("\r\n"+"서버 연결 종료...");
			sc = null; 
			
			
		}
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		//메세지 보내기
		
		String msg = tf.getText();
		
		if(msg.trim().equals("")) {
			return;
		}
		
		if(sc==null) {
			return;
		}
		
		try {
			//true : 자동 flush
			OutputStream os = sc.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true);
			
			pw.println("정민]" + msg); //서버에 전송
			
			ta.append("\r\n정민]"+msg); //내 창에 보임
			
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {
			ta.append("\r\n 서버와 연결이 끊겼습니다...");
			sc=null;
		
		}
		
	}

	
	
	public void connect() {
		
		try {
			
			sc = new Socket(host, port);
		
			Thread th = new Thread(this); 
			th.start(); //스레드 가동
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		new clientTest().connect();
		
	
	
	
	
	
	
	
	
	
}
}
