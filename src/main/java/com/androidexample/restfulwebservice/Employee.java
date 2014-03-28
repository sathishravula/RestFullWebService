package com.androidexample.restfulwebservice;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 27/3/14
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Employee  implements Serializable{
  public void setName(String name) {
    this.name = name;
  }

  private  String name;

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", feedback_type='" + feedback_type + '\'' +
        ", message='" + message + '\'' +
        '}';
  }

  private  String email;
  private  String phone;
  private  String feedback_type;
  private String message;


  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setFeedback_type(String feedback_type) {
    this.feedback_type = feedback_type;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  public String getPhone() {
    return phone;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getFeedback_type() {
    return feedback_type;
  }

  public String getMessage() {
    return message;
  }



}
