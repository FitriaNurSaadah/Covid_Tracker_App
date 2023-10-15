package com.hacktiv8.covid_tracker_app;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    String BASE_URL = "https://disease.sh/";

    @GET("v3/covid-19/all")
    Call<Covid> getCovidAll();

}
