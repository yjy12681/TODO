package com.to_do.board.model;

import java.sql.Timestamp;

public class BoardVO {
	private int bno;
	private String user_Id;
	private String title;
	private String content;
	private String check_yn;
	private Timestamp regdate;
	private int nTotal;
	
	
	public BoardVO() {
		
	}

	public BoardVO(int bno, String user_Id, String title, String content, String check_yn, Timestamp regdate) {
		super();
		this.bno = bno;
		this.user_Id = user_Id;
		this.title = title;
		this.content = content;
		this.check_yn = check_yn;
		this.regdate = regdate;
	}
	
	

	public BoardVO(int bno, String user_Id, String title, String content, String check_yn, Timestamp regdate,
			int nTotal) {
		super();
		this.bno = bno;
		this.user_Id = user_Id;
		this.title = title;
		this.content = content;
		this.check_yn = check_yn;
		this.regdate = regdate;
		this.nTotal = nTotal;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCheck_yn() {
		return check_yn;
	}

	public void setCheck_yn(String check_yn) {
		this.check_yn = check_yn;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getnTotal() {
		return nTotal;
	}

	public void setnTotal(int nTotal) {
		this.nTotal = nTotal;
	}

	
	
	
	
	
	
}
