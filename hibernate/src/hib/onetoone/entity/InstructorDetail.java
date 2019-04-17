package hib.onetoone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name= "youtube_channel")
	private String youtubeChan;
	
	@Column(name= "hobby")
	private String hobby;
	
	// To add a bidirectional relation between instructor and instructor_detail. Add a new field for a one to one mapping with Instructor 
	// mappedBy points to the instructorDetail field in the Instructor class, since it has a JoinColumn, this tells it to use that relation and fetch the instructor
	
	@OneToOne(mappedBy="instructorDetail",cascade=CascadeType.ALL)
	private Instructor instructor;
	
	

	public InstructorDetail() {}
	public InstructorDetail(String youtubeChan, String hobby) {
		this.youtubeChan = youtubeChan;
		this.hobby = hobby;
	}
	public String getYoutubeChan() {
		return youtubeChan;
	}
	public void setYoutubeChan(String youtubeChan) {
		this.youtubeChan = youtubeChan;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
}
