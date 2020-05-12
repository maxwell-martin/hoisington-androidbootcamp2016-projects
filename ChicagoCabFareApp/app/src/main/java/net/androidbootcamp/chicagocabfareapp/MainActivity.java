package net.androidbootcamp.chicagocabfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    final double initialCabFee = 3.00;
    final double costPerMile = 3.25;
    double distanceInMiles;
    double totalCostOfFare;
    String cabType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtMileage = findViewById(R.id.txtMileage);
        final Spinner spinCabTypes = findViewById(R.id.spinCabTypes);

        Button btnCompute = findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            final TextView txtCost = findViewById(R.id.txtCost);

            @Override
            public void onClick(View v) {
                distanceInMiles = Double.parseDouble(txtMileage.getText().toString());
                totalCostOfFare = initialCabFee + (costPerMile * distanceInMiles);
                cabType = spinCabTypes.getSelectedItem().toString();
                DecimalFormat currencyFormatter = new DecimalFormat("$###,###.##");
                txtCost.setText("Cost of cab ride in " + cabType + " is: " + currencyFormatter.format(totalCostOfFare));
            }
        });
    }
}
