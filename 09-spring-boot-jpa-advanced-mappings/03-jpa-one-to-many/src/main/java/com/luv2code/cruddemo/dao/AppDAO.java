package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import java.util.List;

public interface AppDAO {

  void save(Instructor theInstructor);

  Instructor findInstructorById(int theInstructorId);

  void deleteInstructorById(int theInstructorId);

  InstructorDetail findInstructorDetailById(int theInstructorId);

  void deleteInstructorDetailById(int theInstructorId);

  List<Course> findCoursesByInstructorId(int theInstructorId);

  Instructor findInstructorByIdJoinFetch(int theInstructorId);
}
