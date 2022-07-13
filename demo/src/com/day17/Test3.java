package com.day17;

import java.util.Calendar;

class TClock implements Runnable{
	
	

	@Override
	public void run() {
		
		
		
		
		while(true) {
			
			Calendar now = Calendar.getInstance();
			
			System.out.printf("%1$tF %1$tT\n",now);
		
		
			try {
				
				Thread.sleep(1000); 
				
				
			} catch (Exception e) {
			
			}
			
			
		}
		
	}
		
		
}		
		
	













public class Test3 {

	public static void main(String[] args) {
		
		
		Thread t1 = new Thread(new TClock());
		t1.start();
				
		
		

	}

}
