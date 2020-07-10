package com.example.covid_19.ui.country;

import android.os.Parcel;
import android.os.Parcelable;

public class CovidCountry implements Parcelable {
    String mCovidCountry, mCases, mTodaycases, mDeaths, mTotalDeaths, mRecovered, mCritical, mActive;


    public CovidCountry(String mCovidCountry, String mCases, String mTodaycases, String mDeaths, String mTotalDeaths, String mRecovered, String mCritical, String mActive) {
        this.mCovidCountry = mCovidCountry;
        this.mCases = mCases;
        this.mTodaycases = mTodaycases;
        this.mDeaths = mDeaths;
        this.mTotalDeaths = mTotalDeaths;
        this.mRecovered = mRecovered;
        this.mCritical = mCritical;
        this.mActive = mActive;
    }

    public CovidCountry(String country, String cases) {
    }

    public String getmCovidCountry() {
        return mCovidCountry;
    }

    public String getmCases() {
        return mCases;
    }

    public String getmTodaycases() {
        return mTodaycases;
    }

    public String getmDeaths() {
        return mDeaths;
    }

    public String getmTotalDeaths() {
        return mTotalDeaths;
    }

    public String getmRecovered() {
        return mRecovered;
    }

    public String getmCritical() {
        return mCritical;
    }

    public String getmActive() {
        return mActive;
    }

    public static Creator<CovidCountry> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mCovidCountry);
        dest.writeString(this.mCases);
        dest.writeString(this.mTodaycases);
        dest.writeString(this.mDeaths);
        dest.writeString(this.mTotalDeaths);
        dest.writeString(this.mRecovered);
        dest.writeString(this.mCritical);
        dest.writeString(this.mActive);
    }

    protected CovidCountry(Parcel in) {
        this.mCovidCountry = in.readString();
        this.mCases = in.readString();
        this.mTodaycases = in.readString();
        this.mDeaths = in.readString();
        this.mTotalDeaths = in.readString();
        this.mRecovered = in.readString();
        this.mCritical = in.readString();
        this.mActive = in.readString();
    }

    public static final Parcelable.Creator<CovidCountry> CREATOR = new Parcelable.Creator<CovidCountry>() {
        @Override
        public CovidCountry createFromParcel(Parcel source) {
            return new CovidCountry(source);
        }

        @Override
        public CovidCountry[] newArray(int size) {
            return new CovidCountry[size];
        }
    };
}