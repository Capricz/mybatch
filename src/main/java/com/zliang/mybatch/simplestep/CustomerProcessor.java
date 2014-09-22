package com.zliang.mybatch.simplestep;

import org.springframework.batch.item.ItemProcessor;

import com.zliang.mybatch.model.Customer;
import com.zliang.mybatch.model.CustomerA;

public class CustomerProcessor implements ItemProcessor<Customer,CustomerA> {

	@Override
	public CustomerA process(Customer cust) throws Exception {
		System.out.println("In CustomerProcessor process(Customer customer)...");
//		List<CustomerA> result = new ArrayList<CustomerA>();
//		for (Customer cust : customers) {
			CustomerA res = new CustomerA(); 
			res.setId(cust.getId());
			res.setName(cust.getId()+"##"+cust.getName());
			res.setCredit(cust.getCredit());
//			result.add(res);
//		}
		return res;
	}

}
