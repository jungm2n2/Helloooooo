package come.score5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Score {
	
	private List<ScoreVO> lists = null;
	
	private String path = System.getProperty("user.dir"); //환경설정
	private File f = new File(path, "\\data\\score.txt");
	
	public Score() {
		
		try {
			
			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			
			if(f.exists()) {
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				lists = (ArrayList<ScoreVO>)ois.readObject();
				
				fis.close();
				ois.close();
				
			}
			
		} catch (Exception e) {
			
	}
	}	
	//입력
	
	public void input() {
	
		Scanner sc = new Scanner(System.in);
		
		ScoreVO vo = new ScoreVO();
		
		System.out.print("이름?");
		vo.setName(sc.next());
		
		System.out.print("생일?");
		vo.setBirth(sc.next());
		
		System.out.println("점수?");
		vo.setScore(sc.nextInt());
		
		//처음실행 후 데이터 입력시 객체를 생성
		
		if(lists==null) {
			lists = new ArrayList<>();
		}
		
		lists.add(vo);
	
	}
	
	//출력
	public void print() {
		
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext()) {
			
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
			
		}
		
	}
	
	//파일저장
	
	public void saveFile() {
		
		try {
			
			if(lists!=null) {
				
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(lists);
				
				fos.close();
				oos.close();
				
				System.out.println("파일 저장 성공");
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
