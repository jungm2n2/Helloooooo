package com.day17;

//Deamon ������
//�ٸ� �����忡 ������ �ִ� �������, �ٸ� �����尡(main)�� ����Ǹ�
//���󽺷��尡 �۾��� �Ϸ����� �ʾƵ� ����ȴ�

class MyThread5 implements Runnable{

	@Override
	public void run() {
		
		for(int i=1;i<=20;i++) {
			
			System.out.println(i);
			
			try {
				
				Thread.sleep(1000); //�ϳ� ��� 1�� �����
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}


public class Test5 {

	public static void main(String[] args) {
		
		System.out.println("main ����...");
		
		Thread t1 = new Thread(new MyThread5());
		Thread t2 = new Thread(new MyThread5());
		Thread t3 = new Thread(new MyThread5());
		
		
		
		//���󽺷���
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
		
		
		
		t1.start();
		t2.start();
		t3.start();
		
		
		
		try {
			Thread.sleep(1000); //main��~ 1�� �����
		} catch (Exception e) {
			
		}
		
		try {
			t1.join(); //main��~ t1,t2,t3 �۾��� ���������� ��ٷ�
			t2.join();
			t3.join();
		} catch (Exception e) {
			
		}
		
		
		
		System.out.println("main ����...");
		
		
		

	}

}
