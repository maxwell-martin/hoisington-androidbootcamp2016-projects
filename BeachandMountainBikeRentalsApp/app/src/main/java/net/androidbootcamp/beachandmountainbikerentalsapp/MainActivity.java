package net.androidbootcamp.beachandmountainbikerentalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] bikes = { "Beach Bike Rentals", "Mountain Bike Rentals", "Bike Rentals Website" };

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bikes));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, BeachActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, MountainActivity.class));
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.campusbikeshop.com")));
        }
    }
}
