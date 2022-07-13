package com.day20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//����ȭ ǥ����
//�ܾ� �ٲٱ�, �����ּ� �˻�, 

/*

c[a-z]* : c�� �����ϴ� ���ܾ�
c[a-z] : c�� �����ϴ� �α��� ���ܾ�

c[a-zA-Z0-9] : ca,cA,c4
c. : c�� �����ϴ� �α���
c.* : c�� �����ϴ� ��繮��
c.*t : ct,chhhht,c7777t

[\\d]+ �Ǵ� [0-9]+ : �ϳ� �̻��� ����


*/

public class Test1 {

	public static void main(String[] args) {
		
		String[] str = {"bat","baby","bonus","c","cA","ca","c0","car","combat","count","date","disc"};
		
		
		Pattern p;
		
		p = Pattern.compile("c[a-z]*");
		
		for(String s : str) {
			
			Matcher m = p.matcher(s);
			if(m.matches()) {
				System.out.println(s);
			}
			
			
		}
		
		System.out.println("--------------");
		
		p = Pattern.compile("c[a-z]+");
		
		for(String s : str) {
			
			Matcher m = p.matcher(s);
			if(m.matches()) {
				System.out.println(s);
				

	}
		}
		
		
		
		System.out.println("--------------");
		
		p = Pattern.compile("c.");
		
		for(String s : str) {
			
			Matcher m = p.matcher(s);
			if(m.matches()) {
						System.out.println(s);
						
						
						
			}
		}
		
		System.out.println("--------------");
		
		String[] mails = {"aaaa@aaa.com","@aaa.co.kr",".@bbb.ccc"
				,"aaa@vvv.co.kr","sss.co.kr","abc@abc"};
		
		//[\\w]+ : �ѱ��� �̻��� ��,����
		//@
		//(\\.[\\w]+) : ��ȣ �ȿ� �ִ°��� �ݵ�� �ѹ��� ����ؾ��Ѵ�
		// \\.:��Ʈ
		
		String pat = "[\\w]+@[\\w]+(\\.[\\w]+)+";
		
		for(String s : mails) {
			if(Pattern.matches(pat, s)) {
				System.out.println(s);
			}
		}
		
		
		
		
		
	}
	
	
	
}