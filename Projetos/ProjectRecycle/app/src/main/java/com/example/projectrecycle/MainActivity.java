package com.example.projectrecycle;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectrecycle.recyclerview.Item;
import com.example.projectrecycle.recyclerview.ItemArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvBinga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBinga = findViewById(R.id.rvBinga);

        ArrayList <Item> itemList = new ArrayList<>();
        itemList.add(new Item("Arroz", "EX: Tio Binga e 12/8rooz", R.drawable.arroz));
        itemList.add(new Item("Carnes Vermelhas", "EX: Maminha, Lagarto, Carne de Sol", R.drawable.carne));
        itemList.add(new Item("Refrigerantes", "EX: Coca, Guaraná, Fanta, Tubaina", R.drawable.refri));
        itemList.add(new Item("Carnes Brancas", "EX: Frango, Borco, Peixe", R.drawable.frango));
        itemList.add(new Item("Farinhas", "EX: Amarela, Branca", R.drawable.farinha));
        itemList.add(new Item("+18", "EX: Montilla, BlackWhite, Colonial, CelularSport", R.drawable.agua));
        itemList.add(new Item("Variados", "EX: Caderno, Caderneta, Lapis, Borracha", R.drawable.caderno));
        itemList.add(new Item("Salgadinhos", "EX: Fandango, Cheetos, Cebolitos", R.drawable.salgadinhos));
        itemList.add(new Item("Lacticíneos", "EX: Leite, Queijo, Ovo", R.drawable.leite));
        itemList.add(new Item("Cozinha", "EX: Panelas, Tampas, Frigideiras", R.drawable.panela));
        itemList.add(new Item("Automovéis", "EX: Carro, Moto, Barco", R.drawable.carro));

        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.list_item, itemList);
        rvBinga = (RecyclerView) findViewById(R.id.rvBinga);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvBinga.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        rvBinga.addItemDecoration(dividerItemDecoration);

        rvBinga.setAdapter(itemArrayAdapter);
    }
}