package com.hacktiv8.covid_tracker_app;

import com.google.gson.annotations.SerializedName;

public class Covid {

    @SerializedName("cases")
    private long totalCases;

    @SerializedName("deaths")
    private long totalDeath;

    @SerializedName("recovered")
    private long totalRecovered;

    public long getTotalCases(){
        return totalCases;
    }

    public long getTotalDeath() {
        return totalDeath;
    }

    public long getTotalRecovered() {
        return totalRecovered;
    }

}

