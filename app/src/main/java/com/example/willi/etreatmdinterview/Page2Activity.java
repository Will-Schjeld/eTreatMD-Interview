package com.example.willi.etreatmdinterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Page2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        //Sets the patient name on page 2
        String savedPatientExtra = getIntent().getStringExtra("patient");
        TextView patientNameText = (TextView) findViewById(R.id.NamePage2);
        patientNameText.setText(savedPatientExtra);

        //Sets the patient Id on page 2
        String savedIDExtra = getIntent().getStringExtra("id");
        TextView idText = (TextView) findViewById(R.id.IDPage2);
        idText.setText(savedIDExtra);
    }
}

