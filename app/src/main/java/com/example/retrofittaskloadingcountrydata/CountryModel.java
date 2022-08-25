package com.example.retrofittaskloadingcountrydata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryModel {

    private String countryName;
    private String url;
    private String capital;

    @SerializedName("Details")
    @Expose
    private DetailModel detailModel;

    public CountryModel(String countryName, String url, String capital, DetailModel detailModel) {
        this.countryName = countryName;
        this.url = url;
        this.capital = capital;
        this.detailModel = detailModel;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public DetailModel getDetailModel() {
        return detailModel;
    }

    public void setDetailModel(DetailModel detailModel) {
        this.detailModel = detailModel;
    }
}
