package com.zliang.mybatch.sample;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zliang.mybatch.model.Customer;

public class CustomerCreditRowMapper implements RowMapper {
	public static final String ID_COLUMN = "id";
	public static final String NAME_COLUMN = "name";
	public static final String CREDIT_COLUMN = "credit";

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt(ID_COLUMN));
		customer.setName(rs.getString(NAME_COLUMN));
		customer.setCredit(rs.getFloat(CREDIT_COLUMN));
		return customer;
	}
}