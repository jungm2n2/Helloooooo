package com.day15;

import java.util.Hashtable;
import java.util.Iterator;

//Map<key,value> key�� �ڷ����� ���� ������ value�� ���� class.
//Hashtable(C) - Vector (����ȭ)
//HashMap(C) - ArrayList

//key�� �ߺ����� ������ ����. key-Set(�������̽�)
//key�� �ߺ����� ������ �Ǹ� ���� ������ ���� �����ϰ� �ȴ�(����)
//Map�� iterator�� ����
//(������ �߰�)put-(������ ��������)get


public class Test2 {
	
	public static final String tel1[] = 
		{"111-111","222-222","333-333","111-111","444-444"}; //key
	
	public static final String name[] = 
		{"�����","���γ�","���μ�","���ƶ�","�ڽ���"}; //value


	public static void main(String[] args) {
		
		Hashtable<String, String> h = new Hashtable<>(); //�� �ڷ��� �Է�
		
		for(int i=0;i<name.length;i++) {
		h.put(tel1[i],name[i]);
		
		}
		
		System.out.println(h);
		
		String str;
		str=h.get("111-111"); //()�ȿ� key���� �Է��ϸ� value���� �ش�
		
		if(str==null) {
			System.out.println("�ڷ� ����!");
		}else {
			System.out.println(str);
		}
		
		if(h.containsKey("222-222")) { //()�ȿ� key���� �Է��ϸ� key���� �����ϴ��� ã���ִ� �޼ҵ�
			System.out.println("222-222 �ִ�");
		}else {
			System.out.println("222-222 ����");
		}
		
		if(h.containsValue("���ƶ�")) { //()�ȿ� value���� �Է��ϸ� value���� �����ϴ��� ã���ִ� �޼ҵ�
			System.out.println("���ƶ� �ִ�");
		}else {
			System.out.println("���ƶ� ����");
		}
		
		Iterator<String> it = h.keySet().iterator(); //Map�� keySet�� iterator�� ���
		
		while(it.hasNext()) {
			
			String key = it.next(); //it.next() �� key���� ����. value�� ������ �� ����.
			String value = h.get(key); //value�� ������. str = h.get() ���������ϱ�
			
			System.out.print(key+" "+value);
			
		}
		
		
		
		
		
		
		
		
	}

}
