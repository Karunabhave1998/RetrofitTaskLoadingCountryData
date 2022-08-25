package com.example.retrofittaskloadingcountrydata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CountryModel countryModel;
    JsonAdapter jsonAdapter;
    List<CountryModel> countryModelList = new ArrayList<>();

    Retrofit retrofit;
    myApiCall myApiCall1;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressDialog =new ProgressDialog(this);
        progressDialog.setCancelable(false);

        retrofit = new Retrofit.Builder().baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApiCall1 = retrofit.create(myApiCall.class);
        jsonAdapter = new JsonAdapter(this,countryModelList);
        recyclerView.setAdapter(jsonAdapter);
        
        loadData();
        


    }

    private void loadData() {

        Call<JsonResponse> call = myApiCall1.getResponseList();
        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                progressDialog.dismiss();

                if(response.code()!=200)
                {
                    Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    List<CountryModel> countryModelList1=response.body().getCountryModelList();

                    for(CountryModel countryModel1:countryModelList1)
                    {
                        String countryName1=countryModel1.getCountryName();
                        String countryCapital=countryModel1.getCapital();

                        String flagImage1=countryModel1.getUrl();
                        DetailModel detailModel = new DetailModel(countryModel1.getDetailModel().getPrimeMinister(),countryModel1.getDetailModel().getPopulation());

                        countryModel = new CountryModel(countryName1,flagImage1,countryCapital,detailModel);
                        countryModelList.add(countryModel);
                        jsonAdapter.notifyDataSetChanged();

                    }
                }

            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                progressDialog.dismiss();

            }
        });

    }
}