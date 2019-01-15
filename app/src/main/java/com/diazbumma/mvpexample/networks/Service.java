package com.diazbumma.mvpexample.networks;

import com.diazbumma.mvpexample.main.models.Hero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("marvel/")
    Call<ArrayList<Hero>> getHeroes();
}
