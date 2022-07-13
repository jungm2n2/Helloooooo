package com.day11;

public class Test5 {

	public static void main(String[] args) {
		
		String s1 = "����,�λ�,�뱸";
		String ss [] = s1.split(","); //s1 �ȿ� �ִ� �����͸� ��ǥ(,)�� �����ؼ� �迭�� �־��.
		
		for(String s : ss) {
			System.out.print(s + " ");
			
		}
		
		System.out.println();
		
		String s2 = "seoul";
		String s3 = "Seoul";
		System.out.println(s2==s3); //�ּ� ��. false
		System.out.println(s2.equals(s3)); //������ ��. false
		System.out.println(s2.equalsIgnoreCase(s3)); //��ҹ��� ������ ���� ���϶�
		
		String s4 = "abc.def.hij";
		//index :    01234567890 //String�� �ڵ����� index��ȣ�� ���´�
		System.out.println(s4.indexOf(".")); //�տ������� ù��°�� ������ '.'�� index ��ġ. 3
		System.out.println(s4.lastIndexOf(".")); //�ڿ������� ù��°�� ������ '.'�� index ��ġ. 7
		System.out.println(s4.indexOf("def")); //def�� ���۵Ǵ� ���� index ��. 4
		System.out.println(s4.indexOf("x")); //x�� ã�ƶ�. �����Ͱ� �����ϱ� -1
		
		
		String s5 = "�츮���� ���ѹα� �������� ���ѹα�";
		String s6 = s5.replaceAll("����", "����"); //������ ���ڷ� �ٲ��
		System.out.println(s6);
		
		String s7 = "  a  b  c  ";
		System.out.println(s7);
		System.out.println(s7.trim());//������ ������ ���ֶ�
		System.out.println(s7.replaceAll(" ", ""));
		System.out.println(s7.replaceAll("\\s", "")); //��� ���� �������� ����ϴ� ����. ����ȭ ǥ����
		
		
		char ch = "abcdefg".charAt(2);
		System.out.println(ch);
		System.out.println(Integer.toString(ch));
		
		
		System.out.println("abcdefg".startsWith("abc")); //abc�� ���� �ϴ°�. true
		System.out.println("�ڹ����α׷�".startsWith("�ڹ�"));
		
		System.out.println("abcdefg".length()); //7
		
		String s8 = "abcdefg";
		String s9 = "abcdffg";
		
		//������ ���� ((ASCII)�ڵ尪�� ����)
		System.out.println(s8.compareTo(s9)); //-1 �ƽ�Ű������ ��
		System.out.println(s9.compareTo(s8)); //1
		

	}

}
