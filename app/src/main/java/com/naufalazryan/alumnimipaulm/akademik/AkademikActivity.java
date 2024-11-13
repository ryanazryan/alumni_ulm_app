package com.naufalazryan.alumnimipaulm.akademik;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.naufalazryan.alumnimipaulm.MainActivity;
import com.naufalazryan.alumnimipaulm.R;
import com.naufalazryan.alumnimipaulm.SessionManager;

public class AkademikActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvJudulSkripsi, tvAluDosenPa, tvAluDosenPu, tvAluDosenPp, tvAluDosenPg1, tvAluDosenPg2;
    SessionManager sessionManager;
    String judulSkripsi, aluDosenPa, aluDosenPu, aluDosenPp, aluDosenPg1, aluDosenPg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akademik);
        view();
    }

    @Override
    protected void onResume() {
        super.onResume();
        view();
    }

    @SuppressLint("SetTextI18n")
    private void view() {
        tvJudulSkripsi = findViewById(R.id.judulSkripsi);
        tvAluDosenPa = findViewById(R.id.pembimbingAkademik);
        tvAluDosenPu = findViewById(R.id.pembimbingUtama);
        tvAluDosenPp = findViewById(R.id.pembimbingPendamping);
        tvAluDosenPg1 = findViewById(R.id.pengujiUtama);
        tvAluDosenPg2 = findViewById(R.id.anggotaPenguji);

        sessionManager = new SessionManager(AkademikActivity.this);

        judulSkripsi = sessionManager.getUserDetail().get(SessionManager.ALU_JUDUL_SKRIPSI);
        aluDosenPa = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PA_NAMA);
        aluDosenPu = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PU_NAMA);
        aluDosenPp = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PP_NAMA);
        aluDosenPg1  = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PG_1_NAMA);
        aluDosenPg2 = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PG_2_NAMA);

        tvJudulSkripsi.setText(judulSkripsi);
        tvAluDosenPa.setText(aluDosenPa);
        tvAluDosenPu.setText(aluDosenPu);
        tvAluDosenPp.setText(aluDosenPp);
        tvAluDosenPg1.setText(aluDosenPg1);
        tvAluDosenPg2.setText(aluDosenPg2);



        findViewById(R.id.btnUpdate).setOnClickListener(this);
        findViewById(R.id.arrow_back).setOnClickListener(this);
        TextView activity = findViewById(R.id.activity);
        activity.setText("Akademik");
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUpdate:
                startActivity(new Intent(this, UpdateAkademikActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
                break;
            case R.id.arrow_back:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
    }
}