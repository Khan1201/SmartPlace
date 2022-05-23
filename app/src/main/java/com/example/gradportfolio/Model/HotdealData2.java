package com.example.gradportfolio.Model;

public class HotdealData2 {
    private String hotdeal2_title;
    private int hotdeal2_image;

    public HotdealData2(String hotdeal2_title, int hotdeal2_image)
    {
        this.hotdeal2_image = hotdeal2_image;
        this.hotdeal2_title = hotdeal2_title;
    }

    public String getHotdeal2_title(){
        return hotdeal2_title;
    }

    public void setHotdeal2_title(String hotdeal2_title){
        this.hotdeal2_title = hotdeal2_title;
    }

    public int getHotdeal2_image(){
        return hotdeal2_image;
    }

    public void setHotdeal2_image(int hotdeal2_image){
        this.hotdeal2_image = hotdeal2_image;
    }
}
