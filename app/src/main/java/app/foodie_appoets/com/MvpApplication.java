package app.foodie_appoets.com;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.facebook.stetho.Stetho;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import app.foodie_appoets.com.common.LocaleHelper;
import app.foodie_appoets.com.common.SharedHelper;

public class MvpApplication extends Application {

    private static MvpApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        mInstance = this;
        MultiDex.install(this);
    }

    public static synchronized MvpApplication getInstance() {
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));
        //super.attachBaseContext(newBase);
        MultiDex.install(newBase);
    }

    public NumberFormat getNumberFormat() {
        String currencyCode = SharedHelper.getKey(getApplicationContext(), "currency_code", "USD");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        numberFormat.setCurrency(Currency.getInstance(currencyCode));
        numberFormat.setMinimumFractionDigits(2);
        return numberFormat;
    }

}
