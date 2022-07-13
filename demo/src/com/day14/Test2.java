package com.day14;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Test2 {
	
	private static String city[] = {"����","�λ�","�뱸","��õ","����","����","���"};

	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>();
		System.out.println("�ʱ�뷮: "+v.capacity() + "��");
		
		for(String c : city) {
			v.add(c);
		}
		
		//v.add(10); String ���¸� �� �� ����. ��������x
		
		
		
		String str;
		
		str = v.firstElement(); //index 0
		System.out.println(str);
		
		str = v.get(1);
		System.out.println(str);
		
		str = v.lastElement(); //6
		System.out.println(str);
		
		System.out.println(v.size() + "��");
		
		for(int i=0;i<v.size();i++) {
			
			System.out.print(v.get(i) + " ");
			
		}
		
		System.out.println();
		//----------------------------------------
		for(String c : v) {
			System.out.print(c + " ");
			
		}
		
		System.out.println();
		
		//----------------------------------
		//�ݺ���. Collection�� ���� �ݺ���
		
		Iterator<String> it = v.iterator();
		
		while(it.hasNext()) {//it�ȿ� �����͸� ����������������
			
			str = it.next(); //�ϳ� ������
			System.out.print(str + " ");
			
		}
		
		while(it.hasNext()) {
			
			str = it.next(); 
			System.out.print(str + " ");
			
		}
		System.out.println();
		
		//����
		v.set(0, "Seoul");
		v.set(1, "Pusan");
		
		for(String c : v) {
			System.out.print(c + " ");
		}
		
		
		System.out.println();
		
		//����
		v.insertElementAt("���ѹα�", 0);
		System.out.println(v.size() + "��");
		
		for(String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		
		//�˻�
		int idx = v.indexOf("�뱸");
		if(idx != -1) {
			System.out.print("�˻����� : " +idx);
		}else {
			
			System.out.println("�˻����� : " + idx);
			
		}
		System.out.println();
		
		
		//��������(1->10, a->z)
		Collections.sort(v);
		
		for(String c : v) {
			System.out.print(c + " ");
		
		}
		
		System.out.println();
		
		//��������(10->1, z->a)
		Collections.sort(v, Collections.reverseOrder());
		for(String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		//����
		v.remove("Pusan");
		for(String c : v) {
			System.out.print(c + " ");
		
		}
		System.out.println();
		
		
		System.out.println("�������� : "+v.capacity());
		System.out.println("������ ���� : "+v.size());
		
		//���� ����
		for(int i=1;i<=20;i++) {
			v.add(Integer.toString(i));
		}
		
		for(String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();

		System.out.println("�������� : "+v.capacity());
		System.out.println("������ ���� : "+v.size());
		
		
		//���� ����
		for(int i=1;i<=10;i++) {
			v.remove(5);
		}
		
		
		for(String c : v) {
			System.out.print(c + " ");
		}
		System.out.println();

		System.out.println("�������� : "+v.capacity());
		System.out.println("������ ���� : "+v.size());
		
		
		//�� ���� ����
		v.trimToSize();
		System.out.println("�������� : "+v.capacity());
		System.out.println("������ ���� : "+v.size());
		
		//��� ������ ����
		v.clear();
		System.out.println("�������� : "+v.capacity());
		System.out.println("������ ���� : "+v.size());
		
	
	
	
	
	}
}