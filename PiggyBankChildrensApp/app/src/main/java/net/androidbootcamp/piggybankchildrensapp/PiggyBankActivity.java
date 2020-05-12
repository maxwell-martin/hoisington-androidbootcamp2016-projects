package net.androidbootcamp.piggybankchildrensapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class PiggyBankActivity extends AppCompatActivity {
    final double QUARTER = 0.25;
    final double DIME = 0.10;
    final double NICKEL = 0.05;
    final double PENNY = 0.01;
    int quarters;
    int dimes;
    int nickels;
    int pennies;
    double total;
    String choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piggy_bank);

        final EditText etQuarters = findViewById(R.id.etQuarters);
        final EditText etDimes = findViewById(R.id.etDimes);
        final EditText etNickels = findViewById(R.id.etNickels);
        final EditText etPennies = findViewById(R.id.etPennies);
        final Spinner spinChoices = findViewById(R.id.spinChoices);

        Button btnCompute = findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            final TextView txtResults = findViewById(R.id.txtResults);

            @Override
            public void onClick(View v) {
                quarters = Integer.parseInt(etQuarters.getText().toString());
                dimes = Integer.parseInt(etDimes.getText().toString());
                nickels = Integer.parseInt(etNickels.getText().toString());
                pennies = Integer.parseInt(etPennies.getText().toString());

                total = (quarters * QUARTER) + (dimes * DIME) + (nickels * NICKEL) + (pennies * PENNY);

                DecimalFormat currencyFormatter = new DecimalFormat("$###,###.##");

                choice = spinChoices.getSelectedItem().toString();

                txtResults.setText("You are " + choice.toLowerCase() + " " + currencyFormatter.format(total));
            }
        });
    }
}
