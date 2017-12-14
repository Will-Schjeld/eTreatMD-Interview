package com.example.willi.etreatmdinterview;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Willi on 12/13/2017.
 */

public class Parser {

    private InputStream inputStream;

    public Parser(InputStream in){
        this.inputStream = in;
    }

    public Map<String,String> parse() throws IOException{
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
        return readDataArray(jsonReader);
    }


    private Map<String, String> readDataArray(JsonReader reader) throws IOException {
        //Maps Unique ID to a patient
        Map<String, String> patientsAndIDsMap = new HashMap<>();

        reader.beginArray();
        while(reader.hasNext()){
            List<String> patientAndIDList = readMessage(reader);
            patientsAndIDsMap.put(patientAndIDList.get(0), patientAndIDList.get(1));
        }
        reader.endArray();
        return patientsAndIDsMap;
    }

    private List<String> readMessage(JsonReader reader) throws IOException{
        List<String> patientAndIDList = new ArrayList<>();
        String patientName = "";
        String patientId = "";

        reader.beginObject();
        while(reader.hasNext()){
            String name = reader.nextName();
            if(name.equals("name")){
                patientName = reader.nextString();
            }
            else if(name.equals("id")){
                patientId = reader.nextString();
            }
            else{
                reader.skipValue();
            }
        }
        reader.endArray();

        patientAndIDList.add(patientId);
        patientAndIDList.add(patientName);
        return patientAndIDList;
    }
}
