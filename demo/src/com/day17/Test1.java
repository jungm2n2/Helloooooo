package com.day17;


class MyThread1 extends Thread{ //Thread class 상속받아서 사용
	private int num;
	private String name;
	
	public MyThread1(int num, String name) { //생성자
		this.num = num;
		this.name = name;

	}
	
	
	@Override
	public void run() { //Thread의 run을 오버라이딩
		
		int i=0;
		
		while(i<num) {
			System.out.println(this.getName()+":"+name+i);
			i++;
			
			try {
				sleep(100); //0.1초 쉬어라 (1000:1초)
				
				
			} catch (Exception e) {
			
			}
			
			
			
		}
		
		
		

	}
	
	
	
	
	
	
}








public class Test1 {

	public static void main(String[] args) {
		
		
		System.out.println("main 시작...");
		
		MyThread1 t1 = new MyThread1(100,"첫번째: "); //생성자를 사용하여 초기화
		MyThread1 t2 = new MyThread1(200,"두번째: ");
		
		t1.start(); //run()메소드 실행
		t2.start();
		
		System.out.println("main 종료...");
		
		
		
		
		
		
		
		
		
		

	}

}
