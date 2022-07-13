package com.day18;

import java.io.IOException;
import java.io.OutputStream;


//out : 출력

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		
		OutputStream os = System.out; //out :콘솔창에 내보냄
		
		byte[]b = new byte[3]; //buffer
		
		b[0] = 65;
		b[1] = 97;
		b[2] = 122;
		
		os.write(b);
		os.close(); //데이터를 내보내고나서 안닫아주면 쓰레기값이 생김. 꼭 닫아주기.
		
		System.out.println("나 보이냐?"); //위에서 콘솔창을 닫아줬기때문에 안보임
		
		
		

	}

}
