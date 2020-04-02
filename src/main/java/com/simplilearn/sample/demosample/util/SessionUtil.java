package com.simplilearn.sample.demosample.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.sample.demosample.entity.Employee;



public class SessionUtil {
	
	
	// static
	private static SessionUtil instance = new SessionUtil();
	
    private static SessionFactory sessionFactory;
    
    public static SessionUtil getInstance() {
    	return instance;
    }
    
    private SessionUtil() {
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml")
    	.addAnnotatedClass(Employee.class);
    	sessionFactory = configuration.buildSessionFactory();    	
    }
    
    public static Session getSession() {
    	Session session =getInstance().sessionFactory.openSession();
    	return session;
    }
}
