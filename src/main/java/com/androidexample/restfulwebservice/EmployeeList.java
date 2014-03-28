package com.androidexample.restfulwebservice;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 28/3/14
 * Time: 12:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeList implements Serializable {

  private static final long serialVersionUID = 1L;

  private ArrayList<Employee> foos;

  public EmployeeList(ArrayList<Employee> foos) {
    this.foos = foos;
  }
  public ArrayList<Employee> getFoos() {
    return this.foos;
  }
}
