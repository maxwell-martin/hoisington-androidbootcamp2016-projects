package net.androidbootcamp.homemortgageinterestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class InterestActivity extends AppCompatActivity {
    double monthlyPayment;
    int years;
    int principal;
    int numberOfMonths;
    double totalInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        monthlyPayment = sharedPreferences.getFloat("monthlyPayment", 0);
        years = sharedPreferences.getInt("years", 0);
        principal = sharedPreferences.getInt("principal", 0);

        DecimalFormat currencyFormatter = new DecimalFormat("$###,###,##0.00");

        numberOfMonths = years * 12;
        totalInterest = (monthlyPayment * numberOfMonths) - principal;

        TextView txtInterest = findViewById(R.id.txtInterest);
        ImageView imgMortgageYears = findViewById(R.id.imgMortgageYears);

        txtInterest.setText("Total interest paid " + currencyFormatter.format(totalInterest));

        if (years == 10) {
            imgMortgageYears.setImageResource(R.drawable.ten);
        } else if (years == 20) {
            imgMortgageYears.setImageResource(R.drawable.twenty);
        } else if (years == 30) {
            imgMortgageYears.setImageResource(R.drawable.thirty);
        } else {
            imgMortgageYears.setImageResource(0);
            txtInterest.setText("Please enter a correct year (10, 20, or 30).");
        }


    }
}
