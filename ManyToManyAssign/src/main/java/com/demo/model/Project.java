package com.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table(name="ProjectTab")
public class Project {
	@Id
	private int pid;
	private String Pname;
	@ManyToMany(mappedBy="pset")
	Set<Employee> eset;
	public Project() {
		super();
	}
	public Project(int pid, String pname, Set<Employee> eset) {
		super();
		this.pid = pid;
		Pname = pname;
		this.eset = eset;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public Set<Employee> getEset() {
		return eset;
	}
	public void setEset(Set<Employee> eset) {
		this.eset = eset;
	}
	@Override
	public String toString() {
		return "Project [pid=" + pid + ", Pname=" + Pname + "]";
	}
	
	
}
