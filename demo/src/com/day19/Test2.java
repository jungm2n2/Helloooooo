package com.day19;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test2 extends Frame {
	
	public Test2() {
		
		setTitle("������");
		setSize(200, 300);
		
		addWindowListener(new MyWindowAdapter());
		
		setVisible(true);
		
		
	}
	
	//����Ŭ����
	
	
	class MyWindowAdapter extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			
			System.exit(0);
			
		}
		
		
		
		
		
	}
	
	
	

	public static void main(String[] args) {
		
		new Test2();

	}

}









