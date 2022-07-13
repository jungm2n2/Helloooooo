package com.day20;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

//�׷�ä��
//D class : 224.0.0.0 ~ 239.255.255.255


public class ChatCS extends Frame implements ActionListener,Runnable{
	
	
	private MulticastSocket ms = null;
	private InetAddress xGroup = null;
	
	private String host = "230.1.1.6";
	private int port = 7777;
	private String userName = "�̴�";
	
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	
	//DatagramSocket : UDP�� �����͸� �����ϰų� ����
	//DatagramPacket : UDP�� �̿��Ͽ� ���۵� �� �ִ� ������
	//MulticastSocket : �ټ��� Ŭ���̾�Ʈ���� DatagramPacket�� ������
	
	public ChatCS() {
		
		ta.setEditable(false);
		add(ta,BorderLayout.CENTER);
		
		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
			
		});
		
		setTitle("�׷�ä�� ["+host+"]");
		setSize(400, 400);
		setVisible(true);
		tf.requestFocus();
	}
	
	
	public void setup() {
		
		try {
			
			xGroup = InetAddress.getByName(host);
			ms = new MulticastSocket(port);
			
			ms.joinGroup(xGroup);
			
			Thread th = new Thread(this);
			th.start();
			
			
			
			
			
		} catch (Exception e) {
			
		}
		
	}
	
	public void disconnect() {
		
		try {
			
			ms.leaveGroup(xGroup);
			ms.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		
		}
		
		
	}

	

	@Override
	public void run() {
		
		
		try {
			
			while(true) {
				
				byte[] buffer = new byte[512];
				
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				
				ms.receive(dp);
				
				String msg = new String(dp.getData()).trim();
				
				ta.append(msg+"\r\n");
				
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			disconnect();
		}
		
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
	String msg = tf.getText().trim();
		
		if(msg.equals(""))
			return;
		
		byte[] buffer = (userName +"]"+msg).getBytes(); //getBytes() : String�� byte�� ��ȯ�ϴ� �޼ҵ�
		
		try {
			
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length, xGroup, port);
			
			ms.send(dp);
			
			tf.setText("");
			tf.requestFocus();
			
			
		} catch (Exception e) {
			System.out.println(e1.toString());
		}
		}
	


	public static void main(String[] args) {
		
		new ChatCS().setup();
		
		
		
}
}