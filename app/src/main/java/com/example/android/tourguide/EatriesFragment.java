package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EatriesFragment extends Fragment {


    public EatriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.cyson_res), getString(R.string.mbabi), R.drawable.e1));
        places.add(new Place(getString(R.string.grand_res), getString(R.string.destoni), R.drawable.e2));
        places.add(new Place(getString(R.string.western_res), getString(R.string.omor), R.drawable.e3));
        places.add(new Place(getString(R.string.zanzibar_res), getString(R.string.bonsaac), R.drawable.e4));
        places.add(new Place(getString(R.string.little_paradise_res), getString(R.string.francis_street), R.drawable.e5));
        places.add(new Place(getString(R.string.lone_palm_res), getString(R.string.mbairi), R.drawable.e6));
        places.add(new Place(getString(R.string.golden_pie_res),getString(R.string.itolu), R.drawable.e2));
        places.add(new Place(getString(R.string.cyson_res), getString(R.string.destoni), R.drawable.e3));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        GridView gridView = (GridView) rootView.findViewById(R.id.grid);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the item clicked
                Place place = places.get(position);
                // Set object to Detail activity
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(getString(R.string.name), String.valueOf(place.getmName()));
                intent.putExtra(getString(R.string.address), String.valueOf(place.getmAddress()));
                intent.putExtra(getString(R.string.image),String.valueOf(place.getmImageResourceId()));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
