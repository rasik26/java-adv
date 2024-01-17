package com.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeTab76")
public class Employee {
	@Id
	private int empid;
	private String ename;
	private double sal;
	@ManyToMany
	@JoinTable(name="emp_proj11",joinColumns= {@JoinColumn(name="empid")},
	inverseJoinColumns= {@JoinColumn(name="pid")})
	Set<Project> pset;
	public Employee() {
		super();
	}
	public Employee(int empid, String ename, double sal, Set<Project> pset) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.sal = sal;
		this.pset = pset;
	}
	public Employee(int empid, String ename, double sal) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.sal = sal;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Set<Project> getPset() {
		return pset;
	}
	public void setPset(Set<Project> pset) {
		this.pset = pset;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", sal=" + sal + ", pset=" + pset + "]";
	}
	
	
}

