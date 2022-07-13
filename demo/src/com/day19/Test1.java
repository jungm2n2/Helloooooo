package com.day19;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//AWT (Abstract Window ToolKit) -> Swing -> FX

public class Test1 extends Frame implements WindowListener{
	
	
	
	
	public Test1() { //생성자
		
		setTitle("자바 윈도우");
		setSize(200, 300);
		setBackground(new Color(255, 255, 0)); //0~255
		
		addWindowListener(this);
		
		setVisible(true);
		
		
	
		
	}


	public static void main(String[] args) {
		
		new Test1();
		
		

	}


	@Override
	public void windowActivated(WindowEvent e) {
	}


	@Override
	public void windowClosed(WindowEvent e) {
	}


	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
	}


	@Override
	public void windowIconified(WindowEvent e) {
	}


	@Override
	public void windowOpened(WindowEvent e) {
	}


	


}
