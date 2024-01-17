package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.User;

@Repository
public class UserLoginDaoImpl implements UserLoginDao{
	@Autowired
	private JdbcTemplate jdbcTemp;

	public User checkUser(String uname, String pass) {
		try {
			String query="select * from user where uname=? and pass=?";
			User u = jdbcTemp.queryForObject(query, new Object[] {uname, pass}, BeanPropertyRowMapper.newInstance(User.class));
			return u;
		}catch(EmptyResultDataAccessException e) {
			System.out.println("Error : "+e.getMessage());
		}
		return null;
	}

}
