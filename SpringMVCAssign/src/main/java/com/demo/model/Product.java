package com.demo.model;

public class Product {
	private int pid;
	private String pname;
	private double price;
	private int qty;
	public Product() {
		super();
	}
	public Product(int pid, String pname, double price, int qty) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.qty = qty;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Product [ID=" + pid + ", Name=" + pname + ", Price=" + price + ", Qty=" + qty + "]";
	}
}
