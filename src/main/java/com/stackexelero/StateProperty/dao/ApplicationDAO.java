package com.stackexelero.StateProperty.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stackexelero.StateProperty.model.Application;
import com.stackexelero.StateProperty.util.JPAUtility;

public class ApplicationDAO {

    public ApplicationDAO() {}
	
	public static void main(String[] args) {
		System.out.println("--START ApplicationDAO--");
		
		//Persist Example
		//saveTest();
		//findByIdTest();
		//findAllTest();
		//deleteTest();
		//System.out.println(new ApplicationDAO().entityExistsById(2));
		//new ApplicationDAO().deleteAll();
		
		System.out.println("--END ApplicationDAO--");
		System.exit(0);
	}

/*
	private static void saveTest() {
		Application application = new Application();
		application.setApplicationType("maintanance");
		application.setDescription("simple description xxxx yyyy");
		application.setStatus('O');
		application.setStartDate(Calendar.getInstance());
		application.setEndDate(Calendar.getInstance());
		ApplicationDAO applicationDao = new ApplicationDAO();
		applicationDao.save(application);
	}
	private static void findByIdTest() {
		ApplicationDAO applicationDao = new ApplicationDAO();
		Application application = applicationDao.findById(2);
		System.out.println(application.toString());
	}
	private static void findAllTest() {
		ApplicationDAO applicationDao = new ApplicationDAO();
		List<Application> list = applicationDao.findAll();
		list.forEach(e -> System.out.println(e.toString()));
	}
	private static void deleteTest() {
		ApplicationDAO applicationDao = new ApplicationDAO();
		Application application = applicationDao.findById(2);
		applicationDao.delete(application);
	}*/

	public void save(Application application) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		try {
			s.beginTransaction();
			s.save(application);
			s.getTransaction().commit();
		}catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
	}
	

	public Application findById(int id) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		Application p = null;
		try {
			p = s.byId(Application.class).getReference(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return p;
	}

	public void delete(Application application) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		try {
			s.getTransaction().begin();
			s.remove(application);
			s.getTransaction().commit();
		}catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
	}

	public List<Application> findAll() {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		List<Application> list = null;
		try {
		    CriteriaBuilder cb = s.getCriteriaBuilder();
		    CriteriaQuery<Application> cq = cb.createQuery(Application.class);
		    Root<Application> rootEntry = cq.from(Application.class);
		    CriteriaQuery<Application> all = cq.select(rootEntry);
		    TypedQuery<Application> allQuery = s.createQuery(all);
		    list = allQuery.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return list;
	}
	
	public boolean entityExistsById(int id) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		boolean result = false;
		
		try {
			if(s.get(Application.class, id) != null) {
				result = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return result;
	}

	public void deleteAll() {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		try {
		    s.getTransaction().begin();
		    Query q3 = s.createQuery("DELETE FROM Application");
		    q3.executeUpdate();
		    s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
		    e.printStackTrace();
		}finally {
			s.close();
		}
	}
	
	public Application merge(Application application) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		
		try {
			s.beginTransaction();
			s.merge(application);
			s.getTransaction().commit();
		}catch(Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return application;
	}

}
