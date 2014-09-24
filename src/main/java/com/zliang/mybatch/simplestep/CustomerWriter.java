package com.zliang.mybatch.simplestep;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.batch.item.ItemWriter;
import org.springframework.transaction.annotation.Transactional;

import com.zliang.mybatch.model.CustomerA;

public class CustomerWriter implements ItemWriter<CustomerA> {
	
	@PersistenceContext
	public EntityManager em;
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	
//	public EntityManager getEm() {
//		return em;
//	}
//
//	public void setEm(EntityManager em) {
//		this.em = em;
//	}

	@Override
	@Transactional
	public void write(List<? extends CustomerA> customerList) throws Exception {
		System.out.println("In CustomerWriter.write(List<? extends Customer> customerList)...");
		int sum = 0;
//		em.getTransaction().begin();
		CustomerA customerA = customerList.get(0);
		
		em.merge(customerA);
		/*for (CustomerA cust : customerList) {
//			em.persist(cust);
			em.merge(cust);
			//jdbcTemplate.update(" insert into customer_a values(?,?,?)",new Object[]{customer.getId(),customer.getName(),customer.getCredit()});
//			Query query = em.createNativeQuery("insert into customer_a values(:id,:name,:credit)");
//			query.setParameter("id",cust.getId());
//			query.setParameter("name", cust.getName());
//			query.setParameter("credit", cust.getCredit());
//			
//			int executeUpdate = query.executeUpdate();
//			if(executeUpdate>0){sum++;}
		}*/
//		em.getTransaction().commit();
		System.out.println("executeUpdate count : "+sum);
	}

}
