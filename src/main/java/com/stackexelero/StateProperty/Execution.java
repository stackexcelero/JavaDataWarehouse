package com.stackexelero.StateProperty;

import javax.persistence.EntityManager;

import com.stackexelero.StateProperty.util.JPAUtility;

public class Execution {

	public static void main(String[] args) {
		System.out.println("--Start--");
		
		EntityManager entity = JPAUtility.getEntityManager();
		entity.close();
		
		System.out.println("--END--");
		System.exit(0);
	}

}
