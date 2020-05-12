package net.androidbootcamp.averageincometaxbycountryapp;

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
    final double CHINA_TAX_RATE = 0.25;
    final double GERMANY_TAX_RATE = 0.32;
    final double SWEDEN_TAX_RATE = 0.34;
    final double USA_TAX_RATE = 0.18;
    double taxableIncome;
    double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtTaxableIncome = findViewById(R.id.txtTaxableIncome);
        final RadioButton radChina = findViewById(R.id.radChina);
        final RadioButton radGermany = findViewById(R.id.radGermany);
        final RadioButton radSweden = findViewById(R.id.radSweden);

        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            final TextView txtTax = findViewById(R.id.txtTax);

            @Override
            public void onClick(View v) {
                taxableIncome = txtTaxableIncome.getText().toString().isEmpty() ? 0.0 :
                        Double.parseDouble(txtTaxableIncome.getText().toString());

                if (taxableIncome > 0) {
                    if (radChina.isChecked()) {
                        tax = taxableIncome * CHINA_TAX_RATE;
                    } else if (radGermany.isChecked()) {
                        tax = taxableIncome * GERMANY_TAX_RATE;
                    } else if (radSweden.isChecked()) {
                        tax = taxableIncome * SWEDEN_TAX_RATE;
                    } else {
                        tax = taxableIncome * USA_TAX_RATE;
                    }

                    DecimalFormat formatter = new DecimalFormat("0.00");

                    txtTax.setText("Tax is: " + formatter.format(tax));
                } else {
                    Toast.makeText(MainActivity.this, "Taxable income must be " +
                            "greater than 0.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
