package jpa.entitymodels;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@Column(name="email")
	private String email;
	@Column(name="name", nullable=false)
	private String name;
	@Column(name = "password",nullable=false)
	private String password;
	@ManyToMany(targetEntity=Course.class, fetch=FetchType.EAGER)
	private List<Course> courses; // Set would be more efficient but specs say List
	
 
	public Student () {
		email = "";
		name = "";
		password = "";
	}

	public Student(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [email=" + email + ", name=" + name + ", courses=" + courses + "]";
	}
	
	@Override
	public boolean equals (Object other) {
		if (other instanceof Student) {
			boolean sameEmail = this.email == ((Student) other).getEmail();
			boolean sameName = this.name == ((Student) other).getName();
			boolean samePass = this.password == ((Student) other).getPassword();
			if (sameEmail && sameName && samePass) {
				return true;
			}
		}
		return false;
		
	}
	
}
