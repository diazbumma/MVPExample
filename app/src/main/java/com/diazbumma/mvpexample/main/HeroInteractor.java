package com.diazbumma.mvpexample.main;

import android.util.Log;

import com.diazbumma.mvpexample.main.models.Hero;
import com.diazbumma.mvpexample.networks.RetrofitInstance;
import com.diazbumma.mvpexample.networks.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroInteractor implements MainContract.HeroInteractor {

    @Override
    public void getHeroArrayList(final OnFinishListener onFinishListener) {

        Service service = RetrofitInstance.getRetrofit().create(Service.class);
        Call<ArrayList<Hero>> call = service.getHeroes();

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ArrayList<Hero>>() {
            @Override
            public void onResponse(Call<ArrayList<Hero>> call, Response<ArrayList<Hero>> response) {
                onFinishListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Hero>> call, Throwable t) {
                onFinishListener.onFailure(t);
            }
        });
    }
}
