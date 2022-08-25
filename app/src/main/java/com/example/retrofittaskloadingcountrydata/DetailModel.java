package com.example.retrofittaskloadingcountrydata;

public class DetailModel {

    String primeMinister;
    String population;

    public DetailModel(String primeMinister, String population) {
        this.primeMinister = primeMinister;
        this.population = population;
    }

    public String getPrimeMinister() {
        return primeMinister;
    }

    public void setPrimeMinister(String primeMinister) {
        this.primeMinister = primeMinister;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
