package com.example.daddycoffie;

import java.util.ArrayList;

public class ProductList {

    ArrayList<product> plist;

    public ProductList(ArrayList<product> plist) {
        this.plist = plist;
    }

    public ProductList() {
    }

    public ArrayList<product> getPlist() {
        return plist;
    }

    public void setPlist(ArrayList<product> plist) {
        this.plist = plist;
    }
}
