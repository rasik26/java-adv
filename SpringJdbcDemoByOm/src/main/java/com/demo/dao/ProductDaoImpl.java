package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.model.Product11;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int save(Product11 p) {
		return jdbcTemplate.update("insert into product11 values(?,?,?,?)", new Object[] {
				p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
		
		
	}

	@Override
	public List<Product11> findAll() {
		List<Product11> lst=jdbcTemplate.query("select * from product11",(rs,num)->{
			Product11 p=new Product11();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			return p;
		});
		return lst;
		/*jdbcTemplate.query("select * from product", new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int num) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
		})*/
	}

	@Override
	public Product11 findById(int pid) {
		return jdbcTemplate.queryForObject("select * from product11 where pid=?",new Object[] {pid},BeanPropertyRowMapper.newInstance(Product11.class));
	}

	@Override
	public List<Product11> findByQty(int qty) {
		return jdbcTemplate.query("select * from product11 where qty>? ",new Object[]{qty},(rs,num)->{
			Product11 p=new Product11();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(4));
			p.setPrice(rs.getDouble(3));
			return p;
		});
	}

	@Override
	public int deletById(int pid) {
		return jdbcTemplate.update("delete from product11 where pid=?",new Object[] {pid});
	}

	@Override
	public int updateById(int pid,int qty,double pr) {
		return jdbcTemplate.update("update product11 set qty=?,price=? where pid=?",new Object[] {qty,pr,pid});
	}

}