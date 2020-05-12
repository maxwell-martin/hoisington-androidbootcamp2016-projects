package net.androidbootcamp.techgadgetsapp;

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

        String[] techGadgets = { "Gamer Infinity 8800 Pro SE", "Xbox Series X",
                "NB North Bayou Dual Monitor Desk Mount Stand",
                "Asus MG278Q 27\" WQHD 1440P 144Hz 1ms Eye Care " +
                        "G-Sync Compatible Adaptive Sync Gaming Monitor",
                "Scuf Prestige Xbox Controller"};

        setListAdapter(new ArrayAdapter<String>(MainActivity.this, R.layout.activity_main,
                R.id.techGadgets, techGadgets));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, PcActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, XboxActivity.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, MonitorStandActivity.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, MonitorActivity.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, ScufActivity.class));
                break;
        }
    }
}
