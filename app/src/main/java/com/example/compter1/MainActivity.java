package com.example.compter1;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private int counterParacetamol = 0;
    private int counterOmeprazol = 0;

    private TextView textCounterParacetamol;
    private TextView textCounterOmeprazol;
    private RadioGroup radioGroup;
    private Button btnCompter;

    int prid = R.id.menu_nb_paracetamol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


        textCounterParacetamol = findViewById(R.id.text_counter_paracetamol);
        textCounterOmeprazol = findViewById(R.id.text_counter_omeprazol);
        radioGroup = findViewById(R.id.radio_group);
        btnCompter = findViewById(R.id.btn_compter);

        btnCompter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

                    if (selectedRadioButton.getText().equals("Paracétamol")) {
                        counterParacetamol++;
                        textCounterParacetamol.setText("Paracetamol: " + counterParacetamol);
                    } else if (selectedRadioButton.getText().equals("Oméprazole")) {
                        counterOmeprazol++;
                        textCounterOmeprazol.setText("Oméprazole: " + counterOmeprazol);
                    }
                } else {
                    // No radio button selected
                    Toast.makeText(MainActivity.this, "Sélectionnez un médicament", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_nb_paracetamol:
                Toast.makeText(this, "Nombre de Paracétamol: " + counterParacetamol, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_nb_omeprazole:
                Toast.makeText(this, "Nombre d'Oméprazole: " + counterOmeprazol, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_quitter:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.menu_nb_paracetamol) {

            Toast.makeText(this, "Nombre de Paracétamol: " + counterParacetamol, Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.menu_nb_omeprazole) {

            Toast.makeText(this, "Nombre d'Oméprazole: " + counterOmeprazol, Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.menu_quitter) {

            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}



