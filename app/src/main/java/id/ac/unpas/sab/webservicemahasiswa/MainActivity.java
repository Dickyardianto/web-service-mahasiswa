package id.ac.unpas.sab.webservicemahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button inputData, tampilData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputData = findViewById(R.id.btn_input_data);
        tampilData = findViewById(R.id.btn_tampil_data);

        inputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iInput = new Intent(MainActivity.this, InputDataMhsActivity.class);
                startActivity(iInput);
            }
        });

        tampilData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTampil = new Intent(MainActivity.this, TampilDataMhsActivity.class);
                startActivity(iTampil);
            }
        });

    }
}
