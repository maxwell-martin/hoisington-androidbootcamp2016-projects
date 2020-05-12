package net.androidbootcamp.homemortgageinterestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    double monthlyPayment;
    int years;
    int principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtMonthlyPayment = findViewById(R.id.txtMonthlyPayment);
        final EditText txtNumberOfYears = findViewById(R.id.txtNumberOfYears);
        final EditText txtPrincipal = findViewById(R.id.txtPrincipal);

        Button btnComputeInterest = findViewById(R.id.btnComputeInterest);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        btnComputeInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText().toString());
                years = Integer.parseInt(txtNumberOfYears.getText().toString());
                principal = Integer.parseInt(txtPrincipal.getText().toString());

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("monthlyPayment", (float)monthlyPayment);
                editor.putInt("years", years);
                editor.putInt("principal", principal);
                editor.commit();

                startActivity(new Intent(MainActivity.this, InterestActivity.class));
            }
        });
    }
}
