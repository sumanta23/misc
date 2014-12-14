import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.dao;


import model.Customer;




public class Main {
	  private static final String PERSISTENCE_UNIT_NAME = "testjpa";
	  static EntityManagerFactory factory= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	  static EntityManager em=factory.createEntityManager();
	  
	  public static void main(String[] args) {
	   try{
	    	EntityTransaction entr=em.getTransaction();
	    	dao d=new dao();
	    	
	    	d.add(em,entr,new Customer(3, "o", "u"));
	    	
	    	d.delete(em,entr,new Customer(3, "o", "u"));
	    	
	    	Customer c=d.find(em, entr,new Customer(2, "o", "u") );
	    	System.out.println(c.getId()+c.getName()+c.getSurname());
	    	
	    	d.edit(em, entr, 2, new Customer(2, "i", "l"));
	    	
	    	List<Customer> results=d.findAll(em, entr, "Customer");
	    	if(results.size()!=0){
		    	Iterator stIterator=results.iterator();
		    	while(stIterator.hasNext()){
		    	Customer st=(Customer)stIterator.next();
		    	System.out.print("id:"+st.getId());
		    	System.out.print(" name:"+st.getName());
		    	System.out.print(" surname:"+st.getSurname());
		    	System.out.println();
		    	}
		    	}
	    	
	    	}
	    	finally{
	    	em.close();
	    	}
	    	}
	    	}