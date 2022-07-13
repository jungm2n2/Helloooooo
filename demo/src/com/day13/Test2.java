package com.day13;

interface Test{
	
	public int total();
	public void write();
	
}

class TestImpl implements Test{
	
	private String hak,name;
	private int kor,eng;
	
	public TestImpl() {} //�⺻������ -> ��ȸ����
	
	
	public TestImpl(String hak, String name, int kor, int eng) { //������ �����ε� -> ��ü �ʱ�ȭ
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
	}
	
	public void set(String hak, String name, int kor, int eng) { //��ȸ����
		
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
	}
	

	@Override
	public int total() { //������ �������̵�
		
		return kor+eng;
	}

	@Override
	public void write() {
		
		System.out.println(hak+":"+name+":"+total());
	}

	@Override
	public boolean equals(Object ob) { //��ĳ��Ʈ
									   // TestImpl.ob.equals(ob2) TestImpl Object�� equals�� �������̵� 
		
		boolean flag = false;
		
		if(ob instanceof TestImpl) { //instanceof : ob�� ������ Ÿ���� �������� �˾ƺ��� ������ 
			
			TestImpl t = (TestImpl)ob; //�ٿ�ĳ��Ʈ
			
			if(this.hak.equals(t.hak)&&this.name.equals(t.name)) { //String�� equals
				flag = true;
				
			}
		}
		
		return flag;
	}
	
	
}


public class Test2 {

	public static void main(String[] args) {
		
		//�������̽������� Test = new TestImple ��� ���������� �׶��� �������̽�(�θ�)�� �޼ҵ常 ����ؾ��Ѵ�.
		//�ڽ��� �θ�ȭ �Ǿ��� ������
		Test ob1 = new TestImpl("1111", "�����", 80, 90);
		Test ob2 = new TestImpl("1111", "�����", 100, 100);
		
		
		
		System.out.println(ob1==ob2);
		
	
		if(ob1.equals(ob2)) //object -> TestImpl
			System.out.println("ob1�� ob2�� ���� �ι��Դϴ�");
		else
			System.out.println("ob1�� ob2�� �����ι��� �ƴմϴ�");
		
		ob1.write();
		ob2.write();
		

	}

}
