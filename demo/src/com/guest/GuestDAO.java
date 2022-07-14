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
			
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getContent());
			//pstmt.setString(3,"sysdate");
			
		
			result = pstmt.executeUpdate();
			
		
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	
		return result;
		
		
	}
	//아이디조회
	
	public GuestDTO getLists(String id, String pw) {
		
		GuestDTO dto = null;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql="select id, pwd,name from guestCustom1 where id=? and pwd=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery(); 
			
			if (rs.next()) {
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
		
	//입력한 아이디만 조회하기
		public GuestDTO getList(GuestDTO dto1) {
			
			GuestDTO dto2 = null;
			
			Connection conn = DBConn.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;
			
			try {
				
				sql="select id, content,created from guestRecord1 where id=?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,dto1.getId());
		
				
				rs = pstmt.executeQuery(); 
				
				if (rs.next()) {
					dto2 = new GuestDTO();
					dto2.setId(rs.getString("id"));
					dto2.setContent(rs.getString("content"));
					dto2.setCreated(rs.getString("created"));
				}
				
				rs.close();
				pstmt.close();
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return dto2;
		
	
	

}
	//아이디 조회 후에 전체 조회하기
		
	public List<GuestDTO> getList3(GuestDTO dto){
		
		List<GuestDTO> lists = new ArrayList<GuestDTO>();
		Connection conn = DBConn.getConnection();
		String sql=null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			
			sql="select id,content,created from guestRecord1";
			
			pstmt = conn.prepareStatement(sql);
		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				GuestDTO dto1 = new GuestDTO(); 
				
				dto1.setId(rs.getString("id")); 
				dto1.setContent(rs.getString("content")); 
				dto1.setCreated(rs.getString("created"));
				
				lists.add(dto1);
				
			}
			
			pstmt.close();
			rs.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
		
		
		
		
	}
		
		
		
		
		
	//수정
	public int updateData(GuestDTO dto) {
	int result = 0;
	
	Connection conn = DBConn.getConnection();
	PreparedStatement pstmt = null;
	String sql;
	
	try {
		
		sql = "update guestRecord1 set content=?,created=sysdate ";
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
	
}
