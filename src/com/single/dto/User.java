package com.single.dto;
// 아이디(PK) VARCHAR(10), 암호 VARCHAR(12), 사용자명 VARCHAR(25), 생년월일 DATE, 전화번호 VARCHAR(20), 힌트 VARCHAR(50)
public class User {
	public static int MODE_NOMAL = 1;
	public static int MODE_HUMAN = -1;
	public static int MODE_DEL = -2;
	public static int MODE_ADMINISTRATOR = 0;
	private String id;
	private String password;
	private String userName;
	private String birthday;
	private String tel;
	private String hintStr;
	private int status; 
//constructor
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String id, String password, String userName, String birthday, String tel, String hintStr) {
		super();
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.birthday = birthday;
		this.tel = tel;
		this.hintStr = hintStr;
		this.status = MODE_NOMAL;
	}
//set & get
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHintStr() {
		return hintStr;
	}
	public void setHintStr(String hintStr) {
		this.hintStr = hintStr;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}