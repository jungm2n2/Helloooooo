package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test8 {

	public static void main(String[] args) throws  IOException {
		
		//πÿ∫Ø(w)∞˙ ≥Ù¿Ã(h)∏¶ ¿‘∑¬πﬁæ∆ ªÔ∞¢«¸¿« ≥–¿Ã(a) ±∏«œ±‚
				//πÿ∫Ø?23.5
				//≥Ù¿Ã?34.7
				//≥–¿Ã:xxx.xx
				//≥–¿Ã = πÿ∫Ø * ≥Ù¿Ã / 2
		

		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int w,h;
		double a;
		
		
		
		System.out.print("πÿ∫Ø?");
		w = Integer.parseInt(br.readLine());
		
		
		System.out.print("≥Ù¿Ã?");
		h = Integer.parseInt(br.readLine());
		
		
		a = w*h/2.0f;
		
		System.out.println("≥–¿Ã=" + a);
	
		
		
		
	
		
		
		
		
		
		

	}

}
