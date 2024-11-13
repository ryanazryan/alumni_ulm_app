package com.naufalazryan.alumnimipaulm;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.naufalazryan.alumnimipaulm.api.RetrofitClient;
import com.naufalazryan.alumnimipaulm.api.APIService;
import com.naufalazryan.alumnimipaulm.ModelResponse.AlumniModelResponse.AlumniModel;
import com.naufalazryan.alumnimipaulm.ModelResponse.AlumniModelResponse.AlumniResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nim, password;
    Button btnLogin;
    String Nim, Password;
    SessionManager sessionManager;
    APIService apiService;
    TextInputLayout nimLayout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nim = findViewById(R.id.nim);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        nimLayout = findViewById(R.id.nimLayout);
        btnLogin.setOnClickListener(this);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btnLogin:
               Nim = nim.getText().toString();
               Password = password.getText().toString();
               login(Nim, Password);
               break;
       }
    }



    private void login(String nim, String password) {
        apiService = RetrofitClient.getClient().create(APIService.class);
        Call<AlumniResponse> loginCall = apiService.loginResponse(nim, password);
        loginCall.enqueue(new Callback<AlumniResponse>() {
            @Override
            public void onResponse(Call<AlumniResponse> call, Response<AlumniResponse> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    sessionManager = new SessionManager(LoginActivity.this);
                    AlumniModel loginData = response.body().getData();
                    sessionManager.createLoginSession(loginData);

                    Toast.makeText(LoginActivity.this, response.body().getData().getMhsNama(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }
//                Log.d("response", response.toString());
            }

            @Override
            public void onFailure(Call<AlumniResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }



}