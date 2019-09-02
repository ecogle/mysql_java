package com.mysql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPATest {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-app");
	
	public static void main(String[] args) {
		
		EntityManager em = emf.createEntityManager();
		
		Todo t = new Todo();
		t.setDescription("hello world");
		t.setSummary("this is another summary");
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		
	}

}
