package com.example.willi.etreatmdinterview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, String> IDsToPatientMap = new HashMap<>();

        try {
            URL url = new URL("http://159.203.62.239:3000/patients.json");
            IDsToPatientMap = new DownloadFilesTask().execute(url).get();
        }
        catch(Exception e) {
        }

        Set<String> myValuesInSet = new HashSet<>(IDsToPatientMap.values());
        final String[] nameArray = myValuesInSet.toArray(new String[myValuesInSet.size()]);
        Set<String> myKeysInSet = new HashSet<>(IDsToPatientMap.keySet());
        final String[] idArray =  myKeysInSet.toArray(new String[myKeysInSet.size()]);

        CustomListAdapter listAdapter = new CustomListAdapter(this, nameArray);

        listView = (ListView) findViewById(R.id.listviewID);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Page2Activity.class);
                String patientName = nameArray[position];
                String patientID =  idArray[position];
                intent.putExtra("patient", patientName);
                intent.putExtra("id", patientID);
                startActivity(intent);
            }
        });
    }

}
