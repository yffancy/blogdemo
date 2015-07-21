package com.yff.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yff.dao.UserDao;
import com.yff.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService {
    
	@Resource(name="userDao")
	private UserDao userDao;

	@Override
	public User getUser(String id) {
		return userDao.getUser(id);
	}
	
	@Override
	public User getUserByUserName(String username) {
		return userDao.getUserByUserName(username);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public boolean delUser(String id) {
		
		return userDao.delUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

}
