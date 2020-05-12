package net.androidbootcamp.createyourowntabletapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar c = Calendar.getInstance();

    private TextView reservation;

    String strReservation = "";

    DateFormat fmtDate = DateFormat.getDateInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reservation = findViewById(R.id.txtReservation);

        Button btnDate = findViewById(R.id.btnDate);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, d, c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        Button btnTime = findViewById(R.id.btnTime);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this, t, 10, 0,
                        false).show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }
    };

    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        int hour12;

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            reservation.setText("");
            strReservation = "Reservation for " + fmtDate.format(c.getTime()) + " at ";
            if (hourOfDay >= 10 && hourOfDay < 16) {
                switch (hourOfDay) {
                    case 13:
                        hour12 = 1;
                        break;
                    case 14:
                        hour12 = 2;
                        break;
                    case 15:
                        hour12 = 3;
                        break;
                }

                if (minute < 10) {
                    strReservation += hour12 + ":0" + minute;
                } else {
                    strReservation += hour12 + ":" + minute;
                }

                if (hourOfDay >= 12) {
                    strReservation += "pm.";
                } else {
                    strReservation += "am.";
                }

                reservation.setText(strReservation);
            } else {
                Toast.makeText(MainActivity.this, "Paintball reservations only " +
                        "available from 10am and 4pm.", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
