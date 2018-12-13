package com.example.mohsen.exampletest.connection.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

class XmlORJsonConverter extends Converter.Factory {
    private  Converter.Factory xml = SimpleXmlConverterFactory.create();
    private  Converter.Factory json = GsonConverterFactory.create();

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        for (Annotation annotation:annotations){
            if(annotation instanceof Xml){
                return xml.responseBodyConverter(type,annotations,retrofit);
            }
            if(annotation instanceof Json){
                return json.responseBodyConverter(type,annotations,retrofit);
            }
        }
        return null;
    }


}
