package com.example.android.tourguide;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_detail);
        //Set the name
        TextView txt1 = (TextView) findViewById(R.id.name);
        String name = getIntent().getStringExtra(getString(R.string.name));
        txt1.setText(name);
        //Set the address
        TextView txt2 = (TextView) findViewById(R.id.address);
        txt2.setText(getIntent().getStringExtra(getString(R.string.address)));
        //Set Image
        ImageView img = (ImageView)findViewById(R.id.image);
        img.setImageResource(Integer.parseInt(getIntent().getStringExtra(getString(R.string.image))));
        getSupportActionBar().setTitle(name);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Enable UI Saving
                Intent parentIntent = NavUtils.getParentActivityIntent(this);
                parentIntent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(parentIntent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
