package com.mirea.kt.practica2_10;

public class Telephone {
    private String model;
    private String serialnumber;
    private int price;

    public Telephone(String model, String serialnumber, int price) {

        this.model = model;
        this.serialnumber = serialnumber;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setmodel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }
    public String getSerialNumber() {
        return serialnumber;
    }
}
