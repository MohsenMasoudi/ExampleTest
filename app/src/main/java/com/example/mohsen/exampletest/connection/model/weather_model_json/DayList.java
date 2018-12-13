
package com.example.mohsen.exampletest.connection.model.weather_model_json;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DayList {

    @SerializedName("condition")
    private String mCondition;
    @SerializedName("items")
    private List<Item> mItems;
    @SerializedName("max")
    private String mMax;
    @SerializedName("min")
    private String mMin;
    @SerializedName("name")
    private String mName;
    @SerializedName("symbol")
    private String mSymbol;

    public String getCondition() {
        return mCondition;
    }

    public void setCondition(String condition) {
        mCondition = condition;
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }

    public String getMax() {
        return mMax;
    }

    public void setMax(String max) {
        mMax = max;
    }

    public String getMin() {
        return mMin;
    }

    public void setMin(String min) {
        mMin = min;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public void setSymbol(String symbol) {
        mSymbol = symbol;
    }

}
