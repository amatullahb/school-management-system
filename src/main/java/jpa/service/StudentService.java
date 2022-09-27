package jpa.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jpa.dao.AbstractDAO;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;

/*
 * StudentService accesses the sms.student table to:
 * get all students
 * get students by email (pk)
 * validate student login information
 * register a given student for a given course
 * get all courses a student is registered for
 */
public class StudentService extends AbstractDAO implements StudentDAO {
	
	private SessionFactory factory;
	
	public StudentService () {
		this.factory = super.getFactory();
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = factory.openSession();
		List<Student> students = session.createQuery("from Student").list();
		session.close();
		return students;
	}

	@Override
	public Student getStudentByEmail(String email) {
		Session session = factory.openSession();
		Student student = session.get(Student.class, email);
		session.close();
		return student;
	}

	@Override
	public boolean validateStudent(String email, String password) {
		Student student = getStudentByEmail(email);
		if (student.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void registerStudentToCourse(Student student, int courseId) {
		Session session = factory.openSession();
		List <Course> courses = student.getCourses();
		boolean alreadyRegistered = false;
		for (Course course : courses) {
			if (course.getId() == courseId) {
				alreadyRegistered = true;
				System.out.println("You are already registered for that course!");
			}
		}
		if (!alreadyRegistered) {
			// get course associated with id
			CourseService cs = new CourseService();
			Course course = cs.getCourseById(courseId);
			// add that course to student's courses
			Transaction t = session.beginTransaction();
			courses.add(course);
			session.update(student);
			t.commit();
		}
		session.close(); 
	}

	@Override
	public List<Course> getStudentCourses(String email) {
		Student student = getStudentByEmail(email);
		return student.getCourses();
	}
	
}
