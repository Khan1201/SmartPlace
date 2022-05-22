package com.example.gradportfolio.Model;

public class CategoryData {

    String productName;
    String brand_title;
    String product_price;
    String imageId;
    public CategoryData(String productName, String brand_title, String product_price, String imageId)
    {
        this.productName = productName;
        this.brand_title = brand_title;
        this.product_price = product_price;
        this.imageId = imageId;
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
        return imageId;
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

    public void setImageId(String imageId){
        this.imageId = imageId;
    }
}