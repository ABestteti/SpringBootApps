package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

  // define field for entity manager
  private EntityManager entityManager;

  // inject entity manager using constructor injection
  @Autowired
  public AppDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Instructor theInstructor) {
    entityManager.persist(theInstructor);
  }

  @Override
  @Transactional
  public void update(Instructor theInstructor) {
    entityManager.merge(theInstructor);
  }

  @Override
  public Instructor findInstructorById(int theInstructorId) {
    return entityManager.find(Instructor.class, theInstructorId);
  }

  @Override
  @Transactional
  public void deleteInstructorById(int theInstructorId) {

    // retrieve the instructor
    Instructor tempInstructor = entityManager.find(Instructor.class, theInstructorId);

    // break association of all courses for the instructor
    for (Course tmpCourse : tempInstructor.getCourses()) {
      tmpCourse.setInstructor(null);
    }

    // delete the instructor
    entityManager.remove(tempInstructor);
  }

  @Override
  public InstructorDetail findInstructorDetailById(int theInstructorId) {
    return entityManager.find(InstructorDetail.class, theInstructorId);
  }

  @Override
  @Transactional
  public void deleteInstructorDetailById(int theInstructorId) {

    // retrieve instructor detail
    InstructorDetail tempInstructorDetail =
        entityManager.find(InstructorDetail.class, theInstructorId);

    // remove the associated object reference
    // break bi-directional link
    //
    tempInstructorDetail.getInstructor().setInstructorDetail(null);

    // delete the instructor detail
    entityManager.remove(tempInstructorDetail);
  }

  @Override
  public List<Course> findCoursesByInstructorId(int theInstructorId) {
    // create the query
    TypedQuery<Course> query =
        entityManager.createQuery(
            "select c from Course c where c.instructor.id = :instructorId", Course.class);
    query.setParameter("instructorId", theInstructorId);

    return query.getResultList();
  }

  @Override
  public Instructor findInstructorByIdJoinFetch(int theInstructorId) {
    // create the query
    TypedQuery<Instructor> query =
        entityManager.createQuery(
            "select i from Instructor i "
                + "JOIN FETCH i.courses "
                + "JOIN FETCH i.instructorDetail "
                + "where i.id = :instructorId",
            Instructor.class);
    query.setParameter("instructorId", theInstructorId);
    return query.getSingleResult();
  }

  @Override
  @Transactional
  public void updateCourse(Course theCourse) {
    entityManager.merge(theCourse);
  }

  @Override
  public Course findCourseById(int theCourseId) {
    return entityManager.find(Course.class, theCourseId);
  }

}
