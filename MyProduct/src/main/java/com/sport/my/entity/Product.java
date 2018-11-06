package com.sport.my.entity;

/**
 * Created by sergii on 27.10.18.
 */
public class Product {

    public static final int UNDEFINED = -1;

    private int code;
    private String name;
    private float price;

    public Product(String name, float price) {
        this(UNDEFINED, name, price);
    }

    public Product(int code, String name, float price) {
        setCode(code);
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "{" + code + ":" + name + ":" + price + "}";
    }
}
