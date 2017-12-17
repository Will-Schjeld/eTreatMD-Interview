package com.example.willi.etreatmdinterview;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Willi on 12/13/2017.
 *
 * This class allows for a json file to be fetched from a url
 */

public class DownloadFilesTask extends AsyncTask<URL, Void, Map<String,String>> {

    protected Map<String, String> doInBackground(URL... urls){
        int count = urls.length;
        Map<String, String> IDsToPatientMap = new HashMap<>();

        for(int i = 0; i < count; i++){
            try {
                HttpURLConnection con = (HttpURLConnection) urls[i].openConnection();
                con.setRequestMethod("GET");
                con.setConnectTimeout(10000);
                try {
                    con.connect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Parser parser = new Parser(con.getInputStream());
                IDsToPatientMap = parser.parse();
            }
            catch( Exception e){
                e.printStackTrace();
            }
            if(isCancelled()){ break;}
        }
        return IDsToPatientMap;
    }
}
