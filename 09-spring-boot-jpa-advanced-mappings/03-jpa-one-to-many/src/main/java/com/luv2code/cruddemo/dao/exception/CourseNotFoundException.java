package com.luv2code.cruddemo.dao.exception;

public class CourseNotFoundException extends RuntimeException {

  public CourseNotFoundException(String message) {
    super(message);
  }

  //Optional: if you want to include the cause of the exception as well
  public CourseNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
