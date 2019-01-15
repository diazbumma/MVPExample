package com.diazbumma.mvpexample.main;

import com.diazbumma.mvpexample.main.models.Hero;

import java.util.ArrayList;

public class MainPresenter implements
        MainContract.Presenter,
        MainContract.HeroInteractor.OnFinishListener{

    private MainContract.View mainView;
    private MainContract.HeroInteractor heroInteractor;

    public MainPresenter(
            MainContract.View mainView,
            MainContract.HeroInteractor heroInteractor) {
        this.mainView = mainView;
        this.heroInteractor = heroInteractor;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void requestToShowData() {
        if (mainView != null) {
            mainView.showProgress();
        }
        heroInteractor.getHeroArrayList(this);
    }

    @Override
    public void onFinished(ArrayList<Hero> heroArrayList) {
        if (mainView != null) {
            mainView.showResult(heroArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if (mainView != null) {
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
