package com.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyDataMain {

	public static void main(String[] args) throws Exception{
		
		
		FileOutputStream fos = new FileOutputStream("c:\\doc\\out6.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		
		oos.writeObject(new MyData("�����", 30));
		oos.writeObject(new MyData("���γ�", 40));
		oos.writeObject(new MyData("���μ�", 30));
		oos.writeObject(new MyData("���ξ�", 32));
		
		oos.close();
		fos.close();
		
		
		//������ȭ
		
		FileInputStream fis = new FileInputStream("c:\\doc\\out6.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		MyData ob = null;
		
		try {
			
		while(true) {
			
			ob=(MyData)ois.readObject();
			
			if(ob==null)
				break;
			
			System.out.println(ob.toString());
			
			
		}
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		

	}

}
