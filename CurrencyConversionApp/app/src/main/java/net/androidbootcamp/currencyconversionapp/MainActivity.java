package net.androidbootcamp.currencyconversionapp;

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
    final double EURO = 0.91366;
    final double MEX_PESO = 18.7741;
    final double CAN_DOLLAR = 1.33073;
    double usaDollars;
    double convertedCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText txtUsaDollars = findViewById(R.id.txtUsaDollars);
        final RadioButton radEuros = findViewById(R.id.radEuros);
        final RadioButton radMexPesos = findViewById(R.id.radMexPesos);

        Button btnConvert = findViewById(R.id.btnConvert);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            final TextView txtConvertedCurrency = findViewById(R.id.txtConvertedCurrency);

            @Override
            public void onClick(View v) {
                usaDollars = txtUsaDollars.getText().toString().isEmpty() ? 0.0 :
                        Double.parseDouble(txtUsaDollars.getText().toString());

                if (usaDollars > 0 && usaDollars < 100000) {
                    if (radEuros.isChecked()) {
                        convertedCurrency = usaDollars * EURO;
                    } else if (radMexPesos.isChecked()) {
                        convertedCurrency = usaDollars * MEX_PESO;
                    } else {
                        convertedCurrency = usaDollars * CAN_DOLLAR;
                    }

                    DecimalFormat formatter = new DecimalFormat("0.00");

                    txtConvertedCurrency.setText("Converted currency: " +
                            formatter.format(convertedCurrency));
                } else {
                    Toast.makeText(MainActivity.this, "USA dollars must be greater " +
                            "than zero and less than $100,000", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
