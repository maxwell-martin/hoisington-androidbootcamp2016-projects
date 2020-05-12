package net.androidbootcamp.wildgingerdinnerydeliverytabletapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {
    private TextView reservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reservation = findViewById(R.id.txtReservation);

        Button btnTime = findViewById(R.id.btnTime);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this, t, 17, 0,
                        false).show();
            }
        });
    }

    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            reservation.setText("");
            if (hourOfDay >= 17 && hourOfDay < 23) {
                switch (hourOfDay) {
                    case 17:
                        hourOfDay = 5;
                        break;
                    case 18:
                        hourOfDay = 6;
                        break;
                    case 19:
                        hourOfDay = 7;
                        break;
                    case 20:
                        hourOfDay = 8;
                        break;
                    case 21:
                        hourOfDay = 9;
                        break;
                    case 22:
                        hourOfDay = 10;
                        break;
                }

                if (minute < 10) {
                    reservation.setText("Delivery scheduled for " + hourOfDay + ":0" + minute + "pm.");
                } else {
                    reservation.setText("Delivery scheduled for " + hourOfDay + ":" + minute + "pm.");
                }
            } else {
                Toast.makeText(MainActivity.this, "Delivery only available between" +
                        " 5pm and 11pm.", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
