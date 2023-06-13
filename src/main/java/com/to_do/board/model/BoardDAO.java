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


	private String url = "jdbc:oracle:thin:@172.30.1.22:1521:xe";
	private String uid = "JSP1";
	private String upw = "JSP1";



	// 할일 작성
	public void write(String id, String title, String content, Timestamp regdate){

		String sql = "INSERT INTO board (BNO, user_id, title, content, regdate)\n" +
					 "VALUES (board_seq.nextval, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setTimestamp(4, regdate);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	} // write 끝

	// 수정
	public void update(int bno, String title, String content, Timestamp regdate){

		String sql = "UPDATE board SET title = ?, content = ?, regdate = ? WHERE bno = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setTimestamp(3, regdate);
			pstmt.setString(4, String.valueOf(bno));

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	} // update 끝

	// 삭제
	public void delete(int bno){
		String sql = "DELETE FROM board WHERE bno = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(bno));

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 임시 컨텐츠 가져오기
	public BoardVO getContent(String bno){
		BoardVO vo = null;

		String sql = "SELECT * FROM board WHERE bno = ?"; // 할 일 목록

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);

			rs = pstmt.executeQuery();

			if(rs.next()){
				int bno2 = rs.getInt("bno");
				String user_id = rs.getString("user_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String check_yn = rs.getString("check_yn");
				Timestamp regdate = rs.getTimestamp("regdate");

				vo = new BoardVO(bno2, user_id, title, content, check_yn, regdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return vo;
	}

	//할일 목록 조회
	public List<BoardVO> getList(String id){

		List<BoardVO> list = new ArrayList<>();

		String sql = "SELECT * FROM board\n" +
				     "WHERE TO_DATE(regdate, 'yyyy-MM-dd') >= TO_DATE(SYSDATE, 'yyyy-MM-dd') \n" +
				     "AND check_yn = 'N' AND user_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				int bno = rs.getInt("bno");
				String user_id = rs.getString("user_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String check_yn = rs.getString("check_yn");
				Timestamp regdate = rs.getTimestamp("regdate");

				BoardVO vo = new BoardVO(bno, user_id, title, content, check_yn, regdate);

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}

		return list;
	} // getList 끝

	// 마감기한 지난 일 조회
	public List<BoardVO> getOverList(String id){

		List<BoardVO> list = new ArrayList<>();

		String sql = "SELECT * FROM board\n" +
					 "WHERE TO_DATE(regdate, 'yyyy-MM-dd') < TO_DATE(SYSDATE, 'yyyy-MM-dd') \n" +
					 "AND check_yn = 'N' AND user_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				int bno = rs.getInt("bno");
				String user_id = rs.getString("user_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String check_yn = rs.getString("check_yn");
				Timestamp regdate = rs.getTimestamp("regdate");

				BoardVO vo = new BoardVO(bno, user_id, title, content, check_yn, regdate);

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}

		return list;
	} // OverList 끝


	// 아직 하지 않은 일 개수
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
	// 완료한 일 개수
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
