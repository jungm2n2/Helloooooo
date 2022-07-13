package com.day13;

interface Test{
	
	public int total();
	public void write();
	
}

class TestImpl implements Test{
	
	private String hak,name;
	private int kor,eng;
	
	public TestImpl() {} //기본생성자 -> 우회도로
	
	
	public TestImpl(String hak, String name, int kor, int eng) { //생성자 오버로딩 -> 자체 초기화
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
	}
	
	public void set(String hak, String name, int kor, int eng) { //우회도로
		
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
	}
	

	@Override
	public int total() { //무조건 오버라이드
		
		return kor+eng;
	}

	@Override
	public void write() {
		
		System.out.println(hak+":"+name+":"+total());
	}

	@Override
	public boolean equals(Object ob) { //업캐스트
									   // TestImpl.ob.equals(ob2) TestImpl Object의 equals를 오버라이드 
		
		boolean flag = false;
		
		if(ob instanceof TestImpl) { //instanceof : ob의 데이터 타입이 무엇인지 알아보는 연산자 
			
			TestImpl t = (TestImpl)ob; //다운캐스트
			
			if(this.hak.equals(t.hak)&&this.name.equals(t.name)) { //String의 equals
				flag = true;
				
			}
		}
		
		return flag;
	}
	
	
}


public class Test2 {

	public static void main(String[] args) {
		
		//인터페이스에서는 Test = new TestImple 사용 가능하지만 그때는 인터페이스(부모)의 메소드만 사용해야한다.
		//자식이 부모화 되었기 때문에
		Test ob1 = new TestImpl("1111", "배수지", 80, 90);
		Test ob2 = new TestImpl("1111", "배수지", 100, 100);
		
		
		
		System.out.println(ob1==ob2);
		
	
		if(ob1.equals(ob2)) //object -> TestImpl
			System.out.println("ob1과 ob2는 동일 인물입니다");
		else
			System.out.println("ob1과 ob2는 동일인물이 아닙니다");
		
		ob1.write();
		ob2.write();
		

	}

}
