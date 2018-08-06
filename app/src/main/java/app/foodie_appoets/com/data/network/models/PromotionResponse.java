package app.foodie_appoets.com.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PromotionResponse {

    @SerializedName("wallet_balance")
    @Expose
    private Integer walletMoney;

    public Integer getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(Integer walletMoney) {
        this.walletMoney = walletMoney;
    }
}
