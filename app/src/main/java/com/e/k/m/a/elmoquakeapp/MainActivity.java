package com.e.k.m.a.elmoquakeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView quakeListView;
    QuakeAdapter quakeAdapter;
    ArrayList<QuakeModel> quakeArrayList = new ArrayList();
    String [] locations = {"San Francisco","London","Tokyo","Mexico City","Moscow","Rio de Janeiro","Paris"};
    String [] magnitudes = {"7.0","3.5","4.0","6.5","4.5","5.0","2.5"};
    String [] dates = {"7 April 2012","5 May 2013","20 Sept 2014","9 Jan 2015","7 April 2016","23 March 2017","16 April 2018"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initilizeUi();
        makeQuakeData();
    }

    public void initilizeUi(){
        quakeListView = findViewById(R.id.quake_listview);
        quakeAdapter = new QuakeAdapter(this.getBaseContext(),quakeArrayList);
    }

    // this method create a list of object Data
    public void makeQuakeData(){
        for (int i =0;i < locations.length;i++){
            QuakeModel quakeModel  =  new QuakeModel();
            quakeModel.setQuakeMagnitude(magnitudes[i]);
            quakeModel.setQuakeLocation(locations[i]);
            quakeModel.setQuakeDate(dates[i]);
            quakeArrayList.add(i,quakeModel);
        }
        quakeListView.setAdapter(quakeAdapter);
    }

}
