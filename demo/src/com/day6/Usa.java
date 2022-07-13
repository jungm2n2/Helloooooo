package com.day6;

import com.day7.Rect;

public class Usa {

	public static void main(String[] args) {
		
		Rect ob =  new Rect();
		
		ob.input();
		int x = ob.area();
		int y = ob.length();
		ob.print(x, y);

	}

}
