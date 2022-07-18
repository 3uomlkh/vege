package com.example.myspinner;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TestItem {
    @SerializedName("restaurant")
    public List<Data> restaurant;

    @Override
    public String toString(){
        return "TestItem{" +
                "restaurant=" + restaurant +
                '}';
    }
}
