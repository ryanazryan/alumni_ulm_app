package com.naufalazryan.alumnimipaulm.biodata;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.naufalazryan.alumnimipaulm.AboutActivity;
import com.naufalazryan.alumnimipaulm.ModelResponse.AlumniModelResponse.AlumniResponse;
import com.naufalazryan.alumnimipaulm.R;
import com.naufalazryan.alumnimipaulm.SessionManager;
import com.naufalazryan.alumnimipaulm.api.APIService;
import com.naufalazryan.alumnimipaulm.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UpdateBiodataActivity extends AppCompatActivity implements View.OnClickListener {


    SessionManager sessionManager;
    TextView tvMhsNim;
    EditText edMhsNama, edMhsAlamat, edMhsHp, edMhsEmail;
    Button btnUpdate;
    String upNim, upNama, upAlamat, upTelp, upEmail, upJK;
    RadioButton laki, perempuan, selected;
    RadioGroup rgJK;
    ProgressDialog pd;
    APIService apiService = RetrofitClient.getClient().create(APIService.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);
        view();

    }

    @Override
    protected void onResume() {
        super.onResume();
        view();
    }

    @SuppressLint("SetTextI18n")
    private void view() {

        findViewById(R.id.arrow_back).setOnClickListener(this);
        TextView activity = findViewById(R.id.activity);
        activity.setText("Update Biodata");



        btnUpdate = findViewById(R.id.btnUpdate);
        tvMhsNim = findViewById(R.id.nim);
        edMhsNama = findViewById(R.id.nama);
        edMhsAlamat = findViewById(R.id.alamat);
        edMhsHp = findViewById(R.id.telepon);
        edMhsEmail = findViewById(R.id.email);
        laki = findViewById(R.id.rbLaki);
        perempuan = findViewById(R.id.rbPerempuan);
        rgJK = findViewById(R.id.rgJenisKelamin);


        sessionManager = new SessionManager(UpdateBiodataActivity.this);

        upNim = sessionManager.getUserDetail().get(SessionManager.ALU_NIM);
        upNama = sessionManager.getUserDetail().get(SessionManager.ALU_NAMA);
        upAlamat = sessionManager.getUserDetail().get(SessionManager.ALU_ALAMAT);
        upTelp = sessionManager.getUserDetail().get(SessionManager.ALU_HP);
        upEmail = sessionManager.getUserDetail().get(SessionManager.ALU_EMAIL);
        upJK = sessionManager.getUserDetail().get(SessionManager.ALU_JK);

        tvMhsNim.setText(upNim);
        edMhsNama.setText(upNama);
        edMhsAlamat.setText(upAlamat);
        edMhsHp.setText(upTelp);
        edMhsEmail.setText(upEmail);

        tvMhsNim.setEnabled(false);

        //proses JK
        if (!(upJK == null)) {
            int index = (upJK.equalsIgnoreCase("P") ? 1 : 0);
            rgJK.check(rgJK.getChildAt(index).getId());
        }


        pd = new ProgressDialog(this);
        btnUpdate.setOnClickListener(view -> {
            pd.setMessage("Update...");
            pd.setCancelable(false);
            pd.show();

            String selectedRbText = "L";

            int selectedRadioButtonId = rgJK.getCheckedRadioButtonId();
            if (selectedRadioButtonId != -1) {
                selected = findViewById(selectedRadioButtonId);
                selectedRbText = selected.getText().toString();
                selectedRbText = (selectedRbText.equalsIgnoreCase("Perempuan") ? "P" : "L");

            }
            Log.d("Retro", selectedRbText);
            Call<AlumniResponse> update = apiService.updateBiodata(
                    upNim,
                    edMhsNama.getText().toString(),
                    edMhsAlamat.getText().toString(),
                    selectedRbText,
                    edMhsHp.getText().toString(),
                    edMhsEmail.getText().toString());

            update.enqueue(new Callback<AlumniResponse>() {
                @Override
                public void onResponse(@NonNull Call<AlumniResponse> call, @NonNull Response<AlumniResponse> response) {
//                         Log.d("Retro", "Response "+response.body().getData().getAluJK());
                    sessionManager.setAluNama(response.body().getData().getAluNama());
                    sessionManager.setAluJk(response.body().getData().getAluJK());
                    sessionManager.setAluAlamat(response.body().getData().getAluAlamat());
                    sessionManager.setAluHp(response.body().getData().getAluHp());
                    sessionManager.setAluEmail(response.body().getData().getAluEmail());
                    Toast.makeText(UpdateBiodataActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateBiodataActivity.this, BiodataActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(@NonNull Call<AlumniResponse> call, @NonNull Throwable t) {
                    pd.hide();
                    Log.d("Retro", "On Failure");
                }
            });
        });
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arrow_back:
                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateBiodataActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setIcon(R.drawable.app);
                builder.setMessage("Yakin ingin kembali");
                builder.setPositiveButton("Ya", ((dialogInterface, i) -> {
                    startActivity(new Intent(this, BiodataActivity.class));
                    overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
                }
                ));
                builder.setNegativeButton("Tidak", (dialogInterface, i) -> dialogInterface.dismiss());
                builder.show();
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(UpdateBiodataActivity.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setIcon(R.drawable.app);
        builder.setMessage("Yakin ingin kembali");
        builder.setPositiveButton("Ya", ((dialogInterface, i) -> {
            startActivity(new Intent(this, BiodataActivity.class));
            overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
        }
        ));
        builder.setNegativeButton("Tidak", (dialogInterface, i) -> dialogInterface.dismiss());
        builder.show();
    }
}
