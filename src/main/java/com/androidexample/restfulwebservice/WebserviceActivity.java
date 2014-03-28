package com.androidexample.restfulwebservice;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

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
  private TextView tv;
  List<String> names =new ArrayList<String>();
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home);

    final Button GetServerData = (Button) findViewById(R.id.getData);
  tv= (TextView) findViewById(R.id.textView);
    GetServerData.setOnClickListener(action());


  }

  private View.OnClickListener action() {
    return new View.OnClickListener() {

      @Override
      public void onClick(View arg0) {
        Webservice webService = new Webservice();
        webService.execute();
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


        StringBuilder sb = new StringBuilder();
        String line = null;
        // Read Server Response
        while ((line = in.readLine()) != null) {
          // Append server response in string
          sb.append(line + "\n");
        }
        /*tv.setText(sb.toString());*/
        Log.d("webservice", sb.toString());
        Employee[] employees=new Gson().fromJson(sb.toString(),Employee[].class);
        for(Employee e:employees)
            names.add(e.getName());

          Intent intent=new Intent(Webservice.this,ListActivity.class);
       // Log.d("webservice1", e.toString());

      } catch (Exception e) {
        Log.d("webservice", e.getMessage());
      } finally {
        urlConnection.disconnect();
      }
      return true;
    }
  }

}
