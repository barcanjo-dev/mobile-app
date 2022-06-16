package br.com.crudapplication.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import br.com.crudapplication.R;
import br.com.crudapplication.dto.LoginRequestBody;
import br.com.crudapplication.retrofit.callback.LoginCallback;
import br.com.crudapplication.retrofit.config.AbstractRetrofitConfig;
import br.com.crudapplication.retrofit.config.TextPlainRetrofitConfig;
import br.com.crudapplication.proxy.LoginProxy;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private LoginProxy loginProxy;
    private LoginCallback loginCallback;

    public static String TOKEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.editTextUsername = this.findViewById(R.id.editTextUserame);
        this.editTextPassword = this.findViewById(R.id.editTextPassword);
        this.loginProxy = new TextPlainRetrofitConfig().getLoginProxy();
        this.loginCallback = new LoginCallback(LoginActivity.this);

        Button buttonSignIng = this.findViewById(R.id.buttonSignIn);
        buttonSignIng.setOnClickListener(onClickListenerButtonSignIn());
    }

    private void callApi(LoginRequestBody loginRequestBody) {
        this.loginProxy
                .login(AbstractRetrofitConfig.getRequestBody(loginRequestBody))
                .enqueue(loginCallback);
    }

    private View.OnClickListener onClickListenerButtonSignIn() {
        return v -> {
            LoginRequestBody body = new LoginRequestBody(editTextUsername.getText().toString(), editTextPassword.getText().toString());

            if ((Objects.isNull(body.getLogin()) || body.getLogin().isEmpty()) ||
                    (Objects.isNull(body.getPassword()) || body.getPassword().isEmpty())) {
                Toast.makeText(LoginActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            callApi(body);
        };
    }
}