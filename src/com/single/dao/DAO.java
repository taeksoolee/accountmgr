package com.single.dao;

import java.util.List;

public interface DAO {
	public abstract int insert(Object obj);
	public abstract int update(Object obj);
	public abstract int delete(String str);
	public abstract Object select(String str, int option);
	public abstract List selectAll();
}
