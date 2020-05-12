package net.androidbootcamp.finaltouchautodetailingtabletapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar c = Calendar.getInstance();

    private CheckBox chkPolish;
    private CheckBox chkClean;
    private CheckBox chkPaint;
    private CheckBox chkFix;
    private TextView reservation;

    private static final double POLISH = 100.0;
    private static final double CLEAN = 50.0;
    private static final double PAINT = 250.0;
    private static final double FIX = 500.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkPolish = findViewById(R.id.chkPolish);
        chkClean = findViewById(R.id.chkClean);
        chkPaint = findViewById(R.id.chkPaint);
        chkFix = findViewById(R.id.chkFix);

        reservation = findViewById(R.id.txtReservation);

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
        DecimalFormat currencyFormatter = new DecimalFormat("$###,###,##0.00");
        double totalCost;

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            totalCost = 0.0;

            if (chkPolish.isChecked()) {
                totalCost += POLISH;
            }
            if (chkClean.isChecked()) {
                totalCost += CLEAN;
            }
            if (chkPaint.isChecked()) {
                totalCost += PAINT;
            }
            if (chkFix.isChecked()) {
                totalCost += FIX;
            }

            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            reservation.setText("Reservation set for " + fmtDate.format(c.getTime()) +
                    " - Total cost will be: " + currencyFormatter.format(totalCost));
        }
    };
}
