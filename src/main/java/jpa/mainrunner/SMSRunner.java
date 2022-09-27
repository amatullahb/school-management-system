package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

/*
 * The SMSRunner is the class used to run the School Management System Application
 * it displays an initial menu,
 * prompts for student log in,
 * allows students to see the courses they are registered for,
 * allows students to see all courses,
 * facilitates the registration process
 */
public class SMSRunner {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentService ss = new StudentService();
		CourseService cs = new CourseService();
		
		displayMainMenu();
		boolean quit = false;
		
		switch (scan.nextInt()) {
			case 1:
				System.out.println("Enter your email:");
				String email = scan.next();
				scan.nextLine();
				System.out.println("Enter your password:");
				String password = scan.nextLine();
				boolean isValid = false;
				try {
					isValid = ss.validateStudent(email, password);
				} catch (NullPointerException e) {
//					System.out.println(e.getMessage());
				}
				if (!isValid ) {
					System.out.println("Invalid credentials");
					System.out.println("The program has been terminated");
					break;
				} else {
					Student student = ss.getStudentByEmail(email);
					while (!quit) {
						System.out.println("My courses:");
						System.out.printf("%-3s %-30s %-20s%n", "ID", "Course Name", "Instructor");
						List<Course> currCourses = student.getCourses();
						for (Course course : currCourses) {
							System.out.println(course);
						}
						System.out.println();
						
						displayStudentMenu();
						
						switch(scan.nextInt()) {
							case 1: 
								System.out.println("All courses:");
								System.out.printf("%-3s %-30s %-20s%n", "ID", "Course Name", "Instructor");
								List<Course> courses = cs.getAllCourses();
								for (Course course: courses) {
									System.out.println(course);
								}
								System.out.println();
								
								System.out.println("What is the id number of the course you'd like to add?");
								int courseNum = scan.nextInt();
								ss.registerStudentToCourse(student, courseNum);
								break;
							case 2:
								ss.close();
								cs.close();
								System.out.println("You have been logged out");
								quit = true;
								break;
						}
					}
				}
				case 2:
					ss.close();
					cs.close();
					System.out.println("You have quit the program");
					break;
			} 	
		
	}
	
	public static void displayMainMenu () {
		System.out.println("Please pick an option:");
		System.out.println("1. Student");
		System.out.println("2. Quit");
	}
	
	public static void displayStudentMenu () {
		System.out.println("Please pick an option:");
		System.out.println("1. Register for class");
		System.out.println("2. Logout");
	}
}
