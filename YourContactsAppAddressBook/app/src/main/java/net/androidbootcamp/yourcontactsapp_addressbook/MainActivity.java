package net.androidbootcamp.yourcontactsapp_addressbook;

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

        Button btnAndrewJenkins = findViewById(R.id.btnAndrewJenkinsContact);
        Button btnMollyJohnson = findViewById(R.id.btnMollyJohnsonContact);

        btnAndrewJenkins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AndrewJenkinsContact.class));
            }
        });

        btnMollyJohnson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MollyJohnsonContact.class));
            }
        });
    }
}
