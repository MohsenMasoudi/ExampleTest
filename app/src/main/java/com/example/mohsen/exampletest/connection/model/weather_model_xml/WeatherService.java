
package com.example.mohsen.exampletest.connection.model.weather_model_xml;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;


@Root(name = "weather-service",strict = false)
public class WeatherService {
@ElementList(name = "day",inline = true,required = false)
    private List<Day> dayList;

    public List<Day> getDayList() {
        return dayList;
    }

    public void setDayList(List<Day> dayList) {
        this.dayList = dayList;
    }
}
