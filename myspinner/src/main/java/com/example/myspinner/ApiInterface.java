package com.example.myspinner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("restaurant.php")
    Call<TestItem>getData();
}
