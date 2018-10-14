package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {

    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.stadium), getString(R.string.itolu), R.drawable.a1));
        places.add(new Place(getString(R.string.filmhouse), getString(R.string.omor), R.drawable.a2));
        places.add(new Place(getString(R.string.bridge), getString(R.string.mbabi), R.drawable.a3));
        places.add(new Place(getString(R.string.government), getString(R.string.destoni), R.drawable.a4));
        places.add(new Place(getString(R.string.airport), getString(R.string.francis_street), R.drawable.a5));
        places.add(new Place(getString(R.string.shoprite), getString(R.string.achuzi_street), R.drawable.a6));
        places.add(new Place(getString(R.string.assembly), getString(R.string.ebeano), R.drawable.a7));

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
