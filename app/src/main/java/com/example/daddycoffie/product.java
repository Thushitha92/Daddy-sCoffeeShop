package com.example.daddycoffie;

public class product {

    private String name;
    private String img;
    private double price;
    private int proId;
    private  String desc;

    public product(String name, String img, double price, int proId, String desc) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.proId = proId;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
