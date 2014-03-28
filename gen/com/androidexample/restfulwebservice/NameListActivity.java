package com.androidexample.restfulwebservice;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 28/3/14
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class NameListActivity extends ListActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
      setContentView(R.layout.namelist);
    setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getIntent().getStringArrayListExtra("names")));

  }
  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    // TODO Auto-generated method stub
    super.onListItemClick(l, v, position, id);
    EmployeeList employeeList= (EmployeeList) getIntent().getExtras().getSerializable("employees");
    Bundle bundle=new Bundle();
    bundle.putSerializable("employees",employeeList);
    Intent i = new Intent(this, EmployeeInfo.class);
    i.putExtras(bundle);
    i.putExtra("position",position);
    startActivity(i);
  }

}
