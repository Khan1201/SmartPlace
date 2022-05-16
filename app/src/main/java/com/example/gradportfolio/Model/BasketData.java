package com.example.gradportfolio.Model;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class BasketData {

    private String brand_title;
    private String product_name;
    private String product_price;
    private ArrayAdapter<Integer> spinner_adapter;
    private String image_url;
    private Integer spinner_count;

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

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public ArrayAdapter<Integer> getSpinnerAdapter() {
        return spinner_adapter;
    }

    public void setSpinnerAdapter(ArrayAdapter<Integer> spinner_adapter) {
        this.spinner_adapter = spinner_adapter;
    }

}