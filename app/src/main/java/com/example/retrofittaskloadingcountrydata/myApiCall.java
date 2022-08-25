package com.example.retrofittaskloadingcountrydata;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myApiCall {

   // https://run.mocky.io/v3/ 17174ac6-c111-424b-86d7-57b908e4283a

    @GET("17174ac6-c111-424b-86d7-57b908e4283a")
    Call<JsonResponse> getResponseList();
}
