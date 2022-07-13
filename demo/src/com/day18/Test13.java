package com.day18;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

//객체의 직렬화
//메모리에 생성된 클래스의 변수의 현재 상태를 그대로 보존해서
//파일에 저장하거나 네트워크를 통해 전달하는 기능이다
//데이터의 종류에 상관없이 영속성을 제공할 수 있다
//implements Serializable 구현(메소드가 없다)

public class Test13 {

	public static void main(String[] args) throws Exception {
		
		Hashtable<String, String> h = new Hashtable<>();
		
		h.put("1", "배수지");
		h.put("2", "유인나");
		h.put("3", "정인선");
		
		
		FileOutputStream fos = new FileOutputStream("c:\\doc\\out5.txt"); //file을 만드는 것
		
		ObjectOutputStream oos = new ObjectOutputStream(fos); //ObjectOutputStream
															  //file을 만들어서 map을 저장할 수 있는 능력
		oos.writeObject(h);;
		oos.close();
		fos.close();
		
		System.out.println("파일 저장 성공");

	}

}
