package app.foodie_appoets.com.base;

import android.app.Activity;

import app.foodie_appoets.com.MvpApplication;
import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    public CompositeDisposable compositeDisposable;
    public BasePresenter() {
        compositeDisposable=new CompositeDisposable();
    }
    private V mMvpView;

    @Override
    public Activity activity() {
        return getMvpView().activity();
    }

    public V getMvpView() {
        return mMvpView;
    }

    @Override
    public MvpApplication appContext() {
        return MvpApplication.getInstance();
    }

    @Override
    public void attachView(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
        compositeDisposable.dispose();
        }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

}
