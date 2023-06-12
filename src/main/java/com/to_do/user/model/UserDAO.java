package com.to_do.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;



public class UserDAO {
	
	private static UserDAO instance = new UserDAO();
	
	private UserDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSP1";
	private String upw = "JSP1";
	
	public int idCheck(String id) {//아이디 중복확인 메서드
		int result = 1;			
		String sql = "SELECT * FROM USERS WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn =DriverManager.getConnection(url,uid,upw);
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {//중복 o
				result = 1;				
			}else {//중복 x
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public void join(UserVO vo) { //회원가입 메서드
		String sql = "INSERT INTO USERS(ID,PW,NAME,PHONENUMBER,BIRTHDATE,EMAIL) VALUES(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhoneNumber());
			pstmt.setTimestamp(5, vo.getBirthdate());
			pstmt.setString(6, vo.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
	}


	public UserVO login(String id, String pw) {//로그인 기능 메서드
		UserVO vo = null;
		String sql = "SELECT * FROM USERS WHERE ID = ? AND PW = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,upw,uid);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String id2 = rs.getString("ID");
				String name = rs.getString("NAME");
				String phoneNumber = rs.getString("PHONENUMBER");
				Timestamp birthdate = rs.getTimestamp("BIRTHDATE");
				String email = rs.getString("EMAIL");
				
				vo = new UserVO(id2,null,name,phoneNumber,birthdate,email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return vo;
	}

	public UserVO getInfo(String id) {//로그인한 아이디 기반으로 정보를 가져오는 메서드
		UserVO vo = null;
		
		String sql = "SELECT * FROM USERS WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id2 = rs.getString("ID");
				String name = rs.getString("NAME");
				String phoneNumber = rs.getString("PHONENUMBER");
				Timestamp birthdate = rs.getTimestamp("birthdate");
				String email = rs.getString("EMAIL");
				
				vo = new UserVO(id2,null,name,phoneNumber,birthdate,email);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return vo;
	}

	public int updateInfo(UserVO vo) { //회원정보 수정 메서드
		int result = 0;
		String sql = "UPDATE USERS SET PW =?,NAME = ?,PHONENUMBER = ?, BIRTHDATE = ?, EMAIL = ? WHERE ID = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPhoneNumber());
			pstmt.setTimestamp(4, vo.getBirthdate());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteInfo(String id) {
		int result = 0;
		String sql = "DELETE FROM USERS WHERE ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return result;
	}
}
