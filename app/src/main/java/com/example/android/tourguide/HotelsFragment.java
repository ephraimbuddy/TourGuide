package com.example.android.tourguide;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.cyson_hotel), getString(R.string.itolu), R.drawable.h1));
        places.add(new Place(getString(R.string.grand_hotel), getString(R.string.bonsaac), R.drawable.h2));
        places.add(new Place(getString(R.string.western_plus_hotel), getString(R.string.mbairi), R.drawable.h3));
        places.add(new Place(getString(R.string.zanzibar_hotel), getString(R.string.destoni), R.drawable.h4));
        places.add(new Place(getString(R.string.little_paradise_hotel), getString(R.string.francis_street), R.drawable.h5));
        places.add(new Place(getString(R.string.lone_palm_hotel), getString(R.string.achuzi_street), R.drawable.h6));
        places.add(new Place(getString(R.string.white_label_hotel), getString(R.string.mbabi), R.drawable.h7));
        places.add(new Place(getString(R.string.golden_pie_hotel), getString(R.string.itolu), R.drawable.h8));
        places.add(new Place(getString(R.string.aziza_hotel), getString(R.string.destoni), R.drawable.h9));

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
