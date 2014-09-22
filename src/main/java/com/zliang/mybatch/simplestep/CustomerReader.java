package com.zliang.mybatch.simplestep;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zliang.mybatch.model.Customer;

public class CustomerReader implements ItemReader<Customer> {
	
	@PersistenceContext
	private EntityManager em;
	
//	public JdbcTemplate jdbcTemplate;
//
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Override
	public Customer read() throws Exception, UnexpectedInputException,ParseException, NonTransientResourceException {
		System.out.println("In CustomerReader read()...");
//		CustomerRowMapper rowMapper;
//		return jdbcTemplate.query("select * from customer", new CustomerRowMapper());//("from Customer", Customer.class);
		Customer result = new Customer();
		List<Customer> cust = em.createQuery("from Customer").getResultList();
		if(!cust.isEmpty()){
			result = cust.get(0);
		}
		return result;
	}

}
