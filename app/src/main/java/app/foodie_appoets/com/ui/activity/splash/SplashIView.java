package app.foodie_appoets.com.ui.activity.splash;

import app.foodie_appoets.com.base.MvpView;
import app.foodie_appoets.com.data.network.models.User;

public interface SplashIView extends MvpView {
    void onSuccess(User user);
    void onError(Throwable e);
}
