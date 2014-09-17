package com.zliang.mybatch.simplestep;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

import com.zliang.mybatch.model.Customer;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {

	@Override
	public Customer process(Customer customer) throws Exception {
		Customer result = new Customer(); 
		result.setId(customer.getId());
		result.setName(customer.getId()+"##"+customer.getName());
		result.setCredit(customer.getCredit());
		return result;
	}

}
