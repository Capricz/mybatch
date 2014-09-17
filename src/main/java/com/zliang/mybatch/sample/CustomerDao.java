package com.zliang.mybatch.sample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.zliang.mybatch.model.Customer;

@Repository
public class CustomerDao {
	
	@PersistenceContext(name="myPersistenceUnit")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Customer> findAll(){
		return em.createQuery("from Customer").getResultList();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
		CustomerDao dao = ctx.getBean(CustomerDao.class);
		List<Customer> list = dao.findAll();
		System.out.println(list.size());
	}
}
