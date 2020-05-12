package net.androidbootcamp.carwashapp;

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
    final double EXTERIOR_12_PLUS = 8.99;
    final double EXTERIOR_PLUS_12_PLUS = 12.99;
    final double EXTERIOR = 10.99;
    final double EXTERIOR_PLUS = 15.99;
    int numberOfCarWashes;
    double cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText txtNumberOfWashes = findViewById(R.id.txtNumberOfWashes);
        final RadioButton radExteriorOnly = findViewById(R.id.radExteriorOnly);

        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            final TextView txtCost = findViewById(R.id.txtCost);

            @Override
            public void onClick(View v) {
                numberOfCarWashes = (txtNumberOfWashes.getText().toString()).isEmpty() ? 0 :
                        Integer.parseInt(txtNumberOfWashes.getText().toString());

                DecimalFormat formatter = new DecimalFormat("$###,###.00");

                if (numberOfCarWashes > 0) {
                    if (numberOfCarWashes >= 12) {
                        if (radExteriorOnly.isChecked()) {
                            cost = numberOfCarWashes * EXTERIOR_12_PLUS;
                        } else {
                            cost = numberOfCarWashes * EXTERIOR_PLUS_12_PLUS;
                        }
                        txtCost.setText(formatter.format(cost) + " for " + numberOfCarWashes +
                                " washes");
                    } else {
                        Toast.makeText(MainActivity.this, "You must buy 12 washes or" +
                                " more to receive a discount", Toast.LENGTH_LONG).show();
                        if (radExteriorOnly.isChecked()) {
                            cost = numberOfCarWashes * EXTERIOR;
                        } else {
                            cost = numberOfCarWashes * EXTERIOR_PLUS;
                        }
                        txtCost.setText(formatter.format(cost) + " for " + numberOfCarWashes +
                                " washes");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Number of washes must be " +
                            "greater than zero.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
