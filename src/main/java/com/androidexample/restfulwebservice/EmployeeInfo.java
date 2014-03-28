package com.androidexample.restfulwebservice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 28/3/14
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeInfo extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
    setContentView(R.layout.empinfo);
    displayEmpInfo();
  }

  private void displayEmpInfo() {
    TextView tv= (TextView) findViewById(R.id.data);
    EmployeeList employeeList= (EmployeeList) getIntent().getExtras().getSerializable("employees");
    Employee employee=employeeList.getFoos().get(getIntent().getExtras().getInt("position"));
    String outPut="";
    outPut += " Name 		    : " + employee.getName() + " \n "
          + "email 		      : " + employee.getEmail() + " \n "
        + "PhNumber 		: " + employee.getPhone() + " \n "
        + "feedback 		:" + employee.getFeedback_type() + " \n "
        + "message 		: " + employee.getMessage() + " \n ";
    tv.setText(outPut);
  }
}
