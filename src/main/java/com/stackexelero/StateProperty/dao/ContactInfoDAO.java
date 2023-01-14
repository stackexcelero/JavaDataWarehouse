package com.stackexelero.StateProperty.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stackexelero.StateProperty.model.ContactInfo;
import com.stackexelero.StateProperty.util.JPAUtility;

public class ContactInfoDAO {
	
	
	public void save(ContactInfo entity) {
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
	

	public ContactInfo findById(int id) {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		ContactInfo p = null;
		try {
			p = s.byId(ContactInfo.class).getReference(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return p;
	}

	public void delete(ContactInfo entity) {
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

	public List<ContactInfo> findAll() {
		SessionFactory sf = JPAUtility.getSessionFactory();
		Session s = sf.openSession();
		List<ContactInfo> list = null;
		try {
		    CriteriaBuilder cb = s.getCriteriaBuilder();
		    CriteriaQuery<ContactInfo> cq = cb.createQuery(ContactInfo.class);
		    Root<ContactInfo> rootEntry = cq.from(ContactInfo.class);
		    CriteriaQuery<ContactInfo> all = cq.select(rootEntry);
		    TypedQuery<ContactInfo> allQuery = s.createQuery(all);
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
			if(s.get(ContactInfo.class, id) != null) {
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
		    Query q3 = s.createQuery("DELETE FROM ContactInfo");
		    q3.executeUpdate();
		    s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
		    e.printStackTrace();
		}finally {
			s.close();
		}
	}
	
	public ContactInfo merge(ContactInfo entity) {
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
