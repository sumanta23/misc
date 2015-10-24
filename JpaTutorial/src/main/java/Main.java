import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.dao;

import model.Customer;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "testjpa";
	static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	static EntityManager em = factory.createEntityManager();

	final static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		logger.info("Entering to main");
		try {
			EntityTransaction entr = em.getTransaction();
			dao d = new dao();

			d.add(em, entr, new Customer(2, "o", "i"));
			d.add(em, entr, new Customer(3, "o", "u"));
			logger.info("two entries added");
			d.delete(em, entr, new Customer(3, "o", "u"));
			logger.info("one entry deleted");
			Customer c = d.find(em, entr, new Customer(2, "o", "u"));
			System.out.println(c.getId() + c.getName() + c.getSurname());

			d.edit(em, entr, 2, new Customer(2, "i", "l"));
			logger.info("one entry edited");
			List<Customer> results = d.findAll(em, entr, "Customer");
			if (results.size() != 0) {
				Iterator stIterator = results.iterator();
				while (stIterator.hasNext()) {
					Customer st = (Customer) stIterator.next();
					System.out.print("id:" + st.getId());
					System.out.print(" name:" + st.getName());
					System.out.print(" surname:" + st.getSurname());
					System.out.println();
				}
			}
			d.delete(em, entr, new Customer(2, "i", "l"));
			logger.info("one entry removed");
		} catch (Exception e) {
			logger.warn(e.getMessage());
		} finally {
			em.close();
			factory.close();
			logger.info("exiting from main");
		}
	}
}