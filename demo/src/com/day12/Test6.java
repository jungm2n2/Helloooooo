
package com.day12;
//final�� ����� �� �ִ� ������ ���.
//������ final�� ����ϸ� �� �ѹ��� �ʱ�ȭ ����
//�޼ҵ忡 final�� ����ϸ� Override�� �Ұ���
//Ŭ������ final�� ���̸� ����� �Ұ���

//final class Super{
class Super{
	
	public static final double PI; //final ������ �ʱ�ȭ
	
	static {
		PI = 3.14;
		
	}
	
	public double area;
	
	public final void write(String title) {
		System.out.println(title+":"+area);
		
		
	}
	


}
public class Test6 extends Super{
	
	//public void write(String title){ �������̵� �Ұ���
		
	public void circleArea(int r) {
		
		area = (double)r*r*PI;
	}
		
	

	public static void main(String[] args) {
		
		
		Test6 ob = new Test6();
		
		
		ob.circleArea(10);
		ob.write("��");
		

	}

}
