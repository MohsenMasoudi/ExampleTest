
package com.example.mohsen.exampletest.connection.model.weather_model_json;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Summary {

    @SerializedName("condition")
    private String mCondition;
    @SerializedName("currentSymbol")
    private String mCurrentSymbol;
    @SerializedName("date")
    private String mDate;
    @SerializedName("humidity")
    private String mHumidity;
    @SerializedName("precipitation")
    private String mPrecipitation;
    @SerializedName("pressure")
    private String mPressure;
    @SerializedName("temp")
    private String mTemp;
    @SerializedName("update")
    private String mUpdate;
    @SerializedName("windDir")
    private String mWindDir;
    @SerializedName("windSpeed")
    private String mWindSpeed;

    public String getCondition() {
        return mCondition;
    }

    public void setCondition(String condition) {
        mCondition = condition;
    }

    public String getCurrentSymbol() {
        return mCurrentSymbol;
    }

    public void setCurrentSymbol(String currentSymbol) {
        mCurrentSymbol = currentSymbol;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

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

    public String getPressure() {
        return mPressure;
    }

    public void setPressure(String pressure) {
        mPressure = pressure;
    }

    public String getTemp() {
        return mTemp;
    }

    public void setTemp(String temp) {
        mTemp = temp;
    }

    public String getUpdate() {
        return mUpdate;
    }

    public void setUpdate(String update) {
        mUpdate = update;
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

}
