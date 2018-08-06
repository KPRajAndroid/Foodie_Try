package app.foodie_appoets.com.base;

import android.app.Activity;

import app.foodie_appoets.com.MvpApplication;

public interface MvpPresenter<V extends MvpView> {
    Activity activity();
    MvpApplication appContext();
    void attachView(V mvpView);

    void detachView();
}
