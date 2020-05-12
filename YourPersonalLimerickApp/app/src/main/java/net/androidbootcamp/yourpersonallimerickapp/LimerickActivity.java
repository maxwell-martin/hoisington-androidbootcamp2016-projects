package net.androidbootcamp.yourpersonallimerickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class LimerickActivity extends AppCompatActivity {
    String city;
    String occupation;
    int number;
    String actionVerb;

    String line1;
    String line2;
    String line3;
    String line4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limerick);

        TextView txtLine1 = findViewById(R.id.txtLine1);
        TextView txtLine2 = findViewById(R.id.txtLine2);
        TextView txtLine3 = findViewById(R.id.txtLine3);
        TextView txtLine4 = findViewById(R.id.txtLine4);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        city = sharedPreferences.getString("city", "");
        occupation = sharedPreferences.getString("occupation", "");
        number = sharedPreferences.getInt("number", 0);
        actionVerb = sharedPreferences.getString("actionVerb", "");

        line1 = "Joe lives and works in " + city + ".";
        line2 = "He happily works as a " + occupation.toLowerCase() + ".";
        line3 = "Joe and his wife, Sally, have " + number + " dogs.";
        line4 = "Everyday, Joe " + actionVerb.toLowerCase() + "s for multiple hours.";

        txtLine1.setText(line1);
        txtLine2.setText(line2);
        txtLine3.setText(line3);
        txtLine4.setText(line4);
    }
}
