package com.day13;

//Interface
//1.�߻�Ŭ������ ����. ���� �ְ� ���ǰ� ����
//2. final ������ ������ �� �ִ�
//3.�������̽��� �����Ϸ��� implements�� ����Ѵ�
//4.�ϳ� �̻��� �������̽��� implements�� Ŭ������ �������̽��� ��� �޼ҵ带 ������ �ؾ��Ѵ�.
//5.�������̽��� �ٸ� �������̽��� ��� ���� �� ������ �̶��� extends�� ����Ѵ�
//6.Ŭ�����ʹ� �ٸ��� �������̽��� ���߻���� �����ϴ�

interface Fruit{
	
	String Won = "��"; //final�����̱� ������ �ʱ�ȭ ���ϸ� ����. public static final �����Ǿ�����
	
	int getPrice(); //public abstract�� �����Ǿ� ����
	public String getName(); //abstract�� �����Ǿ� ����
	
}

class FruitImpl implements Fruit { //������ �������̵带 �ؾ���

	@Override
	public int getPrice() {
		
		return 1000;
	}

	@Override
	public String getName() {
		
		return "���";
	}
	
	public String getItems() {
		return "����";
	}
	
	
}


public class Test1 {

	public static void main(String[] args) {
		
		FruitImpl ob1 = new FruitImpl();
		
		System.out.println(ob1.getItems());
		System.out.println(ob1.getName());
		System.out.println(ob1.getPrice()+Fruit.Won);
		
		Fruit ob2 = ob1; //�ڽ��� �θ𿡰�
		
		System.out.println(ob2.getName());
		//System.out.println(ob2.getItems()); �θ� �ڽĲ� ��������

	}

}




