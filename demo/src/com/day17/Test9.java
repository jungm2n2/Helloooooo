package com.day17;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//������ �ð����� Ư�� �۾��� ����


public class Test9 extends Thread{
	
	private int num = 0;
	
	public Test9() { //�⺻������
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() { //�ݺ� ���� �� �۾�
				
				num=0;
				
			}
		};
		
		
		Timer t = new Timer();
		
		Calendar now = Calendar.getInstance();
		
		t.schedule(task, now.getTime() , 5000); //5�ʸ��� task�� now.getTime()�� �������� ������Ѷ�
		
		
		
		
		/*	���� 0��0��0�ʺ��� �Ϸ翡 �ѹ��� �ݺ�
		now.add(Calendar.DATE, 1);
		now.set(Calendar.HOUR, 0); //ex ���� 1�ô� 13
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		t.schedule(task, now.getTime() , 1000*60*60*24); //�и�����,��,��,�� */
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			System.out.println(num++);
			
			try {
				sleep(1000);
			} catch (Exception e) {
				
			}
			
		}
	}
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
	/*	Test9 ob = new Test9();
		ob.start();
	*/	
		
		new Test9().start();
		
		
		
		
		
		
		
		
		
		

	}

}
