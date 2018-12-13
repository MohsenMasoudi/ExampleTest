
package com.example.mohsen.exampletest.connection.model.weather_model_json;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Result {

    @SerializedName("cityList")
    private List<CityList> mCityList;
    @SerializedName("hava")
    private Hava mHava;

    public List<CityList> getCityList() {
        return mCityList;
    }

    public void setCityList(List<CityList> cityList) {
        mCityList = cityList;
    }

    public Hava getHava() {
        return mHava;
    }

    public void setHava(Hava hava) {
        mHava = hava;
    }

}
