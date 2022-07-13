package com.day19;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test4 extends Frame implements ActionListener {
	
	
	
	private TextField tf;
	private TextArea ta;
	private Button btn;
	
	public Test4() {
		
		tf = new TextField(); //class이기 때문에 사용하기 위해 객체생성
		ta = new TextArea();
		btn = new Button("추가");
		
		add(tf,BorderLayout.NORTH);
		add(ta,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		
		tf.addActionListener(this);
		btn.addActionListener(this);
		
		
		setTitle("윈도우");
		setSize(200, 300);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setVisible(true);
		
		
	}
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		new Test4();
		
		
		
		
		

	}



	@Override
	public void actionPerformed(ActionEvent evt) {
		
		Object ob = evt.getSource();
		
		if(ob instanceof TextField || ob instanceof Button) {
			
			String str = tf.getText();
			
			if(!str.equals("")) {
				
				ta.append(str + "\r\n");
				
			}
			
			tf.setText("");
			tf.requestFocus();
			
			
			
			
			
		}
		
	
		
		
		
	}

}
