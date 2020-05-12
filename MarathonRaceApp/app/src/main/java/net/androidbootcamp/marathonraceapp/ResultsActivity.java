package net.androidbootcamp.marathonraceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultsActivity extends AppCompatActivity {
    int totalMinutes;
    double averageMileTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        totalMinutes = sharedPreferences.getInt("totalMinutes", 0);

        averageMileTime = totalMinutes / 26.0;

        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");

        TextView txtResults = findViewById(R.id.txtResults);
        txtResults.setText("Average Mile Time: " + formatter.format(averageMileTime) + " minutes");

        ImageView imgMedal = findViewById(R.id.imgMedal);

        if (averageMileTime < 11.0) {
            imgMedal.setImageResource(R.drawable.gold_medal);
        } else if (averageMileTime < 15.0) {
            imgMedal.setImageResource(R.drawable.silver_medal);
        } else {
            imgMedal.setImageResource(R.drawable.bronze_medal);
        }
    }
}
