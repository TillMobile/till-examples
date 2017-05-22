package com.tillmobile.app;

import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.Callback;
import retrofit2.Call;
import okhttp3.ResponseBody;
import okhttp3.RequestBody;

public interface TillAPIInterface {
    @Headers({
        "User-Agent: Retrofit/2.3.0"
    })
    @POST("send/")
    Call<ResponseBody> send(
        @Body RequestBody project,
        @Query("username") String username,
        @Query("api_key") String api_key
    );
}
