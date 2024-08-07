package com.example.usoroomdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.usoroomdatabase.dao.PessoaDao;
import com.example.usoroomdatabase.models.Pessoa;

@Database(entities = {Pessoa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PessoaDao pessoaDao();
}
