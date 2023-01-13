package com.stackexelero.StateProperty.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class JPAUtility {
	//private final String pathToPersistenceXml = "./resources/META-INF/persistence.xml";
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ETLDB");
	

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	public static void close() {
		emf.close();
	}
}
