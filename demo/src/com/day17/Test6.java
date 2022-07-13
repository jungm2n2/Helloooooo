package com.day17;

//스레드 생명주기

class MyThread6 extends Thread{
	
	@Override
	public void run() {
		
		
		try {
			
			System.out.println("스레드 시작...");
			
			System.out.println("우선순위: "+getPriority());
			System.out.println("스레드 이름: "+getName());
			
			sleep(500); //0.5초 쉬어라
			
			//우선순위 바꾸기
			setPriority(2);
			System.out.println("변경된 우선순위: "+getPriority());
			
			System.out.println("스레드 종료...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}










public class Test6 {

	public static void main(String[] args) {
		
		Thread t1 = Thread.currentThread(); //현재 스레드를 읽어와라 = main
		Thread t2 = new MyThread6();
		
		System.out.println("메인스레드 우선순위: "+t1.getPriority()); //5
		System.out.println("메인스레드 이름: "+ t1.getName()); //main
		
		System.out.println("t2.start 메소드 호출전 isAlive: "+t2.isAlive());
		
		t2.start();
		
		//t2의 우선순위
		System.out.println("t2우선 순위: "+t2.getPriority());
		
		t2.setPriority(1); //우선순위 1로 바꾸기
		
		try {
			Thread.sleep(100); //main 쉬어
			
			System.out.println("t2 살아있냐?: "+t2.isAlive());
			
			Thread.sleep(1000); //main
			
			System.out.println("1초 쉬고 t2 살아있냐?: "+t2.isAlive());
			
			t2.join();
			
			System.out.println("t2 그래도 살아있냐?: "+t2.isAlive());
			
		} catch (Exception e) {
			
		}
		
		
		System.out.println("main 종료...");
		
		

	}

}
