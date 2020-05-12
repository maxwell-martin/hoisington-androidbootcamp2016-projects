package net.androidbootcamp.amtraktrainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

public class ArrivalTimeActivity extends AppCompatActivity {
    int boardingHour;
    int boardingMinute;
    int totalTripInMinutes;
    int tripHours;
    int tripMinutes;
    int arrivalHour;
    int arrivalMinute;
    String arrivalTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrival_time);

        TextView txtArrivalTime = findViewById(R.id.txtArrivalTime);
        TextView txtRedEyeArrivalMessage = findViewById(R.id.txtRedEyeArrivalMessage);
        ImageView imgRedEyeArrival = findViewById(R.id.imgRedEyeArrival);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boardingHour = sharedPreferences.getInt("boardingHour", 0);
        boardingMinute = sharedPreferences.getInt("boardingMinute", 0);
        totalTripInMinutes = sharedPreferences.getInt("totalTripInMinutes", 0);

        tripHours = totalTripInMinutes / 60;
        tripMinutes = totalTripInMinutes % 60;

        arrivalHour = boardingHour + tripHours;
        arrivalMinute = boardingMinute + tripMinutes;

        while (arrivalHour > 23) {
            arrivalHour = arrivalHour - 24;
        }

        if (arrivalHour < 10) {
            arrivalTime += ("0" + arrivalHour);
        } else {
            arrivalTime += arrivalHour;
        }

        while (arrivalMinute > 59) {
            arrivalMinute = arrivalMinute - 60;
        }

        if (arrivalMinute < 10) {
            arrivalTime += (":0" + arrivalMinute);
        } else {
            arrivalTime += ":"+ arrivalMinute;
        }

        txtArrivalTime.setText("Arrival Time: " + arrivalTime);

        if (arrivalHour >= 0 && (tripHours + boardingHour > 24)) {
            txtRedEyeArrivalMessage.setText("Red-Eye Arrival");
            imgRedEyeArrival.setImageResource(R.drawable.night);
        } else {
            txtRedEyeArrivalMessage.setText("");
            imgRedEyeArrival.setImageResource(0);
        }
    }
}
