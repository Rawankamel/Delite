package com.fci.delite.Model;

public class catagory {

    private String nameOfCat;
    private String imageOfCat;


    public catagory() {
    }

    public catagory(String nameOfCat, String imageOfCat) {
        this.nameOfCat = nameOfCat;
        this.imageOfCat = imageOfCat;
    }

    public String getNameOfCat() {
        return nameOfCat;
    }

    public void setNameOfCat(String nameOfCat) {
        this.nameOfCat = nameOfCat;
    }

    public String getImageOfCat() {
        return imageOfCat;
    }

    public void setImageOfCat(String imageOfCat) {
        this.imageOfCat = imageOfCat;
    }
}