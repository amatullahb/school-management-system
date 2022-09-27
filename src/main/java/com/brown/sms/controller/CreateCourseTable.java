package com.brown.sms.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Course;

public class CreateCourseTable {
	public static void createCourses () {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Course course = new Course();
		t.commit();
		session.close();
		factory.close();
	}
}
