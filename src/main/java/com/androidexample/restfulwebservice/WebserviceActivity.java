package com.androidexample.restfulwebservice;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 27/3/14
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebserviceActivity extends Activity {
  StringBuilder sb;
  Intent intent;
  private Button GetServerData;
  List<String> names =new ArrayList<String>();

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home);
    getWidgets();
    GetServerData.setOnClickListener(action());
  }

  private void getWidgets() {
    GetServerData = (Button) findViewById(R.id.getData);
  }

  private View.OnClickListener action() {
    return new View.OnClickListener() {

      @Override
      public void onClick(View arg0) {
        new Webservice().execute();
      }
    };
  }

  private class Webservice extends AsyncTask {
    @Override
    protected Object doInBackground(Object... params) {

      String urlString = "http://192.168.0.100:9000/feedback/get";
      HttpURLConnection urlConnection = null;

      try {
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//        String response = IOUtils.toString(in, "UTF-8");
       sb= new StringBuilder();
        String line = null;
        // Read Server Response
        while ((line = in.readLine()) != null) {
          // Append server response in string
          sb.append(line + "\n");
         }

        nextActivity();

      } catch (Exception e) {
        Log.d("webservice", e.getMessage());
      } finally {
        urlConnection.disconnect();
      }
      return true;
    }
  }

  private void nextActivity() {
    Bundle bundle=new Bundle();
    bundle.putSerializable("employees",new EmployeeList(getEmployees()));
    intent = new Intent(this,  NameListActivity.class);
    intent.putExtras(bundle);
    intent.putStringArrayListExtra("names", (ArrayList<String>) names);
    startActivity(intent);
  }

  private ArrayList<Employee> getEmployees() {
    ArrayList<Employee> employees=new ArrayList<Employee>();
    Employee[] employeeArray=new Gson().fromJson(sb.toString(),Employee[].class);
    for(Employee e:employeeArray){
        names.add(e.getName());
      employees.add(e);
    }
    return employees;
  }

}
