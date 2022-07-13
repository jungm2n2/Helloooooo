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

public class serverTest extends Frame implements ActionListener, Runnable {

	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	private ServerSocket ss = null;
	private Socket sc = null;
	
	public serverTest() {
		
		
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		
		tf.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);;
			}
		});
		
		setTitle("채팅 서버");
		setSize(300,400);
		setVisible(true);
	
	}
	
	
	
	
	
	
	@Override
	public void run() {
		//메세지 받기
		
		String msg;
		String ip;
		
		try {
			
			if(sc==null) {
				return;
			}
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			//클라이언트의 아이피
			ip = sc.getInetAddress().getHostAddress();
			
			ta.append("\r\n["+ip+"] 접속!!");
			
			while((msg=br.readLine())!=null) {
				
				ta.append("\r\n"+msg);
				
			}
			
		} catch (Exception e) {
			ta.append("\r\n"+"클라이언트 연결 종료...");
			sc = null; 
			ss = null;
			
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
			
			pw.println("서버]" + msg); //클라이언트에 전송
			
			ta.append("\r\n서버]"+msg); //내 창에 보임
			
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {
			ta.append("\r\n 클라이언트와 연결이 끊겼습니다...");
			sc=null;
		
		}
		
		
		
		
		
		
		
	}

	
	
	public void serverStart() {
		
		try {
			ss = new ServerSocket(7777);
			ta.setText("서버 시작!!");
			
			sc = ss.accept(); //연결
			
			Thread th = new Thread(this); 
			th.start(); //스레드 가동
			
		} catch (Exception e) {
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		new serverTest().serverStart();
		
	
	
	
	
	
	
	
	
	
}
}
