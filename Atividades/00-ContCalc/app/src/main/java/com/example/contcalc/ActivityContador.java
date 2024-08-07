package com.example.contcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityContador extends AppCompatActivity {
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        Button btnAumentar = findViewById(R.id.btnAumentar);

        Intent dado_enviado_para_essa_activity = getIntent();
        contador = dado_enviado_para_essa_activity.getIntExtra("Valor", 0);
        TextView tv_shareddata = findViewById(R.id.tvContadorSecond);
        tv_shareddata.setText(String.valueOf(contador));

        btnAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tudo que eu quero fazer aqui dentro.
                contador++;
                tv_shareddata.setText(Integer.toString(contador));
            }
        });
    }

}