package com.score6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

public class ScoreDAO2 {//Data Access Object --DB에 insert
	
	
	//DB에 추가 (insert)
	
	public int insertData(ScoreDTO dto) {
		
		int result =0;
		
		Connection conn = DBConn.getConnection();
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		String sql;
		try {
			/*
			sql="insert into score (hak,name,kor,eng,mat) ";
			sql+="values('" + dto.getHak() + "','";
			sql+=dto.getName() + "',";
			sql+=dto.getKor() + ",";
			sql+=dto.getEng() + ",";
			sql+=dto.getMat() + ")";			
			//System.out.println(sql);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			stmt.close();
			*/
			
			sql = "insert into score(hak,name,kor,eng,mat) ";
			sql+="values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getHak());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			
			result = pstmt.executeUpdate();
			
			
			pstmt.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
		
	}
	
	
	//업데이트
	public int updateData(ScoreDTO dto) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update score set kor=?,eng=?,mat=? ";
			sql+= "where hak=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setString(4, dto.getHak());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		
		}
		
		return result;
	
		
		
	}
	//삭제
	public int deleteData(String hak) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql="delete score ";
			sql+="where hak=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,hak);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	//전체출력
	//select 하면 table이 나오는데 담을 그릇 : resultset
	public List<ScoreDTO> getList(){
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql ="select hak,name,kor,eng,mat,";
			sql+="(kor+eng+mat) tot,(kor+eng+mat)/3 ave,";
			sql+="rank() over (order by (kor+eng+mat) desc) rank ";
			sql+="from score";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); //select는 update가 아님. query. 테이블을 담아놓는 그릇
			
			while(rs.next()) { //하이라이트 바 한칸 내려서(next()) 데이터가 있을때까지
				
				ScoreDTO dto = new ScoreDTO(); //dto를 인원수만큼 가져야하기때문에 while문 안에 넣기
				
				dto.setHak(rs.getString(1)); //dto에 담기. rs안에 있는 테이블 첫번째 컬럼의 데이터. 순서는 고정.
				dto.setName(rs.getString("name")); //숫자 대신 컬럼명을 써도 된다. 두번째 컬럼명:name
				dto.setKor(rs.getInt(3));
				dto.setEng(rs.getInt(4));
				dto.setMat(rs.getInt(5));
				dto.setTot(rs.getInt(6));
				dto.setAve(rs.getInt(7));
				dto.setRank(rs.getInt(8));
				
				lists.add(dto);
				
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists; //dto를 담은 리스트 반환
		
		
	}
	
	
	//이름검색
	public List<ScoreDTO> getList(String name){ //오버로딩
		
		List<ScoreDTO> lists = new ArrayList<>();
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select hak,name,kor,eng,mat,";
			sql+="(kor+eng+mat) tot, (kor+eng+mat)/3 ave ";
			sql+="from score where name like ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ScoreDTO dto = new ScoreDTO();
				
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getInt("ave"));
				
				lists.add(dto);
				
				
			}
				
			rs.close();
			pstmt.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	
		return lists;
		
		
	}

	//학번검색
	
	public ScoreDTO getLists(String hak ) {
		
		ScoreDTO dto = null; //값이 없을수도 있기때문에 미리 객체생성 하지 않고 null로 초기화
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select hak,name,kor,eng,mat,";
			sql+="(kor+eng+mat) tot, (kor+eng+mat)/3 ave ";
			sql+="from score where hak=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hak);
			
			rs = pstmt.executeQuery(); //값은 하나 있거나 없거나
			
			if (rs.next()) { //반복문 필요 없음. 값은 있으면 하나.
				dto = new ScoreDTO(); //위에선 null로 초기화. 이때 객체생성
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getInt("ave"));
			}
			
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
		
	
	

}
}
