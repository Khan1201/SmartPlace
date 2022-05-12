package com.example.gradportfolio.Model;

public class SearchData {
    private String productName;
    private String brand_title;
    private String product_price;
    private String imageUrl;
    public SearchData(String productName, String brand_title, String product_price, String imageUrl)
    {
        this.productName = productName;
        this.brand_title = brand_title;
        this.product_price = product_price;
        this.imageUrl = imageUrl;
    }

    public String getProductName(){
        return productName;
    }
    public String getBrand_title(){
        return brand_title;
    }
    public String getProduct_price(){
        return product_price;
    }
    public String getImageUrl(){
        return imageUrl;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public void setBrand_title(String brand_title){
        this.brand_title = brand_title;
    }

    public void setProduct_price(String product_price){
        this.product_price = product_price;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }




}