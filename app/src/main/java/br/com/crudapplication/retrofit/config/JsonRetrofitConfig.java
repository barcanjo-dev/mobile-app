package br.com.crudapplication.retrofit.config;

import br.com.crudapplication.proxy.ProductProxy;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonRetrofitConfig extends AbstractRetrofitConfig {

    public JsonRetrofitConfig() {
        super("https://example-ecommerce.herokuapp.com", GsonConverterFactory.create());
    }

    public ProductProxy getProductProxy() {
        return super.retrofit.create(ProductProxy.class);
    }
}
