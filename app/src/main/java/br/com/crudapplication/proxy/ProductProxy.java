package br.com.crudapplication.proxy;

import java.util.List;

import br.com.crudapplication.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductProxy {

    @GET("/product/list")
    Call<List<Product>> getProductList();
}
