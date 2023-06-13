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
	
	private String url = "jdbc:oracle:thin:@172.30.1.22:1521:xe";
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

			// 아이디 검색 되면 결과 1
			if(rs.next()) {
				result = 1;
			// 아이디 검색 안 되면 결과 0
			}else {
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
	} // IDCHECK 끝

	//회원가입 메서드
	public void join(UserVO vo) { 
		String sql = "INSERT INTO USERS VALUES(?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhoneNumber());
			pstmt.setString(5, vo.getEmail());
			
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
		
	} // JOIN 끝

	//로그인 기능 메서드
	public UserVO login(String id, String pw) {
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
				String email = rs.getString("EMAIL");
				
				vo = new UserVO(id2,null,name,phoneNumber,email);
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
	} //login끝

	//id기반 정보 가져오은 메서드
	public UserVO getInfo(String id) {
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
				String email = rs.getString("EMAIL");
				
				vo = new UserVO(id2,null,name,phoneNumber,email);
				
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
	} // getInfo 끝
	
	// 회원 정보 수정
	public int updateInfo(UserVO vo) { 
		int result = 0;
		String sql = "UPDATE USERS SET PW =?,NAME = ?,PHONENUMBER = ?, EMAIL = ? WHERE ID = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPhoneNumber());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getId());
			
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
	} //updateInfo 끝

	// 회원 탈퇴
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
