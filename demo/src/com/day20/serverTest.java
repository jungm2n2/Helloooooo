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
		
		setTitle("ä�� ����");
		setSize(300,400);
		setVisible(true);
	
	}
	
	
	
	
	
	
	@Override
	public void run() {
		//�޼��� �ޱ�
		
		String msg;
		String ip;
		
		try {
			
			if(sc==null) {
				return;
			}
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			//Ŭ���̾�Ʈ�� ������
			ip = sc.getInetAddress().getHostAddress();
			
			ta.append("\r\n["+ip+"] ����!!");
			
			while((msg=br.readLine())!=null) {
				
				ta.append("\r\n"+msg);
				
			}
			
		} catch (Exception e) {
			ta.append("\r\n"+"Ŭ���̾�Ʈ ���� ����...");
			sc = null; 
			ss = null;
			
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		//�޼��� ������
		
		String msg = tf.getText();
		
		if(msg.trim().equals("")) {
			return;
		}
		
		if(sc==null) {
			return;
		}
		
		try {
			//true : �ڵ� flush
			OutputStream os = sc.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true);
			
			pw.println("����]" + msg); //Ŭ���̾�Ʈ�� ����
			
			ta.append("\r\n����]"+msg); //�� â�� ����
			
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {
			ta.append("\r\n Ŭ���̾�Ʈ�� ������ ������ϴ�...");
			sc=null;
		
		}
		
		
		
		
		
		
		
	}

	
	
	public void serverStart() {
		
		try {
			ss = new ServerSocket(7777);
			ta.setText("���� ����!!");
			
			sc = ss.accept(); //����
			
			Thread th = new Thread(this); 
			th.start(); //������ ����
			
		} catch (Exception e) {
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		new serverTest().serverStart();
		
	
	
	
	
	
	
	
	
	
}
}
