package com.brown.sms.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Student;

import org.hibernate.Transaction;

public class CreateStudentTable {
	public static void createStudents () {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Student student = new Student();
		t.commit();
		session.close();
		factory.close();
	}
}
