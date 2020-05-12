package net.androidbootcamp.relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int truckSize;
    double miles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtTruckSize = findViewById(R.id.txtTruckSize);
        final EditText txtMiles = findViewById(R.id.txtMiles);

        Button btnCalculateCost = findViewById(R.id.btnCalculateCost);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        btnCalculateCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                truckSize = Integer.parseInt(txtTruckSize.getText().toString());
                miles = Double.parseDouble(txtMiles.getText().toString());

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("truckSize", truckSize);
                editor.putFloat("miles", (float)miles);
                editor.commit();

                startActivity(new Intent(MainActivity.this, RentalActivity.class));
            }
        });
    }
}
