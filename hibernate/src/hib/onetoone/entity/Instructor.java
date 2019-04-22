package hib.onetoone.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hib.onetomany.entity.Course;


@Entity
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;

	// This is the mapping of a foreign-key
	// Make a new object instance with a join column and a relation
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	
	// Experiment with fetch type and lazy loading 
	// Use the instructor -> many course mapping as a bidirectional
	@OneToMany(fetch=FetchType.LAZY, mappedBy="instructor", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> Courses;
	
	public List<Course> getCourses() {
		// Iterate collection and print each course name - implement later
		return Courses;
	}

	public void setCourses(List<Course> courses) {
		Courses = courses;
	}

	public Instructor () {}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	public String getInstructorName () {
		return "Name: " + this.getFirstName() + ", " + this.getLastName();
	}
	
	// Adding two way methods for courses
	public void add(Course newCourse) {
		if (Courses == null) {
			Courses = new ArrayList<>();
		}
		Courses.add(newCourse);
		newCourse.setInstructor(this);
	}
}
