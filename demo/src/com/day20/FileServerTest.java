package com.day20;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServerTest {
	
	class WorkThread extends Thread{
		
		private Socket sc = null;
		
		public WorkThread(Socket sc) {
			this.sc = sc;			
		}
		
		@Override
		public void run() {
			
			try {
				ObjectInputStream ois =
					new ObjectInputStream(sc.getInputStream());
				
				System.out.println("Ŭ���̾�Ʈ ����...");
				
				FileOutputStream fos = null;
				Object ob = null;
				
				while((ob=ois.readObject())!=null) {
					
					if(ob instanceof FileInfo) {
						
						FileInfo info = (FileInfo)ob;
						
						if(info.getCode()==100) {//�������۽���
							
							String str = new String(info.getData());//���ϸ�
							
							fos = new FileOutputStream(str);//���� ����
							
							System.out.println(str + " ���� ���� ����!!!");							
							
						}else if(info.getCode()==110) {
							
							if(fos==null) {
								break;
							}
							
							fos.write(info.getData(),0,info.getSize());
							
							System.out.println(info.getSize() + "bytes �޴���...");
														
						}else if(info.getCode()==200) {
							
							if(fos==null)
								break;
							
							String str = new String(info.getData());
							
							fos.close();
							
							System.out.println(str + "���� ���� ��...");
							break;
						}
						
					}
					
				}
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}			
			
		}
		
	}
	
	public void serverStart() {
		
		try {
			
			ServerSocket ss = new ServerSocket(7777);
			System.out.println("Ŭ���̾�Ʈ ���� �����...");
			
			Socket sc = ss.accept();
			
			WorkThread th = new WorkThread(sc);
			th.start();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	public static void main(String[] args) {
		new FileServerTest().serverStart();
	}

}




