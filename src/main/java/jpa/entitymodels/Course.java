package jpa.entitymodels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Course {
	@Id
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String instructor; 

	public Course () {}

	public Course(int id, String name, String instructor) {
		this.id = id;
		this.name = name;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return String.format("%-3d %-30s %-20s", id, name, instructor);
	}
	
	
}
