package com.example.covid_19.ui.country;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import com.example.covid_19.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class CovidCountryDetail extends AppCompatActivity{

    TextView tvDetailCountryName , tvDetailTotalCases , TvDetailTodayCases ,
            TvDetailTodayDeath , TvDetailTotalDeath , TvDetailTotalRecovered ,
            TvDetailTotalCritical , TvDetailTotalActive;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_country_detail);




        //call View
        tvDetailCountryName = findViewById(R.id.tvDetailCountryName);
        tvDetailTotalCases = findViewById(R.id.TvDetailTotalCases);
        TvDetailTodayCases = findViewById(R.id.TvDetailTodayCases);
        TvDetailTotalDeath= findViewById(R.id.TvDetailTodayDeath);
        TvDetailTodayDeath = findViewById(R.id.TvDetailTodayDeath);
        TvDetailTotalRecovered = findViewById(R.id.TvDetailTotalRecovered);
        TvDetailTotalCritical = findViewById(R.id.TvDetailTotalCritical);
        TvDetailTotalActive = findViewById(R.id.TvDetailTotalActive);

        //call covid country
        CovidCountry covidCountry = getIntent().getParcelableExtra("EXTRA_COVID");

        // Set Text view

        tvDetailCountryName.setText(covidCountry.getmCovidCountry());
        tvDetailTotalCases.setText(covidCountry.getmCases());
        TvDetailTodayCases.setText(covidCountry.getmTodaycases());
        TvDetailTotalDeath.setText(covidCountry.getmTotalDeaths());
        TvDetailTodayDeath.setText(covidCountry.getmDeaths());
        TvDetailTotalRecovered.setText(covidCountry.getmRecovered());
        TvDetailTotalCritical.setText(covidCountry.getmCritical());
        TvDetailTotalActive.setText(covidCountry.getmActive());


    }
}


/*import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
    }
}*/


/*
* public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}*/