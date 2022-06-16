package br.com.crudapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import br.com.crudapplication.R;
import br.com.crudapplication.retrofit.callback.GetProductListCallback;
import br.com.crudapplication.retrofit.config.JsonRetrofitConfig;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        View buttonAddUser = findViewById(R.id.button_add_user);
        buttonAddUser.setOnClickListener(onClickListenerButtonAddUser());

        new JsonRetrofitConfig()
                .getProductProxy()
                .getProductList()
                .enqueue(new GetProductListCallback(this, findViewById(R.id.listViewProducts)));
    }

    View.OnClickListener onClickListenerButtonAddUser() {
        return v -> startActivity(new Intent(this, AddUserActivity.class));
    }
}