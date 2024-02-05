package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countriesList}")
    private List<String> countriesList;

    @Value("${programmingLanguageList}")
    private List<String> programmingLanguageList;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        // create a student object
        Student theStudent = new Student();

        // add the student object to the model
        theModel.addAttribute("student", theStudent);

        // add the list of countries, from the application.properties file
        // to the model (theModel)
        theModel.addAttribute("countries", countriesList);

        // add the list of programming languages, from the application.properties file
        // to the model (theModel)
        theModel.addAttribute("favoriteLanguageList", programmingLanguageList);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

    System.out.println("==> theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
    return "student-confirmation";
    }
}
