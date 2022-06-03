package com.day4;

public class Test3 {

	public static void main(String[] args) {
		
		
		int n,sum;
		
		sum=0;
		
		//100±îÁöÀÇ ÇÕ
		for(n=1;n<=100;n++) {
			sum=sum+n;   //sum+=n;
		}
		
		
		
		sum=0;
		//È¦¼öÀÇ ÇÕ
		for(n=1;n<=100;n+=2) {//n=n+2
			sum+=n; //sum=sum+n
		
			
		}
		
		sum=0;
		//Â¦¼öÀÇ ÇÕ
		for(n=2;n<=100;n+=2) { //
			sum+=n;
		}
		
		int cnt=0;
		for(n=1;n<=100;n++) {
			
			//È¦¼öÀÇ °¹¼ö
			if(n%2!=0) {
				cnt=cnt+1; //cnt++;
			}
			
			
			
			
			
			
		}
		
		System.out.println("È¦¼öÀÇ °¹¼ö:"+cnt);
	
	
		System.out.println("°á°ú:"+sum);
		
		

	}

}
