package com.thenerdjock.aaleman.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //How to put arrays of Strings into a ListView
        String[] favoriteTVShows = {"Buffy the Vampire Slayer", "Battlestar Galactica", "Lost",
            "Naruto", "Naruto: Shippuden", "Sword Art Online", "Entourage", "Game of Thrones",
            "Breaking Bad", "Bleach", "Top Gear"};

//        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
//                favoriteTVShows);

        //To use customized row_layout.xml
//        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.textView1,
//                favoriteTVShows);

        //Use customized adapter (MyAdapter.java)
        ListAdapter theAdapter = new MyAdapter(this, favoriteTVShows);

        ListView theListView = (ListView) findViewById(R.id.theListView);

        //Pass adapter we just created
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String tvShowPicked = "You selected " +
                        String.valueOf(adapterView.getItemAtPosition(position));

                Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
