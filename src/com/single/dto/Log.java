package com.single.dto;

import java.util.Date;

//번호(PK) NUMBER, 계좌별칭(FK, account.alias) VARCHAR(20), 입금 NUMBER, 출금 NUMBER, 날짜 DATE, 거래상대(FK, opponent.name) VARCHAR(30), 메모 VARCHAR(500);
public class Log {
	int no;
	String acAlias;
	int acOutput;
	int acInput;
	Date date;
	String opponent;
	String note;
	
	public Log() {
		// TODO Auto-generated constructor stub
	}

	public Log(int no, String acAlias, int acOutput, int acInput, Date date, String opponent, String note) {
		super();
		this.no = no;
		this.acAlias = acAlias;
		this.acOutput = acOutput;
		this.acInput = acInput;
		this.date = date;
		this.opponent = opponent;
		this.note = note;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getAlias() {
		return acAlias;
	}
	public void setAlias(String acAlias) {
		this.acAlias = acAlias;
	}
	public int getAcOutput() {
		return acOutput;
	}
	public void setAcOutput(int acOutput) {
		this.acOutput = acOutput;
	}
	public int getAcInput() {
		return acInput;
	}
	public void setAcInput(int acInput) {
		this.acInput = acInput;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOpponent() {
		return opponent;
	}
	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}