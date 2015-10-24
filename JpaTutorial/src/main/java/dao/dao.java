package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Customer;

public class dao {

	final static Logger logger = LoggerFactory.getLogger(dao.class);

	public void add(EntityManager em, EntityTransaction et, Customer c) {
		logger.info("entered add");
		et.begin();
		em.persist(c);
		et.commit();
		logger.info("exited add");
	}

	public void delete(EntityManager em, EntityTransaction et, Customer c) {
		logger.info("entered delete");
		et.begin();
		Customer cs = em.find(Customer.class, c.getId());
		em.remove(cs);
		et.commit();
		logger.info("exited remove");
	}

	public Customer find(EntityManager em, EntityTransaction et, Customer c) {
		logger.info("entered find");
		et.begin();
		Customer cs = em.find(Customer.class, c.getId());
		et.commit();
		logger.info("exited find");
		return cs;
	}

	public List<Customer> findAll(EntityManager em, EntityTransaction et,
			String c) {
		logger.info("entered findall");
		et.begin();
		Query q = em.createQuery("select p from " + c + " p");
		List<Customer> cs = q.getResultList();
		et.commit();
		logger.info("exited findall");
		return cs;
	}

	public void edit(EntityManager em, EntityTransaction et, int pk, Customer c) {
		logger.info("entered edit");
		et.begin();
		Customer q = em.find(Customer.class, pk);
		q.setName(c.getName());
		q.setSurname(c.getSurname());
		em.merge(q);
		et.commit();
		logger.info("exited edit");
	}

}
