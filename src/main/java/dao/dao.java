package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Customer;

public class dao {

	public void add(EntityManager em,EntityTransaction et,Customer c) {
		et.begin();
		em.persist(c);
		et.commit();
	}
	public void delete(EntityManager em,EntityTransaction et,Customer c) {
		et.begin();
		Customer cs=em.find(Customer.class, c.getId());
		em.remove(cs);
		et.commit();
	}
	public Customer find(EntityManager em,EntityTransaction et,Customer c) {
		et.begin();
		Customer cs=em.find(Customer.class, c.getId());
		et.commit();
		return cs;
	}
	public List<Customer> findAll(EntityManager em,EntityTransaction et,String c) {
		et.begin();
		Query q=em.createQuery("select p from "+c+" p" );
		List<Customer> cs=q.getResultList();
		et.commit();
		return cs;
	}
	public void edit(EntityManager em,EntityTransaction et,int pk,Customer c) {
		et.begin();
		Customer q=em.find(Customer.class,pk);
		q.setName(c.getName());q.setSurname(c.getSurname());
		em.merge(q);
		et.commit();
	}
	
}
