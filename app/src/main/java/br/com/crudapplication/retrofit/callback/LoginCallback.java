package br.com.crudapplication.retrofit.callback;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import br.com.crudapplication.view.LoginActivity;
import br.com.crudapplication.view.ProductActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginCallback implements Callback<String> {

    private final Context context;

    public LoginCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onResponse(@NonNull Call<String> call, Response<String> response) {
        if (!response.isSuccessful()) {
            Toast.makeText(context, "Usuário/senha inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        LoginActivity.TOKEN = response.body();

        context.startActivity(new Intent(context, ProductActivity.class));
    }

    @Override
    public void onFailure(@NonNull Call<String> call, Throwable t) {
        t.printStackTrace();

        Toast.makeText(context, "Erro ao realizar chamada", Toast.LENGTH_SHORT).show();
    }
}
