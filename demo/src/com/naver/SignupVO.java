package com.naver;

public class SignupVO {
	
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birth;
	private String email;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFm() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	private String tel;
	
	
	@Override
	public String toString() {
		
		String str = String.format("%6s %6s %6s %6s %6s %6s %6s"
				,id,pw,name,gender,birth,email,tel);
		
		return str;
	}
	
	
	

}
