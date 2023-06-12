package com.to_do.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "JSP1";
	private String upw = "JSP1";
	
	public List<BoardVO> getList(String id){
		List<BoardVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM BOARD WHERE USER_ID = ? ORDER BY BNO DESC";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int bno = rs.getInt("BNO");
				String user_Id = rs.getString("USER_ID");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String check_yn = rs.getString("CHECK_YN");
				Timestamp regdate = rs.getTimestamp("REGDATE");
				
				BoardVO vo = new BoardVO(bno,user_Id,title,content,check_yn,regdate);
				list.add(vo);
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
		return list;

	}
	
	public int getCount(String id){
		int count = 0;
		
		String sql = "SELECT COUNT(*) AS TOTAL FROM BOARD WHERE USER_ID = ? AND CHECK_YN = 'N'";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("TOTAL");
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
		return count;
	}
	
	public int getCount1(String id) {
		int count = 0;
		
		String sql = "SELECT COUNT(*) AS TOTAL FROM BOARD WHERE USER_ID = ? AND CHECK_YN = 'Y'";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,uid,upw);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("TOTAL");
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
		return count;
	}
}
