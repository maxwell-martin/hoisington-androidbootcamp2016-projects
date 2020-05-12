package net.androidbootcamp.medicalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText txtWeight = findViewById(R.id.txtWeight);
        final RadioButton radLbToKilo = findViewById(R.id.radLbToKilo);
        final RadioButton radKiloToLb = findViewById(R.id.radKiloToLb);
        final TextView txtResult = findViewById(R.id.txtResult);

        Button btnConvert = findViewById(R.id.btnConvert);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightEntered = (txtWeight.getText().toString()).isEmpty() ? 0.0 : Double.parseDouble(txtWeight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");

                if (radLbToKilo.isChecked()) {
                    if (weightEntered <= 500 && weightEntered > 0) {
                        convertedWeight = weightEntered / conversionRate;
                        txtResult.setText(tenth.format(convertedWeight) + " kilograms");
                    } else {
                        Toast.makeText(MainActivity.this, "Pounds must be less than 500 and greater than 0", Toast.LENGTH_LONG).show();
                    }
                }

                if (radKiloToLb.isChecked()) {
                    if (weightEntered <= 225 && weightEntered > 0) {
                        convertedWeight = weightEntered * conversionRate;
                        txtResult.setText(tenth.format(convertedWeight) + " pounds");
                    } else {
                        Toast.makeText(MainActivity.this, "Kilograms must be less than 225 and greater than 0", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
