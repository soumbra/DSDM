package com.example.usoroomdatabase;

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
    ArrayList<Item> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.rv_itens);

        FloatingActionButton button = findViewById(R.id.fab_add);

        AppDatabase appDatabase = Room.databaseBuilder(this,
                        AppDatabase.class,
                        "db_name")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();

        PessoaDao pessoaDao = appDatabase.pessoaDao();

        List<Pessoa> pessoas = pessoaDao.getAll();
        for (Pessoa p : pessoas) {
            itemList.add(new Item(p.nome, p.curso, p.idade));
        }

        button.setOnClickListener(new View.OnClickListener() {
            EditText nome = findViewById(R.id.editTextNome);
            EditText curso = findViewById(R.id.editTextCurso);
            EditText idade =  findViewById(R.id.editTextIdade);

            @Override
            public void onClick(View v) {
                String textValue = idade.getText().toString();
                int valor = Integer.parseInt(textValue);
                Pessoa person = new Pessoa(
                        nome.getText().toString(),
                        curso.getText().toString(),
                        valor
                );

                pessoaDao.insertAll(person);
                itemList.add(new Item(person.nome, person.curso, person.idade));
            }
        });

        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.activity_item, itemList);
        lista = (RecyclerView) findViewById(R.id.rv_itens);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        lista.setLayoutManager(layoutManager);

        swipeToDelete(pessoaDao, itemArrayAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        lista.addItemDecoration(dividerItemDecoration);
        lista.setAdapter(itemArrayAdapter);
    }

    private void swipeToDelete(PessoaDao pessoaDao, ItemArrayAdapter itemArrayAdapter) {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Item item = itemList.get(position);

                Pessoa pessoa = new Pessoa(item.getNome(), item.getCurso(), item.getIdade());
                pessoaDao.delete(pessoa);

                itemList.remove(position);
                itemArrayAdapter.notifyItemRemoved(position);
                //itemList.remove(position);
            }
        }).attachToRecyclerView(lista);
    }
}