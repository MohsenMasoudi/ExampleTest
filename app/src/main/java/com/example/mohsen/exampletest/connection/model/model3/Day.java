
package com.example.mohsen.exampletest.connection.model.model3;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Day {

    @SerializedName("city-name")
    private CityName mCityName;
    @SerializedName("day-name")
    private DayName mDayName;
    @SerializedName("max-temp")
    private MaxTemp mMaxTemp;
    @SerializedName("min-temp")
    private MinTemp mMinTemp;
    @SerializedName("status")
    private Status mStatus;
    @SerializedName("symbol")
    private Symbol mSymbol;
    @SerializedName("temp")
    private Temp mTemp;

    public CityName getCityName() {
        return mCityName;
    }

    public void setCityName(CityName cityName) {
        mCityName = cityName;
    }

    public DayName getDayName() {
        return mDayName;
    }

    public void setDayName(DayName dayName) {
        mDayName = dayName;
    }

    public MaxTemp getMaxTemp() {
        return mMaxTemp;
    }

    public void setMaxTemp(MaxTemp maxTemp) {
        mMaxTemp = maxTemp;
    }

    public MinTemp getMinTemp() {
        return mMinTemp;
    }

    public void setMinTemp(MinTemp minTemp) {
        mMinTemp = minTemp;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

    public Symbol getSymbol() {
        return mSymbol;
    }

    public void setSymbol(Symbol symbol) {
        mSymbol = symbol;
    }

    public Temp getTemp() {
        return mTemp;
    }

    public void setTemp(Temp temp) {
        mTemp = temp;
    }

}
