package com.example.retrofittaskloadingcountrydata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.MyHolder> {

    Context context;
    List<CountryModel> countryModelList = new ArrayList<>();

    public JsonAdapter(Context context, List<CountryModel> countryModelList) {
        this.context = context;
        this.countryModelList = countryModelList;
    }

    @NonNull
    @Override
    public JsonAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler,parent,false);
        return new MyHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonAdapter.MyHolder holder, int position) {

        holder.countryName.setText(countryModelList.get(position).getCountryName());
        holder.capitalTxt.setText(countryModelList.get(position).getCapital());
        holder.primeMinisterTxt.setText(countryModelList.get(position).getDetailModel().getPrimeMinister());
        holder.populationTxt.setText(countryModelList.get(position).getDetailModel().getPopulation());

        Glide.with(context).load(countryModelList.get(position).getUrl()).centerCrop()
                .placeholder(R.mipmap.ic_launcher).into(holder.flagImage);


    }

    @Override
    public int getItemCount() {
        return countryModelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView countryName, capitalTxt, primeMinisterTxt, populationTxt;
        ImageView flagImage;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.countryid);
            capitalTxt = itemView.findViewById(R.id.capitalid);
            primeMinisterTxt = itemView.findViewById(R.id.pmid);
            populationTxt = itemView.findViewById(R.id.populationid);
            flagImage = itemView.findViewById(R.id.flagid);


        }
    }
}
