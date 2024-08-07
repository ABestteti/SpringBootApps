package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "title", length = 128)
  private String title;

  @ManyToOne(
      cascade = {
        CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.DETACH
      })
  @JoinColumn(name = "instructor_id")
  private Instructor instructor;


  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "course_id")
  private List<Review> reviews;

  @ManyToMany(
          fetch = FetchType.LAZY,
          cascade = {
                  CascadeType.PERSIST, CascadeType.MERGE,
                  CascadeType.REFRESH, CascadeType.DETACH
          })
  @JoinTable(
          name="course_student",
          joinColumns = @JoinColumn(name = "course_id"),
          inverseJoinColumns = @JoinColumn(name = "student_id")
  )
  private List<Student> students;

  public Course() {}

  public Course(String title) {
    this.title = title;
  }

  public Instructor getInstructor() {
    return instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public void addReview(Review review) {
    if (reviews == null) {
        reviews = new ArrayList<>();
      }
      reviews.add(review);
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  // add a convenience method
  public void addStudent(Student theStudent) {
    if (students == null) {
      students = new ArrayList<>();
    }
    students.add(theStudent);
  }

  @Override
  public String toString() {
    return "Course{" + "id=" + id + ", title='" + title + '\'' + '}';
  }
}
