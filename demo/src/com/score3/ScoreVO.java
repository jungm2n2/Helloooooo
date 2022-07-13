package com.score3;

public class ScoreVO {//Value Object
	
	
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;

	
	public String getHak() {
		return hak;
	}



	public void setHak(String hak) {
		this.hak = hak;
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



	public int getTot() {
		return kor+eng+mat;
	}



	@Override
	public String toString() {
		
		if(hak==null||hak.equals("")) {
			return null;
		}
		
		String str = String.format("%5s %6s %4d %4d  %4d %4d %4.1f",
				hak,name,kor,eng,mat,(kor+eng+mat),(kor+eng+mat)/3.0);
		return str;
		
	}
	
	

	public String print() {
		
		if(hak==null||name==null) {
			return null;
		}
		
		String str = String.format("%5s %6s %4d %4d  %4d %4d %4.1f",
				hak,name,kor,eng,mat,getTot(),getTot()/3.0);
		
		return str;
		
	}
	
	
	
	
	
	
	
	
}
