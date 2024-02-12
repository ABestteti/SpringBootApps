package com.luv2code.springdemo.mvc.controller;

import com.luv2code.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

  // add an initbinder ... to convert trim inpu strings
  // rempve leading and trailing whitespace
  // resolve issue for our validation
  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {

    // Pre-process every string form data
    // Remove leading and trailing whitespace
    // If string only has white space ... trim it to null.
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }

  @GetMapping("/")
  public String showForm(Model theModel) {
    theModel.addAttribute("customer", new Customer());

    return "customer-form";
  }

  @PostMapping("processForm")
  public String processForm(
      @Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {

    System.out.println("Last name: [" + theCustomer.getLastName() + "]");

    // The printout below will provide more details about the exception from the more specific error
    // type (at field level),
    // the the more generic. For example:
    // Binding results:org.springframework.validation.BeanPropertyBindingResult: 1 errors
    // Field error in object 'customer' on field 'freePasses': rejected value [newnn]; codes
    // [typeMismatch.customer.freePasses,typeMismatch.freePasses,typeMismatch.java.lang.Integer,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [customer.freePasses,freePasses]; arguments []; default message [freePasses]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'java.lang.Integer' for property 'freePasses'; For input string: "newnn"]
    // Check the messages,properties file for the typeMismatch.customer.freePasses object, and its
    // customized error merrsage,
    System.out.println("Binding results:" + theBindingResult);
    System.out.println("\n\n\n\n");

    if (theBindingResult.hasErrors()) {
      return "customer-form";
    } else {
      return "customer-confirmation";
    }
  }
}
