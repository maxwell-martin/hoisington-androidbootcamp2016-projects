package net.androidbootcamp.bodymassindexbmicalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BmiActivity extends AppCompatActivity {
    int weight;
    int height;
    double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        weight = sharedPreferences.getInt("weight", 0);
        height = sharedPreferences.getInt("height", 0);

        bmi = (double)(weight * 703) / (double)(height * height);

        DecimalFormat formatter = new DecimalFormat("###,###,##0.0");

        TextView txtBmi = findViewById(R.id.txtBmi);
        txtBmi.setText("Your Body Mass Index is " + formatter.format(bmi));
    }
}
