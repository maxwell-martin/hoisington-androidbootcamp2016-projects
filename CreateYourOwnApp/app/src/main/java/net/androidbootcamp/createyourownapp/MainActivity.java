package net.androidbootcamp.createyourownapp;

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

        String[] massSports = { "Boston Celtics", "Boston Red Sox", "New England Patriots",
                "Boston Bruins", "New England Revolution" };

        setListAdapter(new ArrayAdapter<String>(MainActivity.this,
                R.layout.activity_main, R.id.massSports, massSports));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.nba.com/celtics/?")));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, RedSoxActivity.class));
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.patriots.com/")));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, BruinsActivity.class));
                break;
            case 4:
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.revolutionsoccer.net/")));
                break;
        }
    }
}
