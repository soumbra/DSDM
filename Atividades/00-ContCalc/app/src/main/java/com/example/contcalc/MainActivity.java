package com.example.contcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

//todos as telas do implementadas no xml são baseadas na tela do pixel 3
public class MainActivity extends AppCompatActivity {
    int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCont = findViewById(R.id.btnCont);
        Button btnCalc = findViewById(R.id.btnCalc);
        EditText etValue = findViewById(R.id.etValue);

        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se o campo estiver vazio cria um alerta e retorna a função.
                if (etValue.length() == 0) {
                    Toast.makeText(getApplicationContext(), "O campo está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                String valueTotal = etValue.getText().toString();
                cont = Integer.parseInt(valueTotal);
                goToSecondActivity(cont);
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTreeActivity();
            }
        });

    }
    public void goToSecondActivity(int value) {
        Intent btnCont = new Intent(this, ActivityContador.class);
        btnCont.putExtra("Valor", value);
        startActivity(btnCont);
    }

    public void goToTreeActivity() {
        Intent intentTree = new Intent(this, ActivityCalculadora.class);
        startActivity(intentTree);
    }

}