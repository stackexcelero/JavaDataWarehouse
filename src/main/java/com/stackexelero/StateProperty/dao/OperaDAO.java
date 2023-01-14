package com.stackexelero.StateProperty.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stackexelero.StateProperty.model.Opera;
import com.stackexelero.StateProperty.util.JPAUtility;

public class OperaDAO {
	
	
	public void save(Opera entity) {
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
	

	public Opera findById(int id) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		Opera p = null;
		try {
			p = s.byId(Opera.class).getReference(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return p;
	}

	public void delete(Opera entity) {
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

	public List<Opera> findAll() {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		List<Opera> list = null;
		try {
		    CriteriaBuilder cb = s.getCriteriaBuilder();
		    CriteriaQuery<Opera> cq = cb.createQuery(Opera.class);
		    Root<Opera> rootEntry = cq.from(Opera.class);
		    CriteriaQuery<Opera> all = cq.select(rootEntry);
		    TypedQuery<Opera> allQuery = s.createQuery(all);
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
			if(s.get(Opera.class, id) != null) {
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
		    Query q3 = s.createQuery("DELETE FROM Opera");
		    q3.executeUpdate();
		    s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
		    e.printStackTrace();
		}finally {
			s.close();
		}
	}
	
	public Opera merge(Opera entity) {
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
