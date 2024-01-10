package com.demo.service;

import java.util.List;

import com.demo.dao.EmpDaoImpl;
import com.demo.model.Employee;
import com.demo.dao.EmpDao;

public class EmpServiceImpl implements EmpService{

	private EmpDao dao;
	public EmpServiceImpl() {
		dao =new EmpDaoImpl();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> elist= dao.getAllEmp();
		if(elist!= null) {
			return elist;
		}
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
	}

}
