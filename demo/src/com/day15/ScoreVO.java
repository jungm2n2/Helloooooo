package com.day15;

public class ScoreVO {
	
	public String name,pan1; 
	
	public int kor,eng,mat,tot;
	
	
	
	
	public int getTot() {
		return kor+eng+mat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	

	public String pan1(int score) {
		
		String pan = " ";
		
		switch(score/10) {
		
		case 10:
		case 9:
			pan = "수"; break;
		case 8:
			pan = "우" ;break;
		case 7:
			pan = "미" ;break;
		case 6:
			pan = "양" ;break;
		default :
			pan = "가"; break;
		
		}
	return pan;
		
	}
	
	
	
	
	
	@Override
	public String toString() {
		
		String str = String.format("%6s %4d %4d %4d %4d %4.1f %4s"
				,name,kor,eng,mat,getTot(),getTot()/3.0,pan1(getTot()/3));
		
		return str;
	}
	
	
	
	

}
