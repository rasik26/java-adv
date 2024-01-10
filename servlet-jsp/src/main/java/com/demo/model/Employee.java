package com.demo.model;

public class Employee {
	
	private int eid;
	private String ename;
	private String ejob;
	
	public Employee() {
		super();
	}
	
	public Employee(int eid, String ename, String ejob) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.ejob = ejob;
	}
	
	public int getEid() {
		return eid;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getEjob() {
		return ejob;
	}
	
	public void setEjob(String ejob) {
		this.ejob = ejob;
	}

	@Override
	public String toString() {
		return "Emolyee [eid=" + eid + ", ename=" + ename + ", ejob=" + ejob + "]";
	}
	
}
