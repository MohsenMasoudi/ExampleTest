
package com.example.mohsen.exampletest.connection.model.weather_model_json;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ReqStatus {

    @SerializedName("message")
    private Object mMessage;
    @SerializedName("statusCode")
    private Long mStatusCode;

    public Object getMessage() {
        return mMessage;
    }

    public void setMessage(Object message) {
        mMessage = message;
    }

    public Long getStatusCode() {
        return mStatusCode;
    }

    public void setStatusCode(Long statusCode) {
        mStatusCode = statusCode;
    }

}
