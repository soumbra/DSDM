package com.example.atvplanet;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvSons;
    String[] sons = {"D20 Brutona", "Carreta do bodin", "Gigante Palhenense", "Palio do Frango", "KR som"};
    String[] descricoes = {"A mais tocada", "8 graves de 12P", "O maior de palhense", "Palio do filho do rogerinho", "O maior de Itarema"};
    int [] image = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSons = findViewById(R.id.lv_sons);

        ListViewCustomAdapter customAdapter = new ListViewCustomAdapter(this, sons, descricoes, image);

        lvSons.setAdapter(customAdapter);

        lvSons.setOnItemClickListener(this);

        /*lvSons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Esta view é:" + position+1, Toast.LENGTH_SHORT).show();
            }
        }); */
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Redirecindonando para a tela de " + sons[position], Toast.LENGTH_SHORT).show();
    }

}
