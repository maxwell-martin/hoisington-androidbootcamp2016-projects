package net.androidbootcamp.marathonraceapp;

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
    int hours;
    int minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtHours = findViewById(R.id.txtHours);
        final EditText txtMinutes = findViewById(R.id.txtMinutes);

        Button btnCalculateAverageMileTime = findViewById(R.id.btnCalculateAverageMileTime);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        btnCalculateAverageMileTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hours = Integer.parseInt(txtHours.getText().toString());
                minutes = Integer.parseInt(txtMinutes.getText().toString());

                int totalTimeInMinutes = 60 * hours + minutes;

                if (totalTimeInMinutes <= 600 && minutes <= 59) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("totalMinutes", totalTimeInMinutes);
                    editor.commit();
                    startActivity(new Intent(MainActivity.this, ResultsActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Total time cannot be greater" +
                            " than 10 hours, and minutes must be <= 59.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
