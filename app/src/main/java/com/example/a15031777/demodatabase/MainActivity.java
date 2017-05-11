package com.example.a15031777.demodatabase;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.lv);
        DBHelper db = new DBHelper(MainActivity.this);
        ArrayList<Task> task = db.getTasks();

        aa = new TaskAdapter(this,R.layout.row,task);
        lv.setAdapter(aa);

        Button btninsert = (Button) findViewById(R.id.btnInsert);
        Button btnGetTasks = (Button) findViewById(R.id.btnGetTasks);
        final TextView tvResults = (TextView) findViewById(R.id.tvResults);

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the db helper object, passing in the
                //activity's content

                DBHelper db = new DBHelper(MainActivity.this);

                //insert a task:
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the dbhelper object, passing in the activity's content
                DBHelper db = new DBHelper(MainActivity.this);

                //Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i + ". " + data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResults.setText(txt);
            }
        });



    }


    }
