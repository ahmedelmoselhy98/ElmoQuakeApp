package com.e.k.m.a.elmoquakeapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ahmedelmoselhy on 3/5/2018.
 */

public class QuakeAdapter extends ArrayAdapter<QuakeModel> {

    public QuakeAdapter(@NonNull Context context, @NonNull List<QuakeModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        QuakeModel quakeModel = getItem(position);
        if (convertView == null)
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.quake_card,parent,false);


        TextView locationTextView = convertView.findViewById(R.id.quake_location_textview);
        locationTextView.setText(quakeModel.getQuakeLocation());
        TextView magnituderTextView = convertView.findViewById(R.id.quake_magnitude_textview);
        magnituderTextView.setText(quakeModel.getQuakeMagnitude());
        TextView dateTextView = convertView.findViewById(R.id.quake_date_textview);
        dateTextView.setText(quakeModel.getQuakeDate());
        return convertView;
    }
}
