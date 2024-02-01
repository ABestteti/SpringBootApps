package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CrudDemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {
      // createStudent(studentDAO);
      createMultipleStudents(studentDAO);
      // readStudent(studentDAO);
      //queryStudents(studentDAO);
      //queryStudentsByLastName(studentDAO);
      //updateStudent(studentDAO);
      //deleteStudent(studentDAO);
      //deleteAll(studentDAO);
    };
  }

  private void deleteAll(StudentDAO studentDAO) {
    System.out.println("Deleting all students");

    int numDeletedRows = studentDAO.deleteAll();

    System.out.println("Deleted row count: " + numDeletedRows);
  }

  private void deleteStudent(StudentDAO studentDAO) {
    int studentId = 3;
    System.out.println("Deleting student id: " + studentId);
    studentDAO.delete(studentId);

  }

  private void updateStudent(StudentDAO studentDAO) {
    // retrieve student based on the id: PK
    int studentId = 1;
    System.out.println("Getting student with id: " + studentId);
    Student myStudent = studentDAO.findById(studentId);

    // change the first name to "Scooby"
    System.out.println("Updating student...");
    myStudent.setFirstName("Scooby");

    // update the student
    studentDAO.update(myStudent);

    // display the updated student
    System.out.println("Updated student: " + myStudent);
  }

  private void queryStudentsByLastName(StudentDAO studentDAO) {
    // get a list of students
    List<Student> students = studentDAO.findByLastName("Doe");

    // display a list of students
    for (Student tmpStudent : students) {
      System.out.println(tmpStudent);
    }
  }

  private void queryStudents(StudentDAO studentDAO) {
    // get a list of students
    List<Student> students = studentDAO.findAll();

    // display list of students
    for (Student tmpStudent : students) {
      System.out.println(tmpStudent);
    }
  }

  private void readStudent(StudentDAO studentDAO) {
    // create a student object
    System.out.println("Creating a new student object...");
    Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

    // save the student
    studentDAO.save(tempStudent);

    // display the id of the saved student
    System.out.println("Saved student. Generated id: " + tempStudent.getId());

    // retriece the student based on the id (PK)
    System.out.println("Retrieving student with id: " + tempStudent.getId());
    Student myStudent = studentDAO.findById(tempStudent.getId());

    // display the retrieved student
    System.out.println("Found the student: " + myStudent);
  }

  private void createMultipleStudents(StudentDAO studentDAO) {
    Student student1 = new Student("John", "Doe", "john.doe@luv2code.com");
    Student student2 = new Student("Mary", "Doe", "mary.doe@luv2code.com");
    Student student3 = new Student("Bonita", "Applebum", "bonita.applebum@luv2code.com");

    studentDAO.save(student1);
    studentDAO.save(student2);
    studentDAO.save(student3);
  }

  private void createStudent(StudentDAO studentDAO) {
    // create the student object
    System.out.println("Creating new student object...");
    Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

    // save the student object
    System.out.println("Saving the student...");
    studentDAO.save(tempStudent);

    // display id of the saved student
    System.out.println("Saved student. Generated id: " + tempStudent.getId());
  }
}
