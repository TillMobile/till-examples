package com.tillmobile.app;

import com.tillmobile.app.TillAPIInterface;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;
import okhttp3.ResponseBody;
import okhttp3.RequestBody;
import okhttp3.MediaType;

public class App  {
    // Fill in with appropriate values
    final static String username = "";
    final static String apiKey = "";
    final static String phoneNumber = "";

    final static String baseUrl = "https://platform.tillmobile.com/api/";
    final static String message ="Hello from Retrofit!";

    public static void main(String[] args) {
        RequestBody body = RequestBody.create(
            MediaType.parse("application/json"), 
            "{\"phone\":\""+phoneNumber+"\",\"text\":\""+message+"\"}"
        );
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();
        TillAPIInterface apiService = retrofit.create(TillAPIInterface.class);
        Call<ResponseBody> call = apiService.send(body, username, apiKey);
        try {
            Response<ResponseBody> response = call.execute();
            int statusCode = response.code();
            ResponseBody rawBody = response.body();

            String responseBody;
            if(rawBody != null) {
                responseBody = rawBody.string();
            } else {
                responseBody = "";
            }

            System.out.println(statusCode);
            System.out.println(responseBody);
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}
