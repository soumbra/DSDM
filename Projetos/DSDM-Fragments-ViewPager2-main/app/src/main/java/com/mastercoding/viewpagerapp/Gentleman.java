package com.mastercoding.viewpagerapp;

public class Gentleman {
    private int image;
    private String name;
    private String descPersonal;
    private String descProfissional;
    private String descExtra;

    public Gentleman(int image, String name, String descPersonal, String descProfissional, String descExtra) {
        this.image = image;
        this.name = name;
        this.descPersonal = descPersonal;
        this.descProfissional = descProfissional;
        this.descExtra = descExtra;
    }

    public String getName() {
        return name;
    }

    public String getDescPersonal() {
        return descPersonal;
    }

    public String getDescProfissional() {
        return descProfissional;
    }

    public String getDescExtra() {
        return descExtra;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescPersonal(String descPersonal) {
        this.descPersonal = descPersonal;
    }

    public void setDescProfissional(String descProfissional) {
        this.descProfissional = descProfissional;
    }

    public void setDescExtra(String descExtra) {
        this.descExtra = descExtra;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

