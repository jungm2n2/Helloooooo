package com.excep;

public class OperationAuthenticator {
	
	public void inputFormat(String str) throws AuthenticationException{
		
		String[] temp = str.split(",");
		
		if(temp.length!=2) {
			throw new AuthenticationException("숫자 입력 형식 오류: "+str);
		}
		
	}
	
	@SuppressWarnings("unused")
	public void number(String str) throws AuthenticationException{
		
		try {
			
			if(str.indexOf(".")!=-1) {
				double num = Double.parseDouble(str);
			}else {
				int num = Integer.parseInt(str);
			}
			
		} catch (NumberFormatException e) {
			
			throw new AuthenticationException("숫자 변환 불가: "+str);
			
			
		}
		
		
		
	}
	
	public void operator(char ch) throws AuthenticationException{
		
		switch(ch) {
		case('+') :
			case('-') :
				case('*') :
					case('/') :
						return; //stop
					default:
						throw new AuthenticationException("연산자 오류: "+ch) ;
		}
		
		
	}
	
	 
	
	

}
