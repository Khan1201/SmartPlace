package com.example.gradportfolio.Model;

public class HotdealData1 {
    private String hotdeal1_title;
    private int hotdeal1_image;

    public HotdealData1(String hotdeal1_title, int hotdeal1_image)
    {
        this.hotdeal1_image = hotdeal1_image;
        this.hotdeal1_title = hotdeal1_title;
    }


    public String getHotdeal1_title(){
        return hotdeal1_title;
    }

    public void setHotdeal1_title(String hotdeal1_title1){
        this.hotdeal1_title = hotdeal1_title1;
    }

    public int getHotdeal1_image(){
        return hotdeal1_image;
    }

    public void setHotdeal1_image(int hotdeal1_image){
        this.hotdeal1_image = hotdeal1_image;
    }
}
