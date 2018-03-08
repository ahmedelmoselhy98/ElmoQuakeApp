package com.e.k.m.a.elmoquakeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    ListView quakeListView;
    QuakeAdapter quakeAdapter;
    ArrayList<QuakeModel> quakeArrayList = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initilizeUi();
    }

    public void initilizeUi(){
        quakeListView = findViewById(R.id.quake_listview);
        quakeArrayList = QuakeUtils.extractEarthquakes();
        quakeAdapter = new QuakeAdapter(this.getBaseContext(),quakeArrayList);
        quakeListView.setAdapter(quakeAdapter);
        quakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                QuakeModel quakeModel = quakeArrayList.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(quakeModel.getQuakeUrl()));
                startActivity(intent);
            }
        });
    }

    // this method create a list of object Data
    public void makeQuakeData(){
//        for (int i =0;i < locations.length;i++){
//            QuakeModel quakeModel  =  new QuakeModel();
//            quakeModel.setQuakeMagnitude(magnitudes[i]);
//            quakeModel.setQuakeLocation(locations[i]);
//            quakeModel.setQuakeDate(dates[i]);
//            quakeArrayList.add(i,quakeModel);
//        }
        quakeArrayList = QuakeUtils.extractEarthquakes();
        quakeListView.setAdapter(quakeAdapter);
    }


    public class fetchQuakeData{

    private URL createUrl(String stringUrl){
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e(TAG,"Error With Creating Url"+e.getMessage());
        }
        return url;
    }
        private String makeHttpRequest(URL url) throws IOException{
            String jsonResponse = "";
            if (url == null) {
                return jsonResponse;
            }

            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;

            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                if (urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
                }else
                    Log.e(TAG,"HttpResponseCode"+urlConnection.getResponseCode());
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(TAG,"Error With MakeHttpReqquest"+e.getMessage());
            }finally {
                if (urlConnection != null)
                    urlConnection.disconnect();
                if (inputStream != null)
                    inputStream.close();
            }


            return jsonResponse;
        }

        private String readFromStream(InputStream inputStream) throws IOException {
            StringBuilder output =new StringBuilder();
            if (inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null){
                output.append(line);
                line = bufferedReader.readLine();
            }
            }

            return output.toString();
        }
    }


}
