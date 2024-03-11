package com.example.hibernate_DB_mapping.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE, 
						  CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	@JsonBackReference (value = "i_id")
	private Instructor instructor;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	@ManyToMany(fetch = FetchType.LAZY, 
				cascade = {CascadeType.DETACH,CascadeType.MERGE, 
							CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "course_student", 
				joinColumns = @JoinColumn(name = "course_id"),
				inverseJoinColumns = @JoinColumn(name="student_id"))
	@JsonBackReference(value = "std_list")
	private Set<Student> students;
	
	public Course() {}
	
	public Course(String title, Instructor instructor, List<Review> reviews,Set<Student> students) {
		this.title = title;
		this.instructor = instructor;
		this.reviews = reviews;
		this.students = students;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

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

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	
	public void addReviews(Review rev)
	{
		if(reviews == null)
		{
			reviews = new ArrayList<>();
			
		}
		reviews.add(rev);
	}
	
	public void addStudent(Student student)
	{
		if(students == null)
		{
			students = new HashSet<>();
			
		}
		students.add(student);
	}
	

}
