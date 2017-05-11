package com.example.a15031777.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15031777 on 11/5/2017.
 */

public class TaskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> tasks;
    private Context context;
    private TextView tvid;
    private TextView tvdesc;
    private TextView tvdate;
    public TaskAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        tasks = objects;
        // Store Context object as we would need to use it later
        this.context = context;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvid = (TextView) rowView.findViewById(R.id.tvID);
        tvdesc = (TextView) rowView.findViewById(R.id.tvDesc);
        tvdate = (TextView) rowView.findViewById(R.id.tvDate);

        Task currentTask = tasks.get(position);
        // Set the TextView to show the food

        tvid.setText(currentTask.getId());
        tvdesc.setText(currentTask.getDescription());
        tvdate.setText(currentTask.getDate());

        // Return the nicely done up View to the ListView
        return rowView;
    }


}
