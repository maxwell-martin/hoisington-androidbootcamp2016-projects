package net.androidbootcamp.thelatestmusicscene;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSundance2020 = findViewById(R.id.btnSundance2020);
        Button btnDiddyGrammys = findViewById(R.id.btnDiddyGrammys);

        btnSundance2020.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Sundance.class));
            }
        });

        btnDiddyGrammys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Diddy.class));
            }
        });
    }
}
