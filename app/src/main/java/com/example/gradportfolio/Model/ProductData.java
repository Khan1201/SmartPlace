package com.example.gradportfolio.Model;

public class ProductData {
    private String id;
    private String url;
    private String brand_name;
    private String product_name;
    private String price;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }

    public String getBrand_name(){
        return brand_name;
    }
    public void setBrand_name(String brand_name){
        this.brand_name = brand_name;
    }

    public String getProduct_name(){
        return product_name;
    }
    public void setProduct_name(String product_name){
        this.product_name = product_name;
    }

    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price = price;
    }

}