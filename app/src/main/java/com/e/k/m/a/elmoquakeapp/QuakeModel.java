package com.e.k.m.a.elmoquakeapp;

/**
 * Created by ahmedelmoselhy on 3/3/2018.
 */

public class QuakeModel {

    private String quakeLocation;
    private String quakeMagnitude;
    private String quakeDate;

    public QuakeModel() {
    }

    public String getQuakeLocation() {
        return quakeLocation;
    }

    public void setQuakeLocation(String quakeLocation) {
        this.quakeLocation = quakeLocation;
    }

    public String getQuakeMagnitude() {
        return quakeMagnitude;
    }

    public void setQuakeMagnitude(String quakeMagnitude) {
        this.quakeMagnitude = quakeMagnitude;
    }

    public String getQuakeDate() {
        return quakeDate;
    }

    public void setQuakeDate(String quakeDate) {
        this.quakeDate = quakeDate;
    }
}
