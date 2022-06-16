package br.com.crudapplication.retrofit.callback;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserCallback implements Callback<String> {

    private final Activity activity;
    private final List<EditText> editTextList;

    public AddUserCallback(Activity activity, List<EditText> editTextList) {
        this.activity = activity;
        this.editTextList = editTextList;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (!response.isSuccessful()) {
            Toast.makeText(activity, "Erro ao salvar usuário", Toast.LENGTH_SHORT).show();
            return;
        }

        for (EditText editText : editTextList) {
            editText.setText("");
        }

        Toast.makeText(activity, "Usuário salvo com sucesso!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Toast.makeText(activity, "Erro ao salvar usuário!", Toast.LENGTH_SHORT).show();
    }
}
