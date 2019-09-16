package hib.onetomany.entity;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hib.onetoone.entity.Instructor;
import hib.manytomany.entity.Review;
import hib.student.entity.Student;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	// Recall: the join column name is the field in the class-table orm that has the key for the object type being mapped
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	// New relationship added for a course having a collection of reviews
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	// New Relation for ManyToMany Mapping for Students in the course
	// JoinColumn is the key for THIS entity object, inverseColumn is the other object 
	@ManyToMany(fetch=FetchType.LAZY,
				cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="course_student",
			   joinColumns=@JoinColumn(name="course_id"), 
			   inverseJoinColumns=@JoinColumn(name="student_id"))
	private List<Student> students;
	
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor intructor) {
		this.instructor = intructor;
	}
	public String getCourseDetails() {
		String result = "Course Name: " + this.getTitle();
		return result;
	}
	public Course () {} 
	public Course(String title) {
		this.title = title;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	// Helper method for adding reviews
	public void addReview(Review newReview) {
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(newReview);
	}
	
	// Helper method for adding a student
	public void addStudent(Student newStudent) {
		if(students == null) {
			students = new ArrayList<>();
		}
		students.add(newStudent);
	}
}
