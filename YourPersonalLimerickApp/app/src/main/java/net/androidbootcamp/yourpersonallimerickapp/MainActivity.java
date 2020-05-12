package net.androidbootcamp.yourpersonallimerickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String city;
    String occupation;
    int number;
    String actionVerb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtCity = findViewById(R.id.txtCity);
        final EditText txtOccupation = findViewById(R.id.txtOccupation);
        final EditText txtNumber = findViewById(R.id.txtNumber);
        final EditText txtActionVerb = findViewById(R.id.txtActionVerb);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Button btnGenerateLimerick = findViewById(R.id.btnGenerateLimerick);

        btnGenerateLimerick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city = txtCity.getText().toString();
                occupation = txtOccupation.getText().toString();
                number = Integer.parseInt(txtNumber.getText().toString());
                actionVerb = txtActionVerb.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("city", city);
                editor.putString("occupation", occupation);
                editor.putInt("number", number);
                editor.putString("actionVerb", actionVerb);
                editor.commit();

                startActivity(new Intent(MainActivity.this, LimerickActivity.class));
            }
        });
    }
}
