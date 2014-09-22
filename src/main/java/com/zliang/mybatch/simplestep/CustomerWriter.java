package com.zliang.mybatch.simplestep;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.batch.item.ItemWriter;

import com.zliang.mybatch.model.CustomerA;

public class CustomerWriter implements ItemWriter<CustomerA> {
	
	@PersistenceContext
	private EntityManager em;
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	@Override
	public void write(List<? extends CustomerA> customerList) throws Exception {
		System.out.println("In CustomerWriter.write(List<? extends Customer> customerList)...");
		int sum = 0;
		for (CustomerA cust : customerList) {
			//jdbcTemplate.update(" insert into customer_a values(?,?,?)",new Object[]{customer.getId(),customer.getName(),customer.getCredit()});
			Query query = em.createQuery("insert into customer_a values(:id,:name,:credit)");
			query.setParameter("id",cust.getId());
			query.setParameter("name", cust.getName());
			query.setParameter("credit", cust.getCredit());
			
			int executeUpdate = query.executeUpdate();
			if(executeUpdate>0){sum++;}
		}
		System.out.println("executeUpdate count : "+sum);
	}

}
