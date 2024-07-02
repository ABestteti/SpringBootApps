package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.dao.exception.CourseNotFoundException;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import java.util.List;

public interface AppDAO {

  void save(Instructor theInstructor);

  void update(Instructor theInstructor);

  void deleteInstructorById(int theInstructorId);

  Instructor findInstructorById(int theInstructorId);

  InstructorDetail findInstructorDetailById(int theInstructorId);

  void deleteInstructorDetailById(int theInstructorId);

  List<Course> findCoursesByInstructorId(int theInstructorId);

  Instructor findInstructorByIdJoinFetch(int theInstructorId);

  // Course CRUD methods
  void updateCourse(Course theCourse);

  Course findCourseById(int theCourseId);

  void deleteCourseById(int theCourseId) throws CourseNotFoundException;

  void saveCourse(Course theCourse);

  Course findCourseAndReviewsByCourseId(int theCourseId);
}
