package com.svt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test1 extends GenericServlet{
	
//D:\java\work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\
	//work\Catalina\localhost\study\org\apache\jsp	

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");
		
		try {
			
			PrintWriter out = res.getWriter();
			
			out.print("<html>");
			out.print("<head>");
			out.print("<title>");
			out.print("���� ���α׷�</title></head>");
			out.print("<body style='font-size:12pt;'>");
			out.print("ȭ�� �������� �������� JSP�� ���ϴ�");
			out.print("</body>");
			out.print("<html>");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
