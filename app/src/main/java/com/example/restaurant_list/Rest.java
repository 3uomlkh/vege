package com.example.restaurant_list;

import java.io.Serializable;

public class Rest implements Serializable {

    public String name;
    public String address;
    public String image;
    public boolean starCheck;

public Rest() {
//    this.name = name;
//    this.address = address;
//    this.image = image;
}

/*    public boolean isStarCheck() {
        return starCheck;
    }

    public void setStarCheck(boolean starCheck) {
        this.starCheck = starCheck;
    }*/

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
