package com.day17;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//정해진 시간마다 특정 작업을 수행


public class Test9 extends Thread{
	
	private int num = 0;
	
	public Test9() { //기본생성자
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() { //반복 실행 할 작업
				
				num=0;
				
			}
		};
		
		
		Timer t = new Timer();
		
		Calendar now = Calendar.getInstance();
		
		t.schedule(task, now.getTime() , 5000); //5초마다 task를 now.getTime()이 시점부터 실행시켜라
		
		
		
		
		/*	내일 0시0분0초부터 하루에 한번씩 반복
		now.add(Calendar.DATE, 1);
		now.set(Calendar.HOUR, 0); //ex 오후 1시는 13
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		t.schedule(task, now.getTime() , 1000*60*60*24); //밀리세컨,초,분,시 */
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
