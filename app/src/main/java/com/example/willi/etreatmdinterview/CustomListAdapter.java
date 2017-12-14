package com.example.willi.etreatmdinterview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Willi on 12/12/2017.
 */

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the list of patient names
    private final String[] nameArray;

    public CustomListAdapter(Activity context, String[] nameArrayParam){
        super(context, R.layout.listview_row, nameArrayParam);
        this.context = context;
        this.nameArray = nameArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        TextView nameTextField = (TextView) rowView.findViewById(R.id.patientName);

        nameTextField.setText(nameArray[position]);

        return rowView;

    }
}
