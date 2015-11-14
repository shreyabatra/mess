package com.example.shreyabatra.mess;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    String days[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,R.layout.single_row,R.id.textView,days));


    }
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese=days[position];
        try {
            Class ourClass = Class.forName("com.example.shreyabatra.mess." + cheese);

            Intent ourIntent = new Intent(MainActivity.this, ourClass);

            startActivity(ourIntent);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }


    }
}


