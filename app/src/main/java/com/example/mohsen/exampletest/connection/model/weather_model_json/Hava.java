
package com.example.mohsen.exampletest.connection.model.weather_model_json;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Hava {

    @SerializedName("city")
    private String mCity;
    @SerializedName("dayList")
    private List<DayList> mDayList;
    @SerializedName("state")
    private String mState;
    @SerializedName("summary")
    private Summary mSummary;

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public List<DayList> getDayList() {
        return mDayList;
    }

    public void setDayList(List<DayList> dayList) {
        mDayList = dayList;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public Summary getSummary() {
        return mSummary;
    }

    public void setSummary(Summary summary) {
        mSummary = summary;
    }

}
