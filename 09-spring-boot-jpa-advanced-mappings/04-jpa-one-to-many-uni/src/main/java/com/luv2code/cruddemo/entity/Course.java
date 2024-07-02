package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

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

  @Override
  public String toString() {
    return "Course{" + "id=" + id + ", title='" + title + '\'' + '}';
  }
}
