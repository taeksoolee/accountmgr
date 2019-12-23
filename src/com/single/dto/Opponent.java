package com.single.dto;
// 이름/별명(PK) VARCHAR(30), 은행 VARCHAR(15), 설명 Note(300) 
public class Opponent {
	private String name;
	private String bank;
	private String note;
	
	public Opponent() {
		// TODO Auto-generated constructor stub
	}

	public Opponent(String name, String bank, String note) {
		super();
		this.name = name;
		this.bank = bank;
		this.note = note;
	}
//
	public String getOpponentName() {
		return name;
	}
	public void setOpponentName(String name) {
		this.name = name;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
