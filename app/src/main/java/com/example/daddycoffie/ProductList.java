package com.example.daddycoffie;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    List<product> plist;

    public ProductList(List<product> plist) {
        this.plist = plist;
    }

    public ProductList() {
    }

    public List<product> getPlist() {
        return plist;
    }

    public void setPlist(List<product> plist) {
        this.plist = plist;
    }
}
