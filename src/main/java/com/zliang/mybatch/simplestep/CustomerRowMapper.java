package com.zliang.mybatch.simplestep;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zliang.mybatch.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowIndex) throws SQLException {
		Integer id = rs.getInt("ID");
		String name = rs.getString("NAME");
		float credit = rs.getFloat("CREDIT");
		
		Customer cust = new Customer();
		cust.setId(id);
		cust.setName(name);
		cust.setCredit(credit);
		return cust;
	}

}
