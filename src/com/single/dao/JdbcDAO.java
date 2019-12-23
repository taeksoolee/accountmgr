package com.single.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public abstract class JdbcDAO{
	private static PoolDataSource _pds;
	
	static {
		try {
			_pds = PoolDataSourceFactory.getPoolDataSource();
			Properties p = new Properties();
			InputStream in = JdbcDAO.class.getResourceAsStream("conInfo.properties");
			try {
				p.load(in);
				String driver = (String) p.get("driver");
				System.out.println(driver);
				String url = (String) p.get("url");
				String user = (String) p.get("user");
				String password = (String) p.get("password");
				
				int initialCons = Integer.parseInt((String) p.get("initialCons"));
				int maxcon = Integer.parseInt((String) p.get("maxcon"));
				//String block = (String) p.get("block");
				//String timeout = (String) p.get("timeout");
				
				_pds.setConnectionFactoryClassName(driver);
				_pds.setURL(url);
				_pds.setUser(user);
				_pds.setPassword(password);
				
				_pds.setInitialPoolSize(initialCons);
				_pds.setMaxPoolSize(maxcon);
				_pds.getConnection().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
		}
	}
	
	protected Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = _pds.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
//
	protected void close(Connection conn) {
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void close(Connection conn, Statement st) {
		try {
			if(st != null) st.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(Connection conn, Statement st, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}