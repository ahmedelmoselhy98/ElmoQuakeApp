package com.e.k.m.a.elmoquakeapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ahmedelmoselhy on 3/5/2018.
 */

public class QuakeAdapter extends ArrayAdapter<QuakeModel> {
    private static final String LOCATION_SEPARATOR = " of ";
    public QuakeAdapter(@NonNull Context context, @NonNull List<QuakeModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        QuakeModel quakeModel = getItem(position);
        if (convertView == null)
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.quake_card,parent,false);

        String originalLocation = quakeModel.getQuakeLocation();
        String primaryLocation;
        String locationOffset;
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }


        TextView locationTextView = convertView.findViewById(R.id.quake_location_textview);
        locationTextView.setText(primaryLocation);
        TextView distanceTextView = convertView.findViewById(R.id.quake_distance_textview);
        distanceTextView.setText(locationOffset);



        TextView magnituderTextView = convertView.findViewById(R.id.quake_magnitude_textview);
        DecimalFormat formatter = new DecimalFormat("0.00");
        String output = formatter.format(quakeModel.getQuakeMagnitude());
        magnituderTextView.setText(output);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnituderTextView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(quakeModel.getQuakeMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);



        TextView dateTextView = convertView.findViewById(R.id.quake_date_textview);
        Date date = quakeModel.handleDateFormat(quakeModel.getQuakeDate());
        dateTextView.setText(formatDate(date));
        TextView timeTextView = convertView.findViewById(R.id.quake_time_textview);
        timeTextView.setText(formatTime(date));
        return convertView;
    }

    private int getMagnitudeColor(double quakeMagnitude) {
        int magnitude1Color;
        switch ((int) quakeMagnitude){
            case 0:
            case 1:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }


        return magnitude1Color;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
