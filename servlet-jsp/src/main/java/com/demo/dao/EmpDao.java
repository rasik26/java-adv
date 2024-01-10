package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmpDao {
	List<Employee> getAllEmp();
	
	void deleteEmployee(int id);
}
