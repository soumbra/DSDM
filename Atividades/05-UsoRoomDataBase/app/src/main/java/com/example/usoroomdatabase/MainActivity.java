package com.example.usoroomdatabase;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.usoroomdatabase.RecyclerView.Item;
import com.example.usoroomdatabase.RecyclerView.ItemArrayAdapter;
import com.example.usoroomdatabase.dao.PessoaDao;
import com.example.usoroomdatabase.database.AppDatabase;
import com.example.usoroomdatabase.models.Pessoa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView lista;
    FloatingActionButton button;
    EditText nome;
    EditText curso;
    EditText idade;
    ArrayList<Item> itemList = new ArrayList<>();
    ItemArrayAdapter itemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.rv_itens);
        button = findViewById(R.id.fab_add);
        nome = findViewById(R.id.editTextNome);
        curso = findViewById(R.id.editTextCurso);
        idade =  findViewById(R.id.editTextIdade);
        itemArrayAdapter = new ItemArrayAdapter(R.layout.activity_item, itemList);

        //lista = (RecyclerView) findViewById(R.id.rv_itens);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        lista.setLayoutManager(layoutManager);
        lista.setAdapter(itemArrayAdapter);

        AppDatabase appDatabase = Room.databaseBuilder(this,
                        AppDatabase.class,
                        "db_name")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();

        PessoaDao pessoaDao = appDatabase.pessoaDao();

        updateRv(pessoaDao);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                String cursoString = curso.getText().toString();
                String textValue = idade.getText().toString();


                if (nomeString.isEmpty() || cursoString.isEmpty() || textValue.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Há campos não preenchidos", Toast.LENGTH_LONG).show();
                    return;
                }

                int valorIdade = Integer.parseInt(textValue);

                Pessoa person = new Pessoa(
                        nomeString,
                        cursoString,
                        valorIdade
                );
                pessoaDao.insertAll(person);
                updateRv(pessoaDao);

                nome.setText("");
                curso.setText("");
                idade.setText("");
            }
        });

        swipeToDelete(pessoaDao, itemArrayAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        lista.addItemDecoration(dividerItemDecoration);
    }

    private void swipeToDelete(PessoaDao pessoaDao, ItemArrayAdapter itemArrayAdapter) {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Item item = itemList.get(position);

                Pessoa pessoa = new Pessoa(item.getNome(), item.getCurso(), item.getIdade());
                pessoa.uid = item.getUid();
                pessoaDao.delete(pessoa);

                updateRv(pessoaDao);

                //itemList.remove(position);
            }
        }).attachToRecyclerView(lista);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void updateRv(PessoaDao pessoaDao) {
        List<Pessoa> pessoas = pessoaDao.getAll();
        itemList.clear();

        for (Pessoa p : pessoas) {
            itemList.add(new Item(p.uid, p.nome, p.curso, p.idade));
        }

        itemArrayAdapter.notifyDataSetChanged();
    }
}