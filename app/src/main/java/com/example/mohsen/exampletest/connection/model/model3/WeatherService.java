
package com.example.mohsen.exampletest.connection.model.model3;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WeatherService {

    @SerializedName("day")
    private List<Day> mDay;

    public List<Day> getDay() {
        return mDay;
    }

    public void setDay(List<Day> day) {
        mDay = day;
    }

}
