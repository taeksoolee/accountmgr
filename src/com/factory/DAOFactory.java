package com.factory;

import com.single.dao.LogDAO;
import com.single.dao.UserDAO;

public class DAOFactory {
	public static UserDAO getUserDAO(){
		UserDAO user = UserDAO.getUserDAO();
		return user;
	}
}
