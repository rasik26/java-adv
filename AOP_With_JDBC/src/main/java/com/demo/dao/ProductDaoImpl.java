package com.demo.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private JdbcTemplate jdbcT;
	
	public int save(Product p) {
		return jdbcT.update("insert into prodTab values(?,?,?,?)", new Object[] {p.getPid(), p.getPname(), p.getPrice(), p.getQty()});
	}

	public List<Product> getAll() {
		List<Product> p_list = jdbcT.query("select * from prodTab", new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int num) throws SQLException {
				Product p = new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setQty(rs.getInt(4));
				return p;
			}
		});
		return p_list;
	}
	public Product findById(int pid) {
		return jdbcT.queryForObject("select * from prodTab where id=?",new Object[] {pid},BeanPropertyRowMapper.newInstance(Product.class));
	}
	
	public int deletById(int pid) {
		return jdbcT.update("delete from prodTab where id=?", new Object[] {pid});
	}

	public int updateById(int pid, int qty) {
		return jdbcT.update("update prodTab set qty=? where id=?", new Object[] {qty, pid});
	}
	
}
