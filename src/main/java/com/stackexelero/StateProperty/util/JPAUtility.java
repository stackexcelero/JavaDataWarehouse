package com.stackexelero.StateProperty.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class JPAUtility {
	private static final EntityManager em;
	private static final SessionFactory sf;
	
	static {
		em = Persistence.createEntityManagerFactory("ETLDB").createEntityManager();
		sf = em.unwrap(Session.class).getSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}
//	private static void close() {
//		em.close();
//	}
}
