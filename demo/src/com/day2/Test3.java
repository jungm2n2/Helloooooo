package com.day2;

public class Test3 {

	public static void main(String[] args) {
	
		int r = 10;
		float area,length;
		//float=�Ҽ��� ����, ������ x
		
		area = 10; //(10.0)
		System.out.println(area);
		
				
		//r = (int)20.0; = (int) = int�� ����ȯ
		//System.out.println(r);
		
		area = r*r*3.14f;
		//�Ҽ����� ���Ÿ� f(float) ���ֱ�
		length = r*2*3.14f;
		
		System.out.printf("������:%d, ����:%f\n",r,area);
		System.out.printf("������:%d, ����:%.2f\n",r,area);
		System.out.println("������:" + r + ", �ѷ�:"+length);
	
		
	
		

	}

}
