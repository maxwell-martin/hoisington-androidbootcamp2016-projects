package net.androidbootcamp.amtraktrainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int boardingHour;
    int boardingMinute;
    int totalTripInMinutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtHour = findViewById(R.id.txtHour);
        final EditText txtMinute = findViewById(R.id.txtMinute);
        final EditText txtTotalTripInMinutes = findViewById(R.id.txtTotalTripInMinutes);

        Button btnCalculateArrivalTime = findViewById(R.id.btnCalculateArrivalTime);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        btnCalculateArrivalTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boardingHour = Integer.parseInt(txtHour.getText().toString());
                boardingMinute = Integer.parseInt(txtMinute.getText().toString());
                totalTripInMinutes = Integer.parseInt(txtTotalTripInMinutes.getText().toString());

                if (boardingHour >= 0 && boardingHour <= 23 && boardingMinute >= 0 && boardingMinute <= 59 && totalTripInMinutes <= 1500) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("boardingHour", boardingHour);
                    editor.putInt("boardingMinute", boardingMinute);
                    editor.putInt("totalTripInMinutes", totalTripInMinutes);
                    editor.commit();
                    startActivity(new Intent(MainActivity.this, ArrivalTimeActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Boarding hour must be" +
                            " between 0-24. Boarding minute must be between 0-59. " +
                            "Total trip time must be <= 1500 minutes.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
