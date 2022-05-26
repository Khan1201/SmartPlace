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
    private String details;
    private String image_url2;
    private String image_url3;
    private String image_url4;
    private String purchase_url;

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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImageUrl2() {
        return image_url2;
    }

    public void setImageUrl2(String image_url2) {
        this.image_url2 = image_url2;
    }

    public String getImageUrl3() {
        return image_url3;
    }

    public void setImageUrl3(String image_url3) {
        this.image_url3 = image_url3;
    }

    public String getImageUrl4() {
        return image_url4;
    }

    public void setImageUrl4(String image_url4) {
        this.image_url4 = image_url4;
    }

    public String getPurchaseUrl() {
        return purchase_url;
    }

    public void setPurchaseUrl(String purchase_url) {
        this.purchase_url = purchase_url;
    }

}