package com.day7;

public class Odd {
	
	
	int i,cnt;
	
	
	public int pan() {
		for(i=1;i<=150;i++) {
			if(i%2==1) {
				cnt++;
			}
		}
	
		return cnt;
	}
	
	public void print() {
		System.out.println("È¦¼öÀÇ °¹¼ö´Â "+cnt+"°³ ÀÔ´Ï´Ù");
		
	}
	

}
