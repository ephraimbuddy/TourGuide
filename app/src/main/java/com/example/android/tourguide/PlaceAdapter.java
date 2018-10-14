package com.example.android.tourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    /**
     * custom constructor
     *
     * @param context the current context used to inflate the view
     * @param places a list of place objects to display in the list
     */
    public PlaceAdapter(Activity context, ArrayList<Place> places){

        super(context,0, places);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.place_list, parent, false);
        }

        Place currentPlace = getItem(position);
        // Get the textview with the name of the place
        TextView placeName = (TextView) listItemView.findViewById(R.id.name_text);
        placeName.setText(currentPlace.getmName());
        //Get the textview with the address
        TextView address = (TextView) listItemView.findViewById(R.id.address_text);
        address.setText(currentPlace.getmAddress());
        //Get the ImageView with the place picture
        ImageView imageview = (ImageView) listItemView.findViewById(R.id.card_thumbnail);
        imageview.setImageResource(currentPlace.getmImageResourceId());

        return listItemView;
    }
}

