package com.example.projectrecycle.recyclerview;

public class Item {
    private String name;
    private String descricao;
    private int image;

    public Item(String n, String descricao, int image) {
        this.name = n;
        this.descricao = descricao;
        this.image = image;
    }
    public String getName() {
        return name;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
