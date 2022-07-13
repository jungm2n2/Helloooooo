package com.day18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//inputStreamReader
//1byte stream을 2byte의 스트림으로 변환
//bridge stream
//변환한걸 담을것이 꼭 필요함 = Reader

public class Test3 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.println("문자열 입력");
		
		Reader rd = new InputStreamReader(System.in);
	// 3. 담아줌    2. 2바이트로 변환해서  1.1바이트를 받아서	
		while((data=rd.read())!=-1) {
			char ch = (char)data;
			System.out.print(ch);
		}

	}

}
