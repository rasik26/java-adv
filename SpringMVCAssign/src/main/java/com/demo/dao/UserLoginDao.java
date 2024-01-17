package com.demo.dao;
import com.demo.model.User;
public interface UserLoginDao {
	User checkUser(String uname, String pass);
}
