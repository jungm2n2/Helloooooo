package com.day16;


class MyException extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	
	public MyException(String msg) {
		super(msg); //�θ�.������ �����ε� �� new Exception("������ �Է� ����~~");
		
		
	}
	
	
}



public class Test3 {
	
	private int value;
	
	public void setValue1(int value) throws MyException {
		
		if(value<0) {
			throw new MyException("���� 0���� ���� �� �����ϴ�.");
		}else {
			this.value = value;
		}
		
	}

		public void setValue2(int value) throws MyException {
			
			if(value>10) {	
				
				throw new MyException("���� 10���� Ŭ �� �����ϴ�.");
				
			}else {
				this.value = value;
		    }
			
		}
		
	public int getValue() {
		
		return value;
	}

	public static void main(String[] args) {
		
		Test3 ob = new Test3();
		
		try {
			
			ob.setValue1(5);
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		System.out.println(ob.getValue());
		
		
		
		
		
		

	}

}
