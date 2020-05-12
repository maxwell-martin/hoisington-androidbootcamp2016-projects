package net.androidbootcamp.catalinaislandboatexpressapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int ticketCost = 34;
    int numTickets;
    int totalCost;
    String trip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtTickets = findViewById(R.id.txtTickets);
        final Spinner spinTrips = findViewById(R.id.spinTrips);

        Button btnCompute = findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            final TextView txtCost = findViewById(R.id.txtCost);

            @Override
            public void onClick(View v) {
                numTickets = Integer.parseInt(txtTickets.getText().toString());
                totalCost = numTickets * ticketCost;
                trip = spinTrips.getSelectedItem().toString();
                txtCost.setText("One Way Trip " + trip + " - $" + totalCost);
            }
        });
    }
}
