package br.com.crudapplication.retrofit.callback;

import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.List;

import br.com.crudapplication.adapter.ProductAdapter;
import br.com.crudapplication.model.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetProductListCallback implements Callback<List<Product>> {

    private final Activity activity;
    private final ListView listViewProducts;

    public GetProductListCallback(Activity activity, ListView listViewProducts) {
        this.activity = activity;
        this.listViewProducts = listViewProducts;
    }

    @Override
    public void onResponse(@NonNull Call<List<Product>> call, Response<List<Product>> response) {
        if (!response.isSuccessful()) {
            Toast.makeText(activity, "Erro ao consultar produtos", Toast.LENGTH_SHORT).show();
            return;
        }

        listViewProducts.setAdapter(new ProductAdapter(response.body(), activity));
    }

    @Override
    public void onFailure(@NonNull Call<List<Product>> call, Throwable t) {
        t.printStackTrace();

        Toast.makeText(activity, "Erro ao consultar produtos", Toast.LENGTH_SHORT).show();
    }
}
