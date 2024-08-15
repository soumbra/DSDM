package com.example.ap1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ap1.RecyclerView.Item;
import com.example.ap1.RecyclerView.ItemArrayAdapter;
import com.example.ap1.dao.TarefaDao;
import com.example.ap1.dataBase.AppDatabase;
import com.example.ap1.models.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    RecyclerView lista;
    Button button;
    EditText titulo;
    EditText descricao;
    ArrayList<Item> itemList = new ArrayList<>();
    ItemArrayAdapter itemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = findViewById(R.id.buttonSalvar);
        titulo = findViewById(R.id.editTextTitulo);
        descricao = findViewById(R.id.editTextDescricao);
        itemArrayAdapter = new ItemArrayAdapter(R.layout.activity_item, itemList);

        AppDatabase appDatabase = AppDatabase.getInstance(this);

        TarefaDao tarefaDao = appDatabase.tarefaDao();
        updateRv(tarefaDao);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tituloString = titulo.getText().toString();
                String descricaoString = descricao.getText().toString();

                if (tituloString.isEmpty() || descricaoString.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Há campos não preenchidos", Toast.LENGTH_LONG).show();
                    return;
                }

                Tarefa tarefa = new Tarefa(
                        tituloString,
                        descricaoString
                );

                tarefaDao.insertAll(tarefa);
                updateRv(tarefaDao);

                titulo.setText("");
                descricao.setText("");
                goToMainActivity();
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateRv(TarefaDao tarefaDao) {
        List<Tarefa> tarefas = tarefaDao.getAll();
        itemList.clear();

        for (Tarefa t : tarefas) {
            itemList.add(new Item(t.uid, t.titulo, t.descricao));
        }

        itemArrayAdapter.notifyDataSetChanged();
    }

    public void goToMainActivity() {
        Intent intentMain = new Intent(this, MainActivity.class);
        startActivity(intentMain);
    }
}