package com.example.ap1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.ap1.RecyclerView.Item;
import com.example.ap1.RecyclerView.ItemArrayAdapter;
import com.example.ap1.dao.TarefaDao;
import com.example.ap1.dataBase.AppDatabase;
import com.example.ap1.models.Tarefa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView lista;
    Button button;
    ArrayList<Item> itemList = new ArrayList<>();
    ItemArrayAdapter itemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.rv_list);
        button = findViewById(R.id.buttonCriar);

        itemArrayAdapter = new ItemArrayAdapter(R.layout.activity_item, itemList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        lista.setLayoutManager(layoutManager);
        lista.setAdapter(itemArrayAdapter);

        AppDatabase appDatabase = Room.databaseBuilder(this,
                        AppDatabase.class,
                        "db_name")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();

        TarefaDao tarefaDao = appDatabase.tarefaDao();
        updateRv(tarefaDao);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
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

    public void goToSecondActivity() {
        Intent intentSecond = new Intent(this, SecondActivity.class);
        startActivity(intentSecond);
    }
}