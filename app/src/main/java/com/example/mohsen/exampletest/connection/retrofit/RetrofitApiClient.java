package com.example.mohsen.exampletest.connection.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitApiClient {
    private GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
    private SimpleXmlConverterFactory simpleXmlConverterFactory = SimpleXmlConverterFactory.create();
    private Retrofit retrofit = null;

    public Retrofit getRetrofit(String url) {
        if (retrofit == null) {
            return new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(new XmlORJsonConverter())
//                    .addConverterFactory(new AnnotatedConverters.AnnotatedConverterFactory.Builder()
//                            .add(Json.class, gsonConverterFactory)
//                            .add(Xml.class, simpleXmlConverterFactory)
//                            .build())
                    .build();

        }
        return retrofit;
    }

}
