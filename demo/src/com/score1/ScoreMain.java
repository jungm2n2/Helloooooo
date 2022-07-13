package com.score1;

public class ScoreMain {

	public static void main(String[] args) {
		
		
		Score ob = new Score(); //객체생성
		
		ob.set();
		//ob.inwon = 4;
		ob.input();
		//ob.ranking(); private이므로 외부에서 사용할 수 없음
		ob.print();
		

	}

}
