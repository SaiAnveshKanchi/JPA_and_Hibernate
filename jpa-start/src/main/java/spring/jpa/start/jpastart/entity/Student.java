package spring.jpa.start.jpastart.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany
	@JoinTable(name="STUDENT_COURSE",joinColumns = @JoinColumn(name="STUDENT_ID"),inverseJoinColumns = @JoinColumn(name="COURSE_ID"))
	private List<Course> courses = new ArrayList<>();

	public Student(String name) {
		super();
		this.name = name;
	}

	protected Student() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public void removeCourse(Course course) {
		this.courses.remove(course);
	}

	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}


}
