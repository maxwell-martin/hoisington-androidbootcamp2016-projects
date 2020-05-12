package net.androidbootcamp.bodymassindexbmicalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int weight;
    int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtWeight = findViewById(R.id.txtWeight);
        final EditText txtHeight = findViewById(R.id.txtHeight);

        Button btnComputeBmi = findViewById(R.id.btnComputeBmi);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        btnComputeBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = Integer.parseInt(txtWeight.getText().toString());
                height = Integer.parseInt(txtHeight.getText().toString());

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("weight", weight);
                editor.putInt("height", height);
                editor.commit();

                startActivity(new Intent(MainActivity.this, BmiActivity.class));

            }
        });
    }
}
