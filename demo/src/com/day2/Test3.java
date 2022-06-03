package com.day2;

public class Test3 {

	public static void main(String[] args) {
	
		int r = 10;
		float area,length;
		//float=소수점 저장, 정수는 x
		
		area = 10; //(10.0)
		System.out.println(area);
		
				
		//r = (int)20.0; = (int) = int로 형변환
		//System.out.println(r);
		
		area = r*r*3.14f;
		//소수점을 쓸거면 f(float) 써주기
		length = r*2*3.14f;
		
		System.out.printf("반지름:%d, 넓이:%f\n",r,area);
		System.out.printf("반지름:%d, 넓이:%.2f\n",r,area);
		System.out.println("반지름:" + r + ", 둘레:"+length);
	
		
	
		

	}

}
