package com.luv2code.springdemo.mvc.model;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
  private String firstName;

  @NotNull(message = "Last name is required.")
  @Size(min = 1, message = "Last name is required.")
  private String lastName;

  @Min(value = 0, message = "Must be greater than or equal to zero.")
  @Max(value = 10, message = "Must be less than or equal to 10.")
  @NotNull(message = "Free passes is required.")
  private Integer freePasses;

  @Pattern(regexp = "^[a-zA-Z0-9]{6}", message = "Only 6 chars/digits are acceptable.")
  private String postalCode;

  @CourseCode(value = "TOPS", message = "It must start with TOPS!")
  private String courseCode;

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public Integer getFreePasses() {
    return freePasses;
  }

  public void setFreePasses(Integer freePasses) {
    this.freePasses = freePasses;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
