package com.day15;

public class BmiVO {
	
	public String name,pan;
	public double weg,hei, bmi;
	
	
	public double getBmi() {
		return weg/(hei*0.01*hei*0.01);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeg() {
		return weg;
	}
	public void setWeg(double weg) {
		this.weg = weg;
	}
	public double getHei() {
		return hei;
	}
	public void setHei(double hei) {
		this.hei = hei;
	}
	
	
	public String pan() {
		
		String pan1 = " ";
		
		
			if	(getBmi()>=30) {
				pan1 = "고도비만";
			}else if(getBmi()>=25) {
				pan1 = "비만";
			}else if(getBmi()>=23) {
				pan1 = "과체중";
			}else if(getBmi()>=18.5) {
				pan1 = "정상";
			}else  {
				pan1 = "저체중";
		}
			return pan1;
	
	}
	
	@Override
	public String toString() {
		
		String str = String.format("%6s %6.1f %6.1f %6.1f %6s",name,weg,hei,getBmi(),pan());
		
		return str;
	}


	
	
	
	

}
