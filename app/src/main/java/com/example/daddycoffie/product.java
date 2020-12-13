package com.example.daddycoffie;

public class product {

    private Integer id;

    private String img;

    private double price;

    private String pname;

    private String description;

    public product(Integer id, String img, double price, String pname, String description) {
        this.id = id;
        this.img = img;
        this.price = price;
        this.pname = pname;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
