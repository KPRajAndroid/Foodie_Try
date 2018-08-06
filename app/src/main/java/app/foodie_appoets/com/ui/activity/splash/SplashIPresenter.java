package app.foodie_appoets.com.ui.activity.splash;

import app.foodie_appoets.com.base.MvpPresenter;

public interface SplashIPresenter<V extends SplashIView> extends MvpPresenter<V> {
    void profile();
}
