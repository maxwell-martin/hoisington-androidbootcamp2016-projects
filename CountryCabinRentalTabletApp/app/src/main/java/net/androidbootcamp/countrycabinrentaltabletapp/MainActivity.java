package net.androidbootcamp.countrycabinrentaltabletapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar c = Calendar.getInstance();
    private RadioButton radCabinMontana;
    private TextView rental;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radCabinMontana = findViewById(R.id.radCabinMontana);
        rental = findViewById(R.id.txtRental);

        Button btnDate = findViewById(R.id.btnDate);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, d, c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        DateFormat fmtDate = DateFormat.getDateInstance();

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String rentalInformation = "Cabin rental for ";

            if (radCabinMontana.isChecked()) {
                rentalInformation += "Montana: ";
            } else {
                rentalInformation += "Minnesota: ";
            }

            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            rentalInformation += fmtDate.format(c.getTime());

            c.add(Calendar.DAY_OF_MONTH, 3);

            rental.setText(rentalInformation + " - " + fmtDate.format(c.getTime()));
        }
    };
}
