package net.androidbootcamp.techgadgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MonitorStandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_stand);

        Button btnMoreInformation = findViewById(R.id.btnMoreInformation);

        btnMoreInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.amazon.com/" +
                                "North-Bayou-Monitor-Computer-Screens/dp/B01EHQL3LW")));
            }
        });
    }
}
