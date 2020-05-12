package net.androidbootcamp.triathlonregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int costPerPerson = 725;
    int numberOfAthletes;
    double teamCost;
    String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtAthletes = findViewById(R.id.txtAthletes);
        final Spinner spinLocations = findViewById(R.id.spinLocations);

        Button btnCompute = findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            final TextView txtCost = findViewById(R.id.txtCost);

            @Override
            public void onClick(View v) {
                numberOfAthletes = Integer.parseInt(txtAthletes.getText().toString());
                teamCost = numberOfAthletes * costPerPerson;
                location = spinLocations.getSelectedItem().toString();
                DecimalFormat currency = new DecimalFormat("$###,###");
                txtCost.setText(location + " race team fee is " + currency.format(teamCost));
            }
        });
    }
}
