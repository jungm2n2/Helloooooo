package com.day18;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score  {
	
	private List<ScoreVO> lists = null;
	
	Scanner sc = new Scanner(System.in);
	
	String str = "c:\\doc\\out7.txt";
	private File f = new File(str);
	
	
	public ScoreImpl () throws Exception { //������ ������༭ Main���� ���� ó������ ����ǰ� �����.
		
		if(!f.getParentFile().exists()) {
			f.getParentFile().mkdirs();
		}
		
		if(f.exists()) {
			FileInputStream fis = new FileInputStream(str);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			lists = (ArrayList<ScoreVO>)ois.readObject();
			
			fis.close();
			ois.close();
			
		}
		
		
	}
	
	

	@Override
	public void input() {
		
		ScoreVO vo = new ScoreVO();
		
		System.out.println("�̸�?");
		vo.setName(sc.next());
		
		System.out.println("����?");
		vo.setBirth(sc.next());
		
		System.out.println("����?");
		vo.setNum(sc.nextInt());
		
		if(lists==null) {
			
			lists = new ArrayList<>();
		}
		
		lists.add(vo);
		
		
	}

	@Override
	public void print() {
		
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext()) {
			
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
			
		}
		
	}

	@Override
	public void save() {
		try {
			
			if(lists!=null) {
				FileOutputStream fos = new FileOutputStream(str);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(lists);
				
				fos.close();
				oos.close();
				
				System.out.println("���� ���� �Ϸ�");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
			
		
		
		
		
	
	
	
	}
}
