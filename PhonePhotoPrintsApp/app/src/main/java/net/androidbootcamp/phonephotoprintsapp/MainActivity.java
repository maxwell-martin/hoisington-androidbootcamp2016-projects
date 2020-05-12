package net.androidbootcamp.phonephotoprintsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    final double FOUR_BY_SIX_COST = 0.19;
    final double FIVE_BY_SEVEN_COST = 0.49;
    final double EIGHT_BY_TEN_COST = 0.79;
    int numberOfPrints;
    double costOfPrints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText txtNumberOfPrints = findViewById(R.id.txtNumberOfPrints);
        final RadioButton radFourBySix = findViewById(R.id.radFourBySix);
        final RadioButton radFiveBySeven = findViewById(R.id.radFiveBySeven);
        // Not technically needed.
        // final RadioButton radEightByTen = findViewById(R.id.radEightByTen);

        Button btnOrder = findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            final TextView txtCost = findViewById(R.id.txtCost);

            @Override
            public void onClick(View v) {
                numberOfPrints = (txtNumberOfPrints.getText().toString()).isEmpty() ? 0 :
                        Integer.parseInt(txtNumberOfPrints.getText().toString());

                DecimalFormat formatter = new DecimalFormat("$###,###.00");

                if (numberOfPrints <= 50 && numberOfPrints > 0) {
                    if (radFourBySix.isChecked()) {
                        costOfPrints = numberOfPrints * FOUR_BY_SIX_COST;
                        txtCost.setText("The order cost is " + formatter.format(costOfPrints));
                    } else if (radFiveBySeven.isChecked()) {
                        costOfPrints = numberOfPrints * FIVE_BY_SEVEN_COST;
                        txtCost.setText("The order cost is " + formatter.format(costOfPrints));
                    } else {
                        costOfPrints = numberOfPrints * EIGHT_BY_TEN_COST;
                        txtCost.setText("The order cost is " + formatter.format(costOfPrints));
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Number of prints must be" +
                            " greater than zero and less than 51.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
