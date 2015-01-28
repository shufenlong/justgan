package com.quanfeng.service;

import java.util.List;

import com.quanfeng.entity.User;

public interface UserService {
	public void saveUser(User user);

	public void updateUser(User user);

	public User findUserById(int id);

	public void deleteUser(User user);

	public List<User> findAllList();

	public User findUserByNameAndPassword(String username, String password);
}
