
package com.example.mohsen.exampletest.connection.model.weather_model_json;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Item {

    @SerializedName("humidity")
    private String mHumidity;
    @SerializedName("precipitation")
    private String mPrecipitation;
    @SerializedName("symbol")
    private String mSymbol;
    @SerializedName("temp")
    private String mTemp;
    @SerializedName("time")
    private String mTime;
    @SerializedName("windDir")
    private String mWindDir;
    @SerializedName("windSpeed")
    private String mWindSpeed;
    @SerializedName("windSpeedValue")
    private String mWindSpeedValue;

    public String getHumidity() {
        return mHumidity;
    }

    public void setHumidity(String humidity) {
        mHumidity = humidity;
    }

    public String getPrecipitation() {
        return mPrecipitation;
    }

    public void setPrecipitation(String precipitation) {
        mPrecipitation = precipitation;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public void setSymbol(String symbol) {
        mSymbol = symbol;
    }

    public String getTemp() {
        return mTemp;
    }

    public void setTemp(String temp) {
        mTemp = temp;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getWindDir() {
        return mWindDir;
    }

    public void setWindDir(String windDir) {
        mWindDir = windDir;
    }

    public String getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        mWindSpeed = windSpeed;
    }

    public String getWindSpeedValue() {
        return mWindSpeedValue;
    }

    public void setWindSpeedValue(String windSpeedValue) {
        mWindSpeedValue = windSpeedValue;
    }

}
