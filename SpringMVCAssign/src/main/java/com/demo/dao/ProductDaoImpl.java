package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private JdbcTemplate jdbcTemp;
	
	public int save(Product p) {
		return jdbcTemp.update("insert into prodTab values(?,?,?,?)", new Object[] {p.getPid(), p.getPname(), p.getPrice(), p.getQty()});
	}

	public List<Product> getAll() {
		List<Product> plist = jdbcTemp.query("select * from prodTab", new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int num) throws SQLException {
				Product p = new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setQty(rs.getInt(4));
				return p;
			}
		});
		return plist;
	}

	public int deleteById(int pid) {
		return jdbcTemp.update("delete from prodTab where id=?", new Object[] {pid});
	}

	public int updateById(Product p) {
		return jdbcTemp.update("update prodTab set name=?, price=?, qty=? where id=?", new Object[] {p.getPname(), p.getPrice(), p.getQty(), p.getPid()});
	}

	public Product getById(int pid) {
	    RowMapper<Product> productRowMapper = new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("qty"));
			}
		};
	    return jdbcTemp.queryForObject("SELECT * FROM prodTab WHERE id=?", productRowMapper, pid);
	}
	
}
