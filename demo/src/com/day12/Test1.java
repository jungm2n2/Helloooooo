package com.day12;

import java.util.Calendar;
import java.util.GregorianCalendar;

//Calendar

public class Test1 {

	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		//Calendar now = new GregorianCalendar();
		
		int y = now.get(Calendar.YEAR); //��
		int m = now.get(Calendar.MONTH)+1; //��(0~11)
		int d = now.get(Calendar.DATE); //��
		int w = now.get(Calendar.DAY_OF_WEEK); //���� ��(1~7:�Ͽ���->1)
		
		String[] week = {"��","��","ȭ","��","��","��","��"};
		
		System.out.println(y + "-" + m + "-" + d + "-" + week[w-1]);
		
		int startDay = now.getActualMinimum(Calendar.DATE);
		int endDay = now.getActualMaximum(Calendar.DATE);
		
		System.out.println(startDay + ":" + endDay);
		
		System.out.printf("%tF\n",now); //��¥
		System.out.printf("%tT\n",now); //�ð�
		
		System.out.printf("%1$tF %1$tT\n",now);
		
		
		now.set(2022, 6-1, 10);; //10��10��
		y = now.get(Calendar.YEAR); //��
		m = now.get(Calendar.MONTH)+1; //��(0~11)
		d = now.get(Calendar.DATE); //��
		w = now.get(Calendar.DAY_OF_WEEK); //���� ��(1~7:�Ͽ���->1)
		
		System.out.println(y + "-" + m + "-" + d + "-" + week[w-1]);
		

		

	}

}
