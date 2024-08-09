package com.example.ap1.RecyclerView;

public class Item {
    private int uid;
    private String titulo;
    private String descricao;

    public Item(int uid, String titulo, String descricao) {
        this.uid = uid;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getUid() {
        return uid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}