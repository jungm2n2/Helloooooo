package com.day17;

class MyThread8 implements Runnable{

	private int bank = 10000; //잔고
	
	private int getBank() {
		return bank;
	}
	
	private int drawMoney(int m) {
		bank-=m; //bank=bank-m
		return m; //뺀 금액 가져오기
	}
	
	@Override
	public void run() {
		
		int money_need = 6000; //인출금액
		int money;
		String msg = "";
		
		try {
			
			synchronized (this) { //동기화 블럭
				
			
				
				if(getBank()>=money_need) {
					
					
					money = drawMoney(money_need);
					msg = "인출 성공";
				}else {
					money=0;
					msg = "인출 실패";
				}
			}
		System.out.println(Thread.currentThread().getName()+
				msg+", 인출금액: "+money+",잔고: "+getBank());	
			
			
			
			
			
			
			
		} catch (Exception e) {
			
		}
	}
	
	
	
	
}

public class Test8 {

	public static void main(String[] args) {
		
		MyThread8 ob = new MyThread8();
		
		Thread t1 = new Thread(ob); //Thread t1 = new Thread(new MyThread8());
		Thread t2 = new Thread(ob);
		
		t1.start();
		t2.start();
		
		

	}

}
