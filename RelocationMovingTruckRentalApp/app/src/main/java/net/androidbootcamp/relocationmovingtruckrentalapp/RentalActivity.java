package net.androidbootcamp.relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class RentalActivity extends AppCompatActivity {
    static final double TEN_FOOT = 19.95;
    static final double SEVENTEEN_FOOT = 29.95;
    static final double TWENTY_SIX_FOOT = 39.95;
    static final double COST_PER_MILE = 0.99;

    int truckSize;
    double miles;
    double cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental);

        TextView txtCost = findViewById(R.id.txtCost);
        ImageView imgTruck = findViewById(R.id.imgTruck);

        DecimalFormat formatter = new DecimalFormat("$###,###,##0.00");

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        truckSize = sharedPreferences.getInt("truckSize", 0);
        miles = sharedPreferences.getFloat("miles", 0);

        switch(truckSize) {
            case 10:
                cost = TEN_FOOT + miles * COST_PER_MILE;
                txtCost.setText("One day rental cost: " + formatter.format(cost));
                imgTruck.setImageResource(R.drawable.truck_ten);
                break;
            case 17:
                cost = SEVENTEEN_FOOT + miles * COST_PER_MILE;
                txtCost.setText("One day rental cost: " + formatter.format(cost));
                imgTruck.setImageResource(R.drawable.truck_seventeen);
                break;
            case 26:
                cost = TWENTY_SIX_FOOT + miles * COST_PER_MILE;
                txtCost.setText("One day rental cost: " + formatter.format(cost));
                imgTruck.setImageResource(R.drawable.truck_twenty_six);
                break;
            default:
                txtCost.setText("Please enter 10, 17, or 26 for truck length.");
                imgTruck.setImageResource(0);
                break;
        }
    }
}
