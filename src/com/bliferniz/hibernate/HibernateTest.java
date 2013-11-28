/**
 * 
 */
package com.bliferniz.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bliferniz.dto.UserDetails;

public class HibernateTest {

	private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {

		Session session = factory.openSession();
		session.beginTransaction();
		
		//NamedQuery
//		Query query = session.getNamedQuery("UserDetails.byId");
//		query.setInteger(0, 5);

		
		//NativeNamedQuery
		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "User7");
		
		
		List<UserDetails> users = (List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		session.close();

		for(UserDetails user : users){
			System.out.println(user.getUserId() + " : " + user.getUserName());
		}		
	}

	
}
