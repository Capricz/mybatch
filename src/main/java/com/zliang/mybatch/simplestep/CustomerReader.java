package com.zliang.mybatch.simplestep;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zliang.mybatch.model.Customer;

public class CustomerReader implements ItemReader<List<Customer>> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		return jdbcTemplate.queryForList("from Customer", Customer.class);
	}

}
