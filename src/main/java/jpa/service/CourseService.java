package jpa.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jpa.dao.AbstractDAO;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

/*
 * CourseService accesses the sms.course table to:
 * get a list of all available courses
 * get a course by id
 */
public class CourseService extends AbstractDAO implements CourseDAO {
	
	private SessionFactory factory;
	
	public CourseService () {
		this.factory = super.getFactory();
	}

	@Override
	public List<Course> getAllCourses() {
		Session session = factory.openSession();
		List<Course> courses = session.createQuery("from Course").list();
		session.close();
		return courses;
	}
	
	public Course getCourseById(int id) {
		Session session = factory.openSession();
		Course course = session.get(Course.class, id);
		session.close();
		return course;
	}

}
