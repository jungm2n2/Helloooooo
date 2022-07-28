package com.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MemberDAO {
	
	private Connection conn;
	
	
	public MemberDAO(Connection conn) {
		
		this.conn = conn;
		
	}

	//ȸ������
	
	public void insertData(MemberDTO dto) {
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into member (userId,userPwd,userName,";
			sql+= "userBirth,userTel) values (?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPwd());
			pstmt.setString(3, dto.getUserName());
			pstmt.setString(4, dto.getUserBirth());
			pstmt.setString(5, dto.getUserTel());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	//������ �о����
	public MemberDTO getReadData(String userId) {
		
		MemberDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select userID,userPwd,userName,to_char(userBirth,'YYYY-MM-DD') userBirth,";
			sql+= "userTel from member where userId=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new MemberDTO();
				
				dto.setUserId(rs.getString("userId"));
				dto.setUserPwd(rs.getString("userPwd"));
				dto.setUserName(rs.getString("userName"));
				dto.setUserBirth(rs.getString("userBirth"));
				dto.setUserTel(rs.getString("userTel"));
				
			}
			
			rs.close();
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
		
		
	}
	//����
	
	public int updateData(MemberDTO dto) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			
				sql = "update member set userPwd=?,userBirth=?,userTel=? where userId=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getUserPwd());
				pstmt.setString(2, dto.getUserBirth());
				pstmt.setString(3, dto.getUserTel());
				pstmt.setString(4, dto.getUserId());
				
				
				result = pstmt.executeUpdate();
				pstmt.close();
					
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return result;
			
		}
		

	
	
	
	
	
	

}
