package com.day7;

import java.util.Random;

public class Lotto {
	
	
	int i,j,temp,n;
	Random rd = new Random();
	int [] num = new int[6];
	
	public void input() {
		
		n=0;
		while(n<6) {
			
			num[n] = rd.nextInt(45)+1;
			
			for(i=0;i<n;i++) {
				
				if(num[i]==num[n]) {
					n--;
					break;
				}
					
			}
			
			n++;
			
		}
		}
		
	public void pan() {
		
		for(i=0;i<num.length-1;i++) { 
			
			for(j=i+1;j<num.length;j++) {
				
				if(num[i]>num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					
				}
			}
				
		}
		
		}	
	
	
    public void print() {
    	
    	for(i=0;i<6;i++) {
    		System.out.printf("%4d",num[i]);
    		
    	}
   }
    
     

}
