package com.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;
import com.score6.ScoreDTO;

public class GuestDAO {
	
	//입력
	
	public int insertData(GuestDTO dto) {
		
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql="insert into guestRecord1(id,content) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//pstmt.setString(1, );
			pstmt.setString(2, dto.getContent());
			
		
			result = pstmt.executeUpdate();
			
		
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	
		return result;
		
		
	}
	//조회
	
	public GuestDTO getList(String id) {
		
		GuestDTO dto = null;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select id, content,created from guestRecord1 where id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery(); 
			
			if (rs.next()) {
				dto = new GuestDTO();
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setCreated(rs.getString("created"));
				
			}
			
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
		
	
	

}
	//수정
	public int updateData(GuestDTO dto) {
	int result = 0;
	
	Connection conn = DBConn.getConnection();
	PreparedStatement pstmt = null;
	String sql;
	
	try {
		
		sql = "update guestRecord1 set content=? ";
		sql+= "where id=?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getContent());
		pstmt.setString(2, dto.getId());
	
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
	} catch (Exception e) {
		System.out.println(e.toString());
	
	}
	
	return result;

	
	
	}
	
	//삭제
	
	public int deleteData(GuestDTO dto) {
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "delete guestRecord1 ";
			sql+= "where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
		
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		
		}
		
		return result;

		
		
		}
	
	//아이디 체크하는 메소드
		public GuestDTO getLists(String id){ //오버로딩
			
			List<GuestDTO> lists = new ArrayList<>();
			GuestDTO dto = null;
			Connection conn = DBConn.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;
			
			try {
				
				sql="select id,pwd,name ";
				sql+="from guestCustom1 where id=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1,id);
				
				rs = pstmt.executeQuery();
				
			if(rs.next()) {
				dto = new GuestDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
			}	
				
				rs.close();
				pstmt.close();
				
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		
			return dto;
			
			
		}
	
	
	

}
