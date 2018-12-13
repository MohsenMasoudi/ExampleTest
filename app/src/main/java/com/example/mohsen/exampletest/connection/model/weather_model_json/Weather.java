
package com.example.mohsen.exampletest.connection.model.weather_model_json;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Weather {

    @SerializedName("reqStatus")
    private ReqStatus mReqStatus;
    @SerializedName("result")
    private Result mResult;

    public ReqStatus getReqStatus() {
        return mReqStatus;
    }

    public void setReqStatus(ReqStatus reqStatus) {
        mReqStatus = reqStatus;
    }

    public Result getResult() {
        return mResult;
    }

    public void setResult(Result result) {
        mResult = result;
    }

}
