package com.demo.service;

import com.demo.model.User;

public interface UserService {
	User validate(String uname, String pass);
}
