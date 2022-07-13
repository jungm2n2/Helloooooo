package com.score6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

public class ScoreDAO2 {//Data Access Object --DB�� insert
	
	
	//DB�� �߰� (insert)
	
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
	
	
	//������Ʈ
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
	//����
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
	
	//��ü���
	//select �ϸ� table�� �����µ� ���� �׸� : resultset
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
			
			rs = pstmt.executeQuery(); //select�� update�� �ƴ�. query. ���̺��� ��Ƴ��� �׸�
			
			while(rs.next()) { //���̶���Ʈ �� ��ĭ ������(next()) �����Ͱ� ����������
				
				ScoreDTO dto = new ScoreDTO(); //dto�� �ο�����ŭ �������ϱ⶧���� while�� �ȿ� �ֱ�
				
				dto.setHak(rs.getString(1)); //dto�� ���. rs�ȿ� �ִ� ���̺� ù��° �÷��� ������. ������ ����.
				dto.setName(rs.getString("name")); //���� ��� �÷����� �ᵵ �ȴ�. �ι�° �÷���:name
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
		return lists; //dto�� ���� ����Ʈ ��ȯ
		
		
	}
	
	
	//�̸��˻�
	public List<ScoreDTO> getList(String name){ //�����ε�
		
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

	//�й��˻�
	
	public ScoreDTO getLists(String hak ) {
		
		ScoreDTO dto = null; //���� �������� �ֱ⶧���� �̸� ��ü���� ���� �ʰ� null�� �ʱ�ȭ
		
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
			
			rs = pstmt.executeQuery(); //���� �ϳ� �ְų� ���ų�
			
			if (rs.next()) { //�ݺ��� �ʿ� ����. ���� ������ �ϳ�.
				dto = new ScoreDTO(); //������ null�� �ʱ�ȭ. �̶� ��ü����
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
