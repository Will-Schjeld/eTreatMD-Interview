package com.example.willi.etreatmdinterview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Willi on 12/12/2017.
 *
 * This class allows for adaptation of a string array to a listview
 */

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the list of patient names
    private final String[] nameArray;

    /**
     * Constructor creates a CustomListAdapter object
     * @param context the activity in which the listview is held
     * @param nameArrayParam string array whose data is to be displayed
     */
    public CustomListAdapter(Activity context, String[] nameArrayParam){
        super(context, R.layout.listview_row, nameArrayParam);
        this.context = context;
        this.nameArray = nameArrayParam;
    }

    /**
     * Get a view that displays the data at the specified position in the data set
     * @param position the position of the item in the adapters data set whose view we want
     * @param view The old view to reuse
     * @param parent the parent that this view will be attached to
     * @return a View corresponding to the data at the specified position
     */
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        TextView nameTextField = (TextView) rowView.findViewById(R.id.patientName);

        nameTextField.setText(nameArray[position]);

        return rowView;

    }
}
