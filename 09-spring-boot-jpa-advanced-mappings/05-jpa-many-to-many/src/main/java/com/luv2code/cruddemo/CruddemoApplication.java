package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CruddemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(AppDAO appDAO) {

    return runner -> {
      //createCourseAndStudents(appDAO);

      //findCourseAndStudents(appDAO);
      
      //findStudentAndCourses(appDAO);

      //addMoreCoursesForStudent(appDAO);

      //deleteCourse(appDAO);

      deleteStudent(appDAO);
    };
  }

  private void deleteStudent(AppDAO appDAO) {
    int studentId = 1;

    appDAO.deleteStudentById(studentId);
  }

  private void addMoreCoursesForStudent(AppDAO appDAO) {
    int theStudent = 2;

    // Find the student
    Student student = appDAO.findStudentAndCourseByStudentId(theStudent);

    // Add courses to student
    student.addCourse(new Course("Rubidk's Cube - How to speed cube."));
    student.addCourse(new Course("Atari 2600 - Game development."));

    // Save student changes and add new courses
    System.out.println("Updating student..: " + student);
    System.out.println("Associated courses: " + student.getCourses());

    appDAO.updateStudent(student);

    System.out.println("Done!");
  }

  private void findStudentAndCourses(AppDAO appDAO) {
    int theStudentId = 2;

    Student student = appDAO.findStudentAndCourseByStudentId(theStudentId);

    System.out.println("Student loaded: " + student);
    System.out.println("Courses.......: " + student.getCourses());

    System.out.println("Done!");
  }

  private void findCourseAndStudents(AppDAO appDAO) {
    int theCourseId = 10;

    Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theCourseId);

    System.out.println("Found the course: " + tempCourse);
    System.out.println("Student list:" + tempCourse.getStudents());
    System.out.println("Done!");
  }

  private void createCourseAndStudents(AppDAO appDAO) {

    // create a course
    Course course = new Course("Pacman - How to score one million points.");

    // create the students
    Student student1 = new Student("John", "Doe", "john@doe.com");
    Student student2 = new Student("Mary", "Public", "mary@doe.com");

    // add students to the course
    course.addStudent(student1);
    course.addStudent(student2);

    // save the course and associated students
    appDAO.saveCourse(course);
    System.out.println("Added course..: " + course);
    System.out.println("Added students: " + course.getStudents());
    System.out.println("Done!");
  }

  private void deleteCourseAndReviews(AppDAO appDAO) {
    int theCourseId = 12;
    appDAO.deleteCourseById(theCourseId); // it will also delete the reviews because of the CascadeType.ALL
    System.out.println("Course deleted: " + theCourseId);
  }

  private void retrieveCourseAndReviews(AppDAO appDAO) {
    int theCourseId = 12;

    Course course = appDAO.findCourseAndReviewsByCourseId(theCourseId);

    System.out.println("Course:" + course);

    System.out.println("Reviews:" + course.getReviews());

    System.out.println("Done!");
  }

  private void createCourseAndReviews(AppDAO appDAO) {
    Course tempCourse = new Course("Pacman - how to score one million points.");

    tempCourse.addReview(new Review("Create course....loved it."));
    tempCourse.addReview(new Review("Funny course....Hahahaha."));
    tempCourse.addReview(new Review("I do prefer River Ride."));

    // save the course and leverage the cascade all.
	appDAO.saveCourse(tempCourse);
  }

  private void deleteCourse(AppDAO appDAO) {
    int theCourseId = 10;

    System.out.println("Deleting course " + theCourseId);
    appDAO.deleteCourseById(theCourseId);

    System.out.println("Done!");
  }

  private void updateCourse(AppDAO appDAO) {
    int theCouseId = 10;

    // Find the course
    System.out.println("Find couse id: " + theCouseId);
    Course tempCourse = appDAO.findCourseById(theCouseId);

    // Update the course
    System.out.println("Update course: " + theCouseId);
    tempCourse.setTitle("Enjoy the simple things");

    appDAO.updateCourse(tempCourse);

    System.out.println("Done!");
  }

  private void updateInstructor(AppDAO appDAO) {
    int theId = 1;
    System.out.println("Finding instructor id: " + theId);
    Instructor instructor = appDAO.findInstructorById(theId);

    System.out.println("Updating instructor id: " + theId);
    instructor.setLastName("TESTER");

    appDAO.update(instructor);
    System.out.println("Done!");
  }

  private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

    int theId = 1;

    // find the instructor
    System.out.println("Finding instructor with id: " + theId);
    Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);

    System.out.println("Found instructor: " + instructor);
    System.out.println("the associated courses: " + instructor.getCourses());
    System.out.println("Done!");
  }

  private void findCoursesForInstructor(AppDAO appDAO) {
    int theId = 1;
    System.out.println("Find Instructor id: " + theId);

    Instructor tempInstructor = appDAO.findInstructorById(theId);

    System.out.println("Instructor: " + tempInstructor);

    // find courser for the instructor
    System.out.println("Finding Courses for Instructor id: " + theId);
    List<Course> courseList = appDAO.findCoursesByInstructorId(theId);

    // associate the objects
    tempInstructor.setCourses(courseList);

    System.out.println("The associated Courses: " + tempInstructor.getCourses());
    System.out.println("Done!");
  }

  private void findInstructorWithCourses(AppDAO appDAO) {
    int theId = 1;
    System.out.println("Find Instructor id: " + theId);

    Instructor tempInstructor = appDAO.findInstructorById(theId);

    System.out.println("Instructor: " + tempInstructor);
    System.out.println("the associate courses: " + tempInstructor.getCourses());

    System.out.println("Done!");
  }

  private void createInstructorWithCourses(AppDAO appDAO) {
    // create the instructor
    Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");

    // create the instructor detail
    InstructorDetail tempInstructorDetail =
        new InstructorDetail("http://www.youtube.com", "Video Games");

    // associate the objects
    tempInstructor.setInstructorDetail(tempInstructorDetail);

    // create some courses
    Course tmpCourse1 = new Course("Air Guitar - The ultimate guide.");
    Course tmpCourse2 = new Course("The Pinball masterclass.");

    // add courses to instructor
    tempInstructor.add(tmpCourse1);
    tempInstructor.add(tmpCourse2);

    // save the instructor
    //
    // NOTE: this will ALSO save the couses
    // because of CascadeType.PERSIST
    //
    System.out.println("Saving Instructor: " + tempInstructor);
    System.out.println("The courses: " + tempInstructor.getCourses());

    appDAO.save(tempInstructor);

    System.out.println("Done!");
  }

  private void deleteInstructorDetail(AppDAO appDAO) {

    int theId = 3;
    System.out.println("Deleting instructor detail id: " + theId);

    appDAO.deleteInstructorDetailById(theId);

    System.out.println("Done!");
  }

  private void findInstructorDetail(AppDAO appDAO) {

    // get the instructor detail object
    int theId = 2;
    InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

    // print the instructor detail
    System.out.println("tempInstructorDetail: " + tempInstructorDetail);

    // print the associated instructor
    System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

    System.out.println("Done!");
  }

  private void deleteInstructor(AppDAO appDAO) {

    int theId = 1;
    System.out.println("Deleting instructor id: " + theId);

    appDAO.deleteInstructorById(theId);

    System.out.println("Done!");
  }

  private void findInstructor(AppDAO appDAO) {

    int theId = 2;
    System.out.println("Finding instructor id: " + theId);

    Instructor tempInstructor = appDAO.findInstructorById(theId);

    System.out.println("tempInstructor: " + tempInstructor);
    System.out.println(
        "the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
  }

  private void createInstructor(AppDAO appDAO) {

    /*
    // create the instructor
    Instructor tempInstructor =
    		new Instructor("Chad", "Darby", "darby@luv2code.com");

    // create the instructor detail
    InstructorDetail tempInstructorDetail =
    		new InstructorDetail(
    				"http://www.luv2code.com/youtube",
    				"Luv 2 code!!!");
    */

    // create the instructor
    Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

    // create the instructor detail
    InstructorDetail tempInstructorDetail =
        new InstructorDetail("http://www.luv2code.com/youtube", "Guitar");

    // associate the objects
    tempInstructor.setInstructorDetail(tempInstructorDetail);

    // save the instructor
    //
    // NOTE: this will ALSO save the details object
    // because of CascadeType.ALL
    //
    System.out.println("Saving instructor: " + tempInstructor);
    appDAO.save(tempInstructor);

    System.out.println("Done!");
  }
}
