package com.example.gradportfolio.Model;

import android.widget.ArrayAdapter;

import java.util.List;

public class BasketData {

    private String brand_title;
    private String product_name;
    private String product_price;
    private Integer[] product_quantity;
    private ArrayAdapter<Integer> spinner_adapter;
    private int imageId;

    public String getBrandTitle() {
        return brand_title;
    }

    public void setBrandTitle(String brand_title) {
        this.brand_title = brand_title;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public String getProductPrice() {
        return product_price;
    }

    public void setProductPrice(String product_price) {
        this.product_price = product_price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public ArrayAdapter<Integer> getSpinnerAdapter() {
        return spinner_adapter;
    }

    public void setSpinnerAdapter(ArrayAdapter<Integer> spinner_adapter) {
        this.spinner_adapter = spinner_adapter;
    }

}