package com.zliang.mybatch.simplestep;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zliang.mybatch.model.Customer;

public class CustomerWriter implements ItemWriter<Customer> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void write(List<? extends Customer> customerList) throws Exception {
		for (Customer customer : customerList) {
			jdbcTemplate.update(" insert into customer_a values(?,?,?)",new Object[]{customer.getId(),customer.getName(),customer.getCredit()});
		}
	}

}
