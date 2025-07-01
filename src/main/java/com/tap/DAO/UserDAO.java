package com.tap.DAO;

import java.util.List;

import com.tap.model.User;

public interface UserDAO {

	int insertUser(User u);
	List<User> getAllUsers();
	User getSpecificUser(int id);
	int updateUser(int id, String address);
	int deleteUser(int id);
}
