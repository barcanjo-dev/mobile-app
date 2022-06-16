package br.com.crudapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.crudapplication.R;
import br.com.crudapplication.dto.AddUserRequestBody;
import br.com.crudapplication.exception.EmptyFieldException;
import br.com.crudapplication.exception.InvalidPasswordConfirmationException;
import br.com.crudapplication.proxy.UserProxy;
import br.com.crudapplication.retrofit.callback.AddUserCallback;
import br.com.crudapplication.retrofit.config.AbstractRetrofitConfig;
import br.com.crudapplication.retrofit.config.TextPlainRetrofitConfig;

public class AddUserActivity extends AppCompatActivity {

    private EditText editTextAddress;
    private EditText editTextAge;
    private EditText editTextEmail;
    private EditText editTextName;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirmation;
    private UserProxy userProxy;
    private AddUserCallback addUserCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        this.editTextAddress = findViewById(R.id.edit_text_add_user_address);
        this.editTextAge = findViewById(R.id.edit_text_add_user_age);
        this.editTextEmail = findViewById(R.id.edit_text_add_user_email);
        this.editTextName = findViewById(R.id.edit_text_add_user_name);
        this.editTextPassword = findViewById(R.id.edit_text_add_user_password);
        this.editTextPasswordConfirmation = findViewById(R.id.edit_text_add_user_password_confirmation);

        List<EditText> editTextList = Arrays.asList(
                editTextAddress,
                editTextAge,
                editTextEmail,
                editTextName,
                editTextPassword,
                editTextPasswordConfirmation
        );

        this.userProxy = new TextPlainRetrofitConfig().getUserProxy();
        this.addUserCallback = new AddUserCallback(this, editTextList);

        Button button = findViewById(R.id.button_save_user);
        button.setOnClickListener(onClickListenerButtonAddUser());
    }

    private void checkEmpty(EditText editText) throws EmptyFieldException {
        if (editText.getText().toString().isEmpty()) {
            throw new EmptyFieldException();
        }
    }

    private void checkPasswordConfirmation() throws InvalidPasswordConfirmationException {
        if (!editTextPassword.getText().toString().equalsIgnoreCase(editTextPasswordConfirmation.getText().toString())) {
            throw new InvalidPasswordConfirmationException();
        }
    }

    private void callApi(AddUserRequestBody body) {
        this.userProxy
                .add(AbstractRetrofitConfig.getRequestBody(body))
                .enqueue(addUserCallback);
    }

    private View.OnClickListener onClickListenerButtonAddUser() {
        return v -> {
            try {
                checkEmpty(editTextAddress);
                checkEmpty(editTextAge);
                checkEmpty(editTextEmail);
                checkEmpty(editTextName);
                checkEmpty(editTextPassword);
                checkEmpty(editTextPasswordConfirmation);

                checkPasswordConfirmation();

                AddUserRequestBody addUserRequestBody = new AddUserRequestBody();
                addUserRequestBody.setAddress(editTextAddress.getText().toString());
                addUserRequestBody.setAge(Integer.parseInt(editTextAge.getText().toString()));
                addUserRequestBody.setEmail(editTextEmail.getText().toString());
                addUserRequestBody.setName(editTextName.getText().toString());
                addUserRequestBody.setUserPassword(editTextPassword.getText().toString());

                callApi(addUserRequestBody);
            } catch (EmptyFieldException e) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } catch (InvalidPasswordConfirmationException e) {
                Toast.makeText(this, "Senha e confirmação de senha inválidas", Toast.LENGTH_SHORT).show();
            }
        };
    }

}