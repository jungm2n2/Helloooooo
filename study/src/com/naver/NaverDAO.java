package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class NaverDAO {
	
	private Connection conn;
	
	public NaverDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	//입력(write.jsp->write_ok.jsp)
	public int insertData(NaverDTO dto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into naver(id,pw,name,yearSel,monthSel,daySel,genSel,email,numSel,putPhoneNum) ";
			sql+= "values(?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getYearSel());
			pstmt.setInt(5, dto.getMonthSel());
			pstmt.setInt(6, dto.getDaySel());
			pstmt.setString(7, dto.getGenSel());
			pstmt.setString(8, dto.getEmail());
			pstmt.setString(9, dto.getNumSel());
			pstmt.setInt(10, dto.getPutPhoneNum());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
//----------------------------------	
	
	//전체 데이터(list.jsp)
	
	
	public List<NaverDTO> getLists(){
		
		List<NaverDTO> lists = new ArrayList<NaverDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			
			sql = "select id,pw,name,yearSel,monthSel,daySel,genSel,email,numSel,putPhoneNum ";
			sql += "from naver";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				NaverDTO dto = new NaverDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setYearSel(rs.getInt("yearSel"));
				dto.setMonthSel(rs.getInt("monthSel"));
				dto.setDaySel(rs.getInt("daySel"));
				dto.setGenSel(rs.getString("genSel"));
				dto.setEmail(rs.getString("email"));
				dto.setNumSel(rs.getString("numSel"));
				dto.setPutPhoneNum(rs.getInt("putPhoneNum"));
				
				lists.add(dto);
			}
			
			pstmt.close();
			rs.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
		
	}

	//수정할 데이터 가져오기(update.jsp)
	
	public NaverDTO getReadData(String id) {
		
		NaverDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select id,pw,name,yearSel,monthSel,daySel,genSel,email,numSel,putPhoneNum ";
			sql+= "from naver where id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				
				dto = new NaverDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setYearSel(rs.getInt("yearSel"));
				dto.setMonthSel(rs.getInt("monthSel"));
				dto.setDaySel(rs.getInt("daySel"));
				dto.setGenSel(rs.getString("genSel"));
				dto.setEmail(rs.getString("email"));	
				dto.setNumSel(rs.getString("numSel"));	
				dto.setPutPhoneNum(rs.getInt("putPhoneNum"));	
				}
			
			rs.close();
			pstmt.close();
			
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}
	
	//수정(update.jsp->update_ok.jsp)
	public int updateData(NaverDTO dto) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			
			sql = "update naver set pw=?,yearSel=?,monthSel=?,daySel=?,genSel=?,email=?,numSel=?,putPhoneNum=? ";
			sql+= "where id=?";

			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setInt(2, dto.getYearSel());
			pstmt.setInt(3, dto.getMonthSel());
			pstmt.setInt(4, dto.getDaySel());
			pstmt.setString(5,dto.getGenSel());
			pstmt.setString(6,dto.getEmail());	
			pstmt.setString(7,dto.getNumSel());	
			pstmt.setInt(8,dto.getPutPhoneNum());
			pstmt.setString(9, dto.getId());
			
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	//삭제(delete_ok.jsp)
	public int deleteData(String id) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "delete naver where id=?";
				
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}


