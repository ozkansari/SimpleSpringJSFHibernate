package com.ozkansari;

import java.util.Date;
import org.hibernate.Session;

import com.ozkansari.db.entity.DBUser;
import com.ozkansari.db.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate Annotation + MySQL");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Date now = new Date();
		
		DBUser user = new DBUser();
		user.setUsername("User_" + now.getTime());
		user.setCreatedBy("system");
		user.setCreatedDate(now);
		user.setFirstname("firstname");
		user.setLastname("lastname");

		session.save(user);
		session.getTransaction().commit();
	}
}
