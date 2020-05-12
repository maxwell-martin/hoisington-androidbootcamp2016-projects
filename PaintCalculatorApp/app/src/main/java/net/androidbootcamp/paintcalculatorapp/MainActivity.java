package net.androidbootcamp.paintcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double height;
    double distance;
    double squareFeet;
    double numberOfGallons;
    String paintChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtHeight = findViewById(R.id.txtHeight);
        final EditText txtDistance = findViewById(R.id.txtDistance);
        final Spinner spinPaintColors = findViewById(R.id.spinPaintColors);

        Button btnCompute = findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            final TextView txtGallons = findViewById(R.id.txtGallons);

            @Override
            public void onClick(View v) {
                height = Double.parseDouble(txtHeight.getText().toString());
                distance = Double.parseDouble(txtDistance.getText().toString());
                squareFeet = height * distance;
                numberOfGallons = squareFeet / 250.0;
                paintChoice = spinPaintColors.getSelectedItem().toString();
                DecimalFormat formatter = new DecimalFormat("###.##");
                txtGallons.setText("You need " + formatter.format(numberOfGallons) + " gallons of " + paintChoice.toLowerCase() + " paint.");
            }
        });
    }
}
