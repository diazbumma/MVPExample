package com.diazbumma.mvpexample.main;

import com.diazbumma.mvpexample.main.models.Hero;

import java.util.ArrayList;

public interface MainContract {

    interface Presenter {

        void onDestroy();

        void requestToShowData();
    }

    interface View {

        void showResult(ArrayList<Hero> heroArrayList);

        void onResponseFailure(Throwable throwable);

        void showProgress();

        void hideProgress();
    }

    interface HeroInteractor {

        interface OnFinishListener {
            void onFinished(ArrayList<Hero> heroArrayList);
            void onFailure(Throwable t);
        }

        void getHeroArrayList(OnFinishListener onFinishListener);
    }
}
