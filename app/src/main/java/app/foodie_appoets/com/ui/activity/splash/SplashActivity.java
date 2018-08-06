package app.foodie_appoets.com.ui.activity.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import app.foodie_appoets.com.BuildConfig;
import app.foodie_appoets.com.R;
import app.foodie_appoets.com.base.BaseActivity;
import app.foodie_appoets.com.common.SharedHelper;
import app.foodie_appoets.com.data.network.models.User;
import app.foodie_appoets.com.ui.activity.onboard.OnBoardActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity implements SplashIView {

    @BindView(R.id.note)
    TextView note;
    private SplashPresenter<SplashActivity> presenter = new SplashPresenter<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        presenter.attachView(this);
        note.setText(BuildConfig.VERSION_NAME+" ("+BuildConfig.VERSION_CODE+")");
        new Handler().postDelayed(() -> {
            Log.d("Loggedin", String.valueOf(SharedHelper.getBoolKey(SplashActivity.this, "logged_in", false)));
            String device_token = String.valueOf(SharedHelper.getKey(SplashActivity.this, "device_token"));
            Log.d("device_token", device_token);
            if (SharedHelper.getBoolKey(SplashActivity.this, "logged_in", false)) {
                presenter.profile();
            } else {
                startActivity(new Intent(SplashActivity.this, OnBoardActivity.class));
                finish();
            }
        }, 3000);
    }

    /*@OnClick({R.id.sign_in, R.id.sign_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sign_in:
//                startActivity(new Intent(this, EmailActivity.class));
                break;
            case R.id.sign_up:
//                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }*/

    @Override
    public void onSuccess(User user) {
        showToast("Sucess");
    }

    @Override
    public void onError(Throwable e) {
        showToast(String.valueOf(e));
    }
}
