package com.single.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/** [className, url, user, password] �ʵ� �� ����� ���� ����*/
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
	
	/** load > connection��ü���� > statements��ü���� */
	private void connection() {
		setField(); // ����
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** SQL����� ���޹޾� DBMS�� ���� �� �ش� �غ�� ���ڰ�ü�� ��ȯ */
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
	/**className Field ������ */
	protected abstract void setClassName();
	/**url Field ������ */
	protected abstract void setURL();
	/**user Field ������ */
	protected abstract void setUser();
	/**password Field ������ */
	protected abstract void setPassword();
}