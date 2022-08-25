package com.example.retrofittaskloadingcountrydata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {

    public JsonResponse(List<CountryModel> countryModelList) {
        this.countryModelList = countryModelList;
    }

    @SerializedName("countries")
    @Expose
   private List<CountryModel> countryModelList;

    public List<CountryModel> getCountryModelList() {
        return countryModelList;
    }

    public void setCountryModelList(List<CountryModel> countryModelList) {
        this.countryModelList = countryModelList;
    }
}
