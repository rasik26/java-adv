package com.demo.beans;

public class Product {
	private int pid;
	private String desc; 
	public Product() {
		super();
	}
	public Product(int p_id, String description) {
		this.pid = p_id;
		this.desc = description;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Product [Product ID = "+this.pid+", Description = "+this.desc+"]";
	}
}
