package com.stackexelero.StateProperty.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stackexelero.StateProperty.model.Applicant;
import com.stackexelero.StateProperty.util.JPAUtility;

public class ApplicantDAO {
	
	
	public void save(Applicant applicant) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		try {
			s.beginTransaction();
			s.save(applicant);
			s.getTransaction().commit();
		}catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
	}
	

	public Applicant findById(int id) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		Applicant p = null;
		try {
			p = s.byId(Applicant.class).getReference(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return p;
	}

	public void delete(Applicant applicant) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		try {
			s.getTransaction().begin();
			s.remove(applicant);
			s.getTransaction().commit();
		}catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
	}

	public List<Applicant> findAll() {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		List<Applicant> list = null;
		try {
		    CriteriaBuilder cb = s.getCriteriaBuilder();
		    CriteriaQuery<Applicant> cq = cb.createQuery(Applicant.class);
		    Root<Applicant> rootEntry = cq.from(Applicant.class);
		    CriteriaQuery<Applicant> all = cq.select(rootEntry);
		    TypedQuery<Applicant> allQuery = s.createQuery(all);
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
			if(s.get(Applicant.class, id) != null) {
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
		    Query q3 = s.createQuery("DELETE FROM Applicant");
		    q3.executeUpdate();
		    s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
		    e.printStackTrace();
		}finally {
			s.close();
		}
	}
	
	public Applicant merge(Applicant applicant) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		
		try {
			s.beginTransaction();
			s.merge(applicant);
			s.getTransaction().commit();
		}catch(Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return applicant;
	}
}
