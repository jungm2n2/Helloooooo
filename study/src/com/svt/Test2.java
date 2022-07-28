package com.svt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test2 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp); //�ٹ�Ŀ��� ����Ʈ������� �Ѱ��ֱ�
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	//1.ServletConfig �������̽�
		
		ServletConfig config = getServletConfig();
		
		String name = config.getInitParameter("name");
		String age = config.getInitParameter("age");
		
	//2.ServletContext �������̽�
		
		ServletContext context = getServletContext();
		
		String gender = context.getInitParameter("gender");
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html><body>");
		out.print("name: "+name+"<br/>");
		out.print("age: "+age+"<br/>");
		out.print("gender: "+gender+"<br/>");
		out.print("</body></html>");
		
		
		
	}
	
	
	

}
