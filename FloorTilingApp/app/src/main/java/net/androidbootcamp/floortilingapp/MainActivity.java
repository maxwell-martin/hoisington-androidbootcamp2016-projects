package net.androidbootcamp.floortilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    final double TILE_12IN = 12.0;
    final double TILE_18IN = 18.0;
    int length;
    int width;
    double numberOfTiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtLength = findViewById(R.id.txtLength);
        final EditText txtWidth = findViewById(R.id.txtWidth);
        final RadioButton rad12By12 = findViewById(R.id.rad12By12);

        Button btnCompute = findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            final TextView txtNumberOfTiles = findViewById(R.id.txtNumberOfTiles);

            @Override
            public void onClick(View v) {
                length = txtLength.getText().toString().isEmpty() ? 0 :
                        Integer.parseInt(txtLength.getText().toString());
                width = txtWidth.getText().toString().isEmpty() ? 0 :
                        Integer.parseInt(txtWidth.getText().toString());

                int roomAreaSquareInches = length * width * 12;

                if (rad12By12.isChecked()) {
                    numberOfTiles = roomAreaSquareInches / (TILE_12IN * TILE_12IN);
                } else {
                    numberOfTiles = roomAreaSquareInches / (TILE_18IN * TILE_18IN);
                }

                DecimalFormat formatter = new DecimalFormat("#");
                formatter.setRoundingMode(RoundingMode.UP);

                txtNumberOfTiles.setText("Number of tiles needed: " + formatter.format(numberOfTiles));
            }
        });
    }
}
