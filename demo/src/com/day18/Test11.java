package com.day18;

import java.io.File;
import java.io.IOException;
import java.util.Date;

//File
//���� �� ������ ������ �� �ִ� ����� �����ϴ� Ŭ����
//���� ������ �����, ����, �����ϱ� ���� �޼ҵ�� ����(filelnput/fileOutput)


public class Test11 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("c:\\doc\\test.txt"); //File f = new File(f);
		
		System.out.println("���ϸ�: "+ f.getName());
		System.out.println("���� ������: "+ f.length());
		System.out.println("���ϰ��: "+ f.getAbsolutePath());
		System.out.println("ǥ�ذ��: "+ f.getCanonicalPath());
		System.out.println("���糯: "+ new Date(f.lastModified()));
		System.out.println("�������: "+ f.getParent());
		System.out.println("�б�Ӽ�: "+ f.canRead());
		System.out.println("����Ӽ�: "+ f.canWrite());
		

	}

}
