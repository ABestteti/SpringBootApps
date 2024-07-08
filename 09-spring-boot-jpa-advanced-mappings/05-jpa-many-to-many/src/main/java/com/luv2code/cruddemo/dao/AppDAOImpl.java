package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.dao.exception.CourseNotFoundException;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class AppDAOImpl implements AppDAO {

  // define field for entity manager
  private final EntityManager entityManager;

  // Define the LOGGER object
  private static final Logger LOGGER = LoggerFactory.getLogger(AppDAOImpl.class);

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
    // break bidirectional link
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

  @Override
  @Transactional
  public void deleteCourseById(int theCourseId) {
    LOGGER.info("Calling deleteCourseById with id: {}", theCourseId);
    Course course = entityManager.find(Course.class, theCourseId);
    if(course != null){
      LOGGER.info("Course found and to be deleted: {}", course);
      entityManager.remove(course);
    } else {
      LOGGER.error("CourseNotFoundException. Course with id: {} not found.", theCourseId);
      throw new CourseNotFoundException("Course with id: "+ theCourseId + " not found.");
    }
  }

  @Override
  @Transactional
  public void saveCourse(Course theCourse) {
    LOGGER.info("Calling saveCourse...");
    entityManager.persist(theCourse);
    LOGGER.info("Course saved with id: {}", theCourse.getId());
  }

  @Override
public Course findCourseAndReviewsByCourseId(int theCourseId) {
    LOGGER.info("Finding Course with id: {}", theCourseId);

    TypedQuery<Course> query = entityManager.createQuery(
            "select c from Course c JOIN FETCH c.reviews where c.id = :courseId", Course.class
    );

    query.setParameter("courseId", theCourseId);
    LOGGER.info("Parameter courseId set for the query: {}", theCourseId);

    Course resultCourse = query.getSingleResult();
    if(resultCourse != null){
        LOGGER.info("Course found with id: {}", theCourseId);
    } else {
        LOGGER.info("No Course found with id: {}", theCourseId);
    }

    return resultCourse;
}

  @Override
  public Course findCourseAndStudentsByCourseId(int theCourseId) {
    LOGGER.info("Finding Course/students with course id: {}", theCourseId);

    TypedQuery<Course> query = entityManager.createQuery(
            "select c from Course c JOIN FETCH c.students where c.id = :courseId", Course.class
    );

    query.setParameter("courseId", theCourseId);
    LOGGER.info("Parameter courseId set for the query: {}", theCourseId);

    Course resultCourse = query.getSingleResult();
    if(resultCourse != null){
      LOGGER.info("Course/students found with course id: {}", theCourseId);
    } else {
      LOGGER.info("No Course found with course id: {}", theCourseId);
    }

    return resultCourse;
  }

  @Override
  public Student findStudentAndCourseByStudentId(int theStudentId) {
    // create a query
    TypedQuery<Student> query = entityManager.createQuery(
            "select s from Student s join fetch s.courses where s.id = :studentId", Student.class
    );
    query.setParameter("studentId", theStudentId);

    // execute the query
    Student theStudent = query.getSingleResult();

    return theStudent;
  }

  @Override
  @Transactional
  public void updateStudent(Student theStudent) {
    LOGGER.info("Updating Student with id: {}", theStudent.getId());
    entityManager.merge(theStudent);
    LOGGER.info("Student updated with id: {}", theStudent.getId());
  }

  @Override
  @Transactional
  public void deleteStudentById(int theStudentId) {
    LOGGER.info("Deleting Student with id: {}", theStudentId);
    entityManager.remove(entityManager.find(Student.class, theStudentId));
    LOGGER.info("Student deleted with id: {}", theStudentId);
  }
}
