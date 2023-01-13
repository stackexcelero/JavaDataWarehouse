package com.stackexelero.StateProperty.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.stackexelero.StateProperty.model.Application;
import com.stackexelero.StateProperty.util.JPAUtility;

public class ApplicationDAO {

    public ApplicationDAO() {}
	
	public static void main(String[] args) {
		System.out.println("--START ApplicationDAO--");
		
		//Persist Example
		Application application = new Application();
		application.setApplicationType("maintenance");
		application.setDescription("example of a simple description xxxx yyyy");
		application.setStatus('O');
		application.setStartDate(Calendar.getInstance());
		application.setEndDate(Calendar.getInstance());
		ApplicationDAO applicationDao = new ApplicationDAO();
		applicationDao.persist(application);
		
		System.out.println("--END ApplicationDAO--");
		System.exit(0);
	}

	public void persist(Application application) {
		EntityManager em = JPAUtility.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(application);
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	public Application findById(String id) {
		EntityManager em = JPAUtility.getEntityManager();
		Application p = null;
		try {
			em.getTransaction().begin();
			p = em.find(Application.class, id);
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return p;
	}

	public void delete(Application application) {
		EntityManager em = JPAUtility.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(application);
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	public List<Application> findAll() {
		EntityManager em = JPAUtility.getEntityManager();
		List<Application> list = null;
		try {
		    CriteriaBuilder cb = em.getCriteriaBuilder();
		    CriteriaQuery<Application> cq = cb.createQuery(Application.class);
		    Root<Application> rootEntry = cq.from(Application.class);
		    CriteriaQuery<Application> all = cq.select(rootEntry);
		    TypedQuery<Application> allQuery = em.createQuery(all);
		    list = allQuery.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return list;
	}

	public void deleteAll() {
		EntityManager em = JPAUtility.getEntityManager();
		try {
		    em.getTransaction().begin();
		    Query q3 = em.createQuery("DELETE FROM application");
		    q3.executeUpdate();
		    em.getTransaction().commit();
		} catch (Exception e) {
		    e.printStackTrace();
		}finally {
			em.close();
		}
	}

}
