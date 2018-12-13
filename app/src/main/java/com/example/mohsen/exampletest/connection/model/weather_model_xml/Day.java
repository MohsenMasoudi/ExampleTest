package com.example.mohsen.exampletest.connection.model.weather_model_xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "day")
public class Day {
    @Element(name = "city-name",required = false)
    private String mCityName;
    @Element(name = "day-name",required = false)
    private String mDayName;
    @Element(name = "max-temp",required = false)
    private String mMaxTemp;
    @Element(name = "min-temp",required = false)
    private String mMinTemp;
    @Element(name = "status",required = false)
    private String mStatus;
    @Element(name = "symbol",required = false)
    private String mSymbol;
    @Element(name = "temp",required = false)
    private String mTemp;

    public String getmCityName() {
        return mCityName;
    }

    public String getmDayName() {
        return mDayName;
    }

    public String getmMaxTemp() {
        return mMaxTemp;
    }

    public String getmMinTemp() {
        return mMinTemp;
    }

    public String getmStatus() {
        return mStatus;
    }

    public String getmSymbol() {
        return mSymbol;
    }

    public String getmTemp() {
        return mTemp;
    }
}
