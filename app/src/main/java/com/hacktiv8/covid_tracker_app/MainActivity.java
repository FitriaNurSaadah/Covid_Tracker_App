package com.hacktiv8.covid_tracker_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mtotalCasesTv;
    private TextView mtotalRecoveryTv;
    private TextView mtotalDeathTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtotalCasesTv = findViewById(R.id.totalCasesTV);
        mtotalRecoveryTv = findViewById(R.id.totalRecoveredTV);
        mtotalDeathTv = findViewById(R.id.totalDeathTV);

        getCovidAll();
    }

    private void getCovidAll(){
        Toast.makeText(getApplicationContext(), "Sedang Menghubungkan ke Server ", Toast.LENGTH_SHORT).show();
        Call<Covid> callCovid = RetrofitClient.getInstance().getMyApi().getCovidAll();

       callCovid.enqueue(new Callback<Covid>() {
           @Override
           public void onResponse(Call<Covid> call, Response<Covid> response) {
               Covid dataCovid = response.body();

               assert dataCovid != null;
               mtotalCasesTv.setText(String.valueOf(dataCovid.getTotalCases()));
               mtotalRecoveryTv.setText(String.valueOf(dataCovid.getTotalRecovered()));
               mtotalDeathTv.setText(String.valueOf(dataCovid.getTotalDeath()));

               System.out.println(dataCovid.getTotalCases());
               System.out.println(dataCovid.getTotalDeath());
               System.out.println(dataCovid.getTotalRecovered());
               Toast.makeText(getApplicationContext(), "Berhasil Terhubung",Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onFailure(Call<Covid> call, Throwable t) {
               Toast.makeText(getApplicationContext() ,"Gagal Terhubung",Toast.LENGTH_SHORT).show();
               Toast.makeText(getApplicationContext() ,String.valueOf(t),Toast.LENGTH_LONG).show();
           }
       });
    }
}