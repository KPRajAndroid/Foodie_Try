package app.foodie_appoets.com.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {

    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("shops")
    @Expose
    private List<Shop> shops = null;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> product) {
        this.products = product;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shop) {
        this.shops = shop;
    }

}
