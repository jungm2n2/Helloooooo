package com.day20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerTest2 {
	
	
	private ArrayList<Socket> clients = new ArrayList<>();
	
	public void serverStart() {
		
		try {
			ServerSocket ss = new ServerSocket(7777);
			System.out.println("���� ����~");
			
			while(true) {
				
				Socket sc = ss.accept();
				
				WorkerThread th = new WorkerThread(sc);
				th.start();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	class WorkerThread extends Thread{
		
		private Socket sc;
		
		public WorkerThread(Socket sc) {
			this.sc = sc;
		}
		@Override
		public void run() {

			String ip = null;
			String msg = null;
			
			try {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				
				ip = sc.getInetAddress().getHostAddress();
				
				clients.add(sc);
				
				
				//�ٸ� Ŭ���̾�Ʈ���� ���ӻ���� �˸�(���� �����ϰ�)
				msg = ip +"] �� �����߽��ϴ�";
				
				for(Socket s : clients) {
					
					if(s==sc) {
						continue; //�̹��� �н�
					}
					
					PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
					pw.println(msg);
				}
				System.out.println(msg); //������ ��ȭ ����
				
				//�޼��� ����
				while((msg=br.readLine())!=null) {
					
					for(Socket s : clients) {
						
						if(s==sc) {
							continue; //�̹��� �н�
						}
						
						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
					}
					System.out.println(msg);
					sc=null;
					
					
					
					
				}
				
				
				
				
				
				
				
				
				
			} catch (Exception e) {
				
				msg = ip+"] �� �����߽��ϴ�";
				
				try {
					
					for(Socket s : clients) {
						
						if(s==sc) {
							continue; //�̹��� �н�
						}
						
						PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
					}
					System.out.println(msg);
					
				} catch (Exception e2) {
					
				}
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		
		new ServerTest2().serverStart();

	}

}
