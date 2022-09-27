package jpa.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDAO {
	
	private SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public SessionFactory getFactory() {
		return factory;
	}
	
	public void close () {
		factory.close();
	}

}
