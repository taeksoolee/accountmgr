package com.single.dto;
// 순번(PK) NUMBER, 아이디(FK, user.id) VARCHAR(15), 계좌번호 VARCHAR(30), 잔액 NUMBER, 은행 VARCHAR(15), 별칭(UNIQE) VARCHAR(20)
public class Account {
	private int pk;
	private String id;
	private String accountNumber;
	private String balance;
	private String bank;
	private String alias;
// 기본 생성자로 생성불가
	private Account() {}

	public Account(int pk, String user, String accountNumber, String balance, String bank, String alias) {
		super();
		this.pk = pk;
		this.id = user;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.bank = bank;
		this.alias = alias;
	}
//get & set
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
}