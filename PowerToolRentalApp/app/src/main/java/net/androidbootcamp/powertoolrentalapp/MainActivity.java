package net.androidbootcamp.powertoolrentalapp;

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
    final double POWER_WASHER_RENT = 55.99;
    final double TILLER_RENT = 68.99;
    int numberOfDays;
    double cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText txtDays = findViewById(R.id.txtDays);
        final RadioButton radPowerWasher = findViewById(R.id.radPowerWasher);

        Button btnCompute = findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            final TextView txtCost = findViewById(R.id.txtCost);

            @Override
            public void onClick(View v) {
                numberOfDays = (txtDays.getText().toString()).isEmpty() ? 0 :
                        Integer.parseInt(txtDays.getText().toString());

                DecimalFormat formatter = new DecimalFormat("$###,###.00");

                if (numberOfDays > 0 && numberOfDays <= 7) {
                    cost = radPowerWasher.isChecked() ? numberOfDays * POWER_WASHER_RENT :
                            numberOfDays * TILLER_RENT;
                    txtCost.setText(formatter.format(cost) + " for " + numberOfDays + " days");
                } else {
                    Toast.makeText(MainActivity.this, "Number of days to rent " +
                            "must be between 1 and 7.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
