package com.example.gradportfolio.Model;

public class MenuList {
    private String Img_Name;
    int ImgId2;


    public MenuList(String Img_Name, int ImgId2)
    {
        this.Img_Name = Img_Name;
        this.ImgId2 = ImgId2;

    }

    public String getImgName(){
        return Img_Name;
    }

    public void setImgName(String imgName){
        this.Img_Name = imgName;
    }

    public int getImgId2(){return ImgId2;}

    public void setImgId2(int imgId2){this.ImgId2 = imgId2;}
    }





