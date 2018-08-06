package app.foodie_appoets.com.ui.activity.splash;

import app.foodie_appoets.com.base.BasePresenter;
import app.foodie_appoets.com.data.network.APIClient;
import app.foodie_appoets.com.data.network.models.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter<V extends SplashIView> extends BasePresenter<V> implements SplashIPresenter<V> {
    @Override
    public void profile() {
        Observable modelObservable = APIClient.getAPIClient().profile();
        modelObservable.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(trendsResponse -> getMvpView().onSuccess((User) trendsResponse),
                        throwable -> getMvpView().onError((Throwable) throwable));
    }
}
