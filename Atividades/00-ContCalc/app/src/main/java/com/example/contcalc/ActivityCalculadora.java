package com.example.contcalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCalculadora extends AppCompatActivity {
    float resultado = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        EditText ediText1 = findViewById(R.id.edtN1);
        EditText ediText2 = findViewById(R.id.edtN2);
        Button btnAdicao = findViewById(R.id.btnAdicao);
        Button btnSubtracao = findViewById(R.id.btnSubtracao);
        Button btnMultiplicacao = findViewById(R.id.btnMultiplicacao);
        Button btnDivisao = findViewById(R.id.btnDivisao);
        TextView tvResult = findViewById(R.id.tvResult);

        //Botão de ação para funcionalidade de adição
        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (existNumber(ediText1.getText().toString(), ediText2.getText().toString())) {
                    resultado = Float.parseFloat(ediText1.getText().toString()) +  Float.parseFloat(ediText2.getText().toString());
                    tvResult.setText(Float.toString(resultado));
                }
            }
        });

        //Botão de ação para funcionalidade de subtracao
        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (existNumber(ediText1.getText().toString(), ediText2.getText().toString())) {
                    resultado = Float.parseFloat(ediText1.getText().toString()) - Float.parseFloat(ediText2.getText().toString());
                    tvResult.setText(Float.toString(resultado));
                }
            }
        });

        //Botão de ação para funcionalidade de multiplicação
        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (existNumber(ediText1.getText().toString(), ediText2.getText().toString())) {
                    resultado = Float.parseFloat(ediText1.getText().toString()) * Float.parseFloat(ediText2.getText().toString());
                    tvResult.setText(Float.toString(resultado));
                }
            }
        });

        //Botão de ação para funcionalidade de Divisão
        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ediText1.getText().toString().equals("0") && ediText2.getText().toString().equals("0")) {
                    tvResult.setText(R.string.undefined);
                } else if (existNumber(ediText1.getText().toString(), ediText2.getText().toString())) {
                    resultado = Float.parseFloat(ediText1.getText().toString()) / Float.parseFloat(ediText2.getText().toString());
                    tvResult.setText(Float.toString(resultado));
                }
            }
        });
    }

    public Boolean existNumber(String n1, String n2) {
        //Função que vai definir se as strings dos campos de EditText estão vazias
        if (n1.length() > 0 && n2.length() > 0) {
            return true;
        }
        //Gera um alerta caso algum campo esteja vazio
        Toast.makeText(getApplicationContext(), "Algum campo está vazio", Toast.LENGTH_SHORT).show();
        return false;
    }
}