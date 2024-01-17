package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.dao.*;
import com.demo.model.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserLoginDao uldao;
	
	public User validate(String uname, String pass) {
		return uldao.checkUser(uname, pass);
	}

}
