package net.androidbootcamp.coffeefinderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] coffeeShops = { "stellar coffee co.", "The Coffee Bar", "Jo's Cafe", "Mochas & Javas" };

        setListAdapter(new ArrayAdapter<String>(MainActivity.this,
                R.layout.activity_main, R.id.coffeeShops, coffeeShops));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, StellarActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, CoffeeBarActivity.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, JosCafeActivity.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, MochasJavasActivity.class));
                break;
        }
    }
}
