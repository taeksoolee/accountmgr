package com.single.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.single.dto.User;
import com.single.etc.Varidation;

// 싱글톤 디자인 패턴
public class UserDAO extends JdbcDAO implements DAO{
	public static final int OP_NAME = 1, OP_BIRTH = 2, OP_ID = 3, OP_HINT = 4;
	private static UserDAO _dao;
	
	private UserDAO (){}; // 생성자 은닉
	
	static {_dao = new UserDAO();}
	
	public static UserDAO getUserDAO() {
		return _dao;
	}
	@Override
	public int insert(Object obj) {
		if(obj instanceof User) {
			User user = (User)obj;
			
			Connection conn = _dao.getConnection();
			PreparedStatement pst = null;
			
			try {
				pst = conn.prepareStatement("INSERT INTO APP_USER VALUES(?,?,?,?,?,?,?)");
				pst.setString(1, user.getId());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getUserName());
				pst.setString(4, user.getBirthday());
				pst.setString(5, user.getTel());
				pst.setString(6, user.getHintStr());
				pst.setInt(7, user.getStatus());
				
				int rows = pst.executeUpdate();
				return rows;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(conn, pst);
			}
		}
		return -1;
	}
	@Override
	public int update(Object obj) {
		if(obj instanceof User) {
			User user = (User)obj;
			
			Connection conn = _dao.getConnection();
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement("UPDATE APP_USER SET id=?, password=?, username=?,birthday=?, tel=?, hint=?, status=?");
				pst.setString(1, user.getId());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getUserName());
				pst.setString(4, user.getTel());
				pst.setString(5, user.getBirthday());
				pst.setString(6, user.getHintStr());
				pst.setInt(7, user.getStatus());
				
				int rows = pst.executeUpdate();
				return rows;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  finally {
				close(conn, pst);
			}
		}
		return -1;
	}
		
	@Override
	public int delete(String id) {
		Connection conn = _dao.getConnection();
		PreparedStatement pst = null;
		int rows = 0;
		try {
			pst = conn.prepareStatement("DELETE FROM APP_USER WHERE id = ?");
			pst.setString(1, id);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, pst);
		}
		return rows;
	}
	
	@Override
	public Object select(String str, int option) {
		User user = new User();
		Connection conn = _dao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(selectSQL(option));
			switch(option) {
			case OP_ID:
				if(!Varidation.isIdStr(str)) return null;
				break;
			case OP_NAME:
				if(!Varidation.isNameStr(str)) return null;
				break;
			case OP_BIRTH:
				if(!Varidation.isBirthStr(str)) return null;
				break;
			case OP_HINT:
				if(!Varidation.isHintStr(str)) return null;
				break;
			}
			
			pst.setString(1, str);
			rs = pst.executeQuery(); // 에러??
			
			if(!rs.next()) return null;
			user.setId(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setUserName(rs.getString(3));
			user.setBirthday(rs.getString(4));
			user.setTel(rs.getString(5));
			user.setHintStr(rs.getString(6));
			user.setStatus(rs.getInt(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, pst, rs);
		}
		return user;
	}
	
	@Override
	public List<User> selectAll() {
		List<User> list = new ArrayList<User>();
		User user = null;
		Connection conn = _dao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM APP_USER");
			rs = pst.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setUserName(rs.getString(3));
				user.setTel(rs.getString(4));
				user.setBirthday(rs.getString(5));
				user.setHintStr(rs.getString(6));
				user.setStatus(rs.getInt(7));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, pst, rs);
		}
		return list;
	}
	
	public static void main(String[] args) {
		getUserDAO().insert(new User("a123456", "1234a!", "이택수", "1993-02-11", "010-9999-1234", "xxx"));
	}
	
	private static String selectSQL(int option) {
		String sql = "";
		switch(option) {
		case OP_NAME:
			sql = "SELECT * FROM APP_USER WHERE username = ?";
			break;
		case OP_BIRTH:
			sql = "SELECT * FROM APP_USER WHERE birth = ?";
			break;
		case OP_ID:
			sql = "SELECT * FROM APP_USER WHERE id = ?";
			break;
		case OP_HINT:
			sql = "SELECT * FROM APP_USER WHERE hint = ?";
			break;
		}
		return sql;
	}
}
