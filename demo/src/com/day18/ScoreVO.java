package com.day18;

import java.io.Serializable;

public class ScoreVO implements Serializable{
	
	private String name, birth;
	private int num;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		
		String str = String.format("%6s %6s %4d",name,birth,num);
				
		return str;		
	}
	
	
	

}
