package br.com.crudapplication.proxy;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginProxy {

    @POST("/user/login")
    Call<String> login(@Body RequestBody body);
}
