package com.naufalazryan.alumnimipaulm;

import static com.naufalazryan.alumnimipaulm.Config.IMAGE_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.naufalazryan.alumnimipaulm.biodata.UpdateBiodataActivity;
import com.naufalazryan.alumnimipaulm.sosmed.AddSosialMediaActivity;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    SessionManager sessionManager;
    CircleImageView profil;
    TextView nama, nim, email, telepon, update, btnLogout;
    String aluNama, aluNim, aluEmail, aluTelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManager = new SessionManager(ProfileActivity.this);

        profil = findViewById(R.id.profil);
        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.nim);
        email = findViewById(R.id.email);
        telepon = findViewById(R.id.telepon);
        update = findViewById(R.id.update);
        btnLogout = findViewById(R.id.logout);

        aluNim = sessionManager.getUserDetail().get(SessionManager.ALU_NIM);
        aluNama = sessionManager.getUserDetail().get(SessionManager.ALU_NAMA);
        aluEmail = sessionManager.getUserDetail().get(SessionManager.ALU_EMAIL);
        aluTelp = sessionManager.getUserDetail().get(SessionManager.ALU_HP);

        nim.setText(aluNim);
        nama.setText(aluNama);
        email.setText(aluEmail);
        telepon.setText(aluTelp);

        findViewById(R.id.arrow_back).setOnClickListener(this);
        findViewById(R.id.about).setOnClickListener(this);

        TextView activity = findViewById(R.id.activity);
        activity.setText("Halaman Profil");


        update.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), UpdateBiodataActivity.class)));
        Picasso.get().load(IMAGE_URL + sessionManager.getFoto()).into(profil);

        
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arrow_back:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
                break;
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
                break;
            case R.id.btnTambah:
                startActivity(new Intent(this, AddSosialMediaActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
    }
}