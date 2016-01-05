package com.zx.common;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public final class HibernateUtil {

	private static SessionFactory sessionFactory;
	@SuppressWarnings("rawtypes")
	private static ThreadLocal session = new ThreadLocal();
	
	public HibernateUtil() {
		// TODO Auto-generated constructor stub
	}

	static {  
        try {  
            Configuration cfg = new Configuration();  
            cfg.configure();  
            sessionFactory = cfg.buildSessionFactory();  
        } catch (Exception e) {  
            e.printStackTrace();  
            // TODO: handle exception  
        }  
    }
	
	@SuppressWarnings("unchecked")
	public static Session getThreadLocalSession() {  
        Session s = (Session) session.get();  
        if (s == null) {  
            s = getSession();  
            session.set(s);  
        }  
        return s;  
    }
	
	@SuppressWarnings("unchecked")
	public static void closeSession() {  
        Session s = (Session) session.get();  
        if (s != null) {  
            s.close();  
            session.set(null);  
        }  
    }  
  
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
  
    public static Session getSession() {  
        return sessionFactory.openSession();  
    }  
  
    public static void add(Object entity) {  
        Session s = null;  
        Transaction tx = null;  
        try {  
            s = HibernateUtil.getSession();  
            tx = s.beginTransaction();  
            s.save(entity);  
            tx.commit();  
        } finally {  
            if (s != null)  
                s.close();  
        }  
    }  
  
    public static void update(Object entity) {  
        Session s = null;  
        Transaction tx = null;  
        try {  
            s = HibernateUtil.getSession();  
            tx = s.beginTransaction();  
            s.update(entity);  
            tx.commit();  
        } finally {  
            if (s != null)  
                s.close();  
        }  
    }  
  
    public static void delete(Object entity) {  
        Session s = null;  
        Transaction tx = null;  
        try {  
            s = HibernateUtil.getSession();  
            tx = s.beginTransaction();  
            s.delete(entity);  
            tx.commit();  
        } finally {  
            if (s != null)  
                s.close();  
        }  
    }  
  
    @SuppressWarnings("rawtypes")
	public static Object get(Class clazz, Serializable id) {  
  
        Session s = null;  
        try {  
            s = HibernateUtil.getSession();  
            Object obj = s.get(clazz, id);  
            return obj;  
        } finally {  
            if (s != null)  
                s.close();  
        }  
    }  
  
    public static void main(String[] args) {  
        Session session = null;  
        session = getSession();  
        System.out.println(session);  
    }  
}
