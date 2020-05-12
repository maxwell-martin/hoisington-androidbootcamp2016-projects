package net.androidbootcamp.splitthebillapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BillActivity extends AppCompatActivity {
    final double tipPercentage = 0.18;
    double subtotalMealCost;
    int numberOfPeople;
    double tipCost;
    double totalMealCost;
    double costPerPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        final EditText txtBill = findViewById(R.id.txtBill);
        final EditText txtPeople = findViewById(R.id.txtPeople);

        Button btnComputeBill = findViewById(R.id.btnComputeBill);

        btnComputeBill.setOnClickListener(new View.OnClickListener() {
            final TextView txtTipCost = findViewById(R.id.txtTipCost);
            final TextView txtCostPerPerson = findViewById(R.id.txtCostPerPerson);

            @Override
            public void onClick(View v) {
                subtotalMealCost = Double.parseDouble(txtBill.getText().toString());
                numberOfPeople = Integer.parseInt(txtPeople.getText().toString());
                tipCost = subtotalMealCost * tipPercentage;
                totalMealCost = subtotalMealCost + tipCost;
                costPerPerson = totalMealCost / numberOfPeople;
                DecimalFormat currencyFormatter = new DecimalFormat("$###,###.##");
                txtTipCost.setText("The cost of the tip is: " + currencyFormatter.format(tipCost));
                txtCostPerPerson.setText("The cost per person is: " + currencyFormatter.format(costPerPerson));
            }
        });

    }
}
