package com.single.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/** [className, url, user, password] 필드 를 상속을 통해 세팅*/
public abstract class Conn {
	private Connection conn = null;
	
	protected String className = "";
	protected String url = "";
	protected String user = "";
	protected String password = "";
	
	protected Conn() {
		// TODO Auto-generated constructor stub
	}
	
	private void setField() {
		setClassName();
		setURL();
		setUser();
		setPassword();
	}
	
	/** load > connection객체생성 > statements객체생성 */
	private void connection() {
		setField(); // 세팅
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** SQL명령을 전달받아 DBMS에 전달 후 해당 준비된 문자객체를 반환 */
	public PreparedStatement selectState(String sql) {
		PreparedStatement pst = null;
		try {
			connection();
			pst = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pst;
	}
	
	/** close all*/
	public void close(PreparedStatement pst, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(pst != null) pst.close();
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void close(PreparedStatement pst) {
		try {
			if(pst != null) pst.close();
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/** close only connection*/
	public void close() {
		try {
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
// set & get
	/**className Field 재정의 */
	protected abstract void setClassName();
	/**url Field 재정의 */
	protected abstract void setURL();
	/**user Field 재정의 */
	protected abstract void setUser();
	/**password Field 재정의 */
	protected abstract void setPassword();
}