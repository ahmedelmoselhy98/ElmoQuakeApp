package com.e.k.m.a.elmoquakeapp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ahmedelmoselhy on 3/3/2018.
 */

public class QuakeModel {

    private String quakeLocation;
    private String quakeUrl;
    private double quakeMagnitude;
    private long quakeDate;

    public QuakeModel() {
    }

    public String getQuakeLocation() {
        return quakeLocation;
    }

    public void setQuakeLocation(String quakeLocation) {
        this.quakeLocation = quakeLocation;
    }

    public double getQuakeMagnitude() {
        return quakeMagnitude;
    }

    public void setQuakeMagnitude(double quakeMagnitude) {
        this.quakeMagnitude = quakeMagnitude;
    }

    public long getQuakeDate() {
        return quakeDate;
    }

    public void setQuakeDate(long quakeDate) {
        this.quakeDate = quakeDate;
    }

    public Date handleDateFormat(long timeMiliSeconds){
        Date date = new Date(timeMiliSeconds);
        return date;
    }
    public String getQuakeUrl() {
        return quakeUrl;
    }

    public void setQuakeUrl(String quakeUrl) {
        this.quakeUrl = quakeUrl;
    }

}
