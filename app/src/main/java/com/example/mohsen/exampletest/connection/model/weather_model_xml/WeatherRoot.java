
package com.example.mohsen.exampletest.connection.model.weather_model_xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "main")
public class WeatherRoot {

    @Element(name="sadana-services")
    private SadanaServices mSadanaServices;

    public SadanaServices getSadanaServices() {
        return mSadanaServices;
    }

    public void setSadanaServices(SadanaServices sadanaServices) {
        mSadanaServices = sadanaServices;
    }

}
