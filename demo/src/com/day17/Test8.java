package com.day17;

class MyThread8 implements Runnable{

	private int bank = 10000; //�ܰ�
	
	private int getBank() {
		return bank;
	}
	
	private int drawMoney(int m) {
		bank-=m; //bank=bank-m
		return m; //�� �ݾ� ��������
	}
	
	@Override
	public void run() {
		
		int money_need = 6000; //����ݾ�
		int money;
		String msg = "";
		
		try {
			
			synchronized (this) { //����ȭ ��
				
			
				
				if(getBank()>=money_need) {
					
					
					money = drawMoney(money_need);
					msg = "���� ����";
				}else {
					money=0;
					msg = "���� ����";
				}
			}
		System.out.println(Thread.currentThread().getName()+
				msg+", ����ݾ�: "+money+",�ܰ�: "+getBank());	
			
			
			
			
			
			
			
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
