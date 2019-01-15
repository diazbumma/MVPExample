package com.diazbumma.mvpexample.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.diazbumma.mvpexample.R;
import com.diazbumma.mvpexample.main.adapters.HeroRecyclerAdapter;
import com.diazbumma.mvpexample.main.models.Hero;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private RecyclerView rvHero;
    private ProgressBar progressBar;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProgressBar();
        initRecyclerView();

        mainPresenter = new MainPresenter(this, new HeroInteractor());
        mainPresenter.requestToShowData();
    }

    public void initProgressBar() {
        progressBar = findViewById(R.id.pb_loading_heroes);
        progressBar.setVisibility(View.INVISIBLE);
    }

    public void initRecyclerView() {
        rvHero = findViewById(R.id.rv_hero);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rvHero.setLayoutManager(layoutManager);
    }

    @Override
    public void showResult(ArrayList<Hero> heroArrayList) {
        HeroRecyclerAdapter adapter = new HeroRecyclerAdapter(MainActivity.this, heroArrayList);
        rvHero.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this,
                "Something went wrong... Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }
}
