package com.demo.service;

import java.util.List;
import com.demo.model.Employee;

public interface EmpService {
	
	List<Employee> getAllEmployees();
	
	void deleteEmployee(int id);

}
