package br.com.crudapplication.retrofit.config;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public abstract class AbstractRetrofitConfig {

    protected final Retrofit retrofit;
    private static final Gson gson = new Gson();

    public AbstractRetrofitConfig(String baseUrl, Converter.Factory converterFactory) {
        String url = baseUrl.endsWith("/") ? baseUrl : baseUrl.concat("/");

        this.retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(converterFactory)
                .build();
    }

    public static RequestBody getRequestBody(Object object) {
        return RequestBody.create(MediaType.parse("application/json"), gson.toJson(object));
    }
}
