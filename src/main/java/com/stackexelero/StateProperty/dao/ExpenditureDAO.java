package com.stackexelero.StateProperty.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stackexelero.StateProperty.model.Expenditure;
import com.stackexelero.StateProperty.util.JPAUtility;

public class ExpenditureDAO {
	
	
	public void save(Expenditure entity) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		try {
			s.beginTransaction();
			s.save(entity);
			s.getTransaction().commit();
		}catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
	}
	

	public Expenditure findById(int id) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		Expenditure p = null;
		try {
			p = s.byId(Expenditure.class).getReference(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return p;
	}

	public void delete(Expenditure entity) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		try {
			s.getTransaction().begin();
			s.remove(entity);
			s.getTransaction().commit();
		}catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
	}

	public List<Expenditure> findAll() {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		List<Expenditure> list = null;
		try {
		    CriteriaBuilder cb = s.getCriteriaBuilder();
		    CriteriaQuery<Expenditure> cq = cb.createQuery(Expenditure.class);
		    Root<Expenditure> rootEntry = cq.from(Expenditure.class);
		    CriteriaQuery<Expenditure> all = cq.select(rootEntry);
		    TypedQuery<Expenditure> allQuery = s.createQuery(all);
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
			if(s.get(Expenditure.class, id) != null) {
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
		    Query q3 = s.createQuery("DELETE FROM Expenditure");
		    q3.executeUpdate();
		    s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
		    e.printStackTrace();
		}finally {
			s.close();
		}
	}
	
	public Expenditure merge(Expenditure entity) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		
		try {
			s.beginTransaction();
			s.merge(entity);
			s.getTransaction().commit();
		}catch(Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return entity;
	}
}
