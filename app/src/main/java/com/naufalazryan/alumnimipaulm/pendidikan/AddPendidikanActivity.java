package com.naufalazryan.alumnimipaulm.pendidikan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.naufalazryan.alumnimipaulm.AboutActivity;
import com.naufalazryan.alumnimipaulm.MainActivity;
import com.naufalazryan.alumnimipaulm.R;

public class AddPendidikanActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner jenjang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pendidikan);
        jenjang = findViewById(R.id.jenjang);


        ArrayAdapter<String> spinnerJenjang = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.jenjangPendidikan));
        jenjang.setAdapter(spinnerJenjang);




        findViewById(R.id.arrow_back).setOnClickListener(this);
        findViewById(R.id.about).setOnClickListener(this);
        TextView activity = findViewById(R.id.activity);
        activity.setText("Tambah Pendidikan");
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arrow_back:
                AlertDialog.Builder builder = new AlertDialog.Builder(AddPendidikanActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setIcon(R.drawable.app);
                builder.setMessage("Yakin ingin kembali");
                builder.setPositiveButton("Ya", ((dialogInterface, i) -> {
                    startActivity(new Intent(this, PendidikanActivity.class));
                    overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
                }
                ));
                builder.setNegativeButton("Tidak", (dialogInterface, i) -> {
                    dialogInterface.dismiss();
                });
                builder.show();
                break;
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddPendidikanActivity.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setIcon(R.drawable.app);
        builder.setMessage("Yakin ingin kembali");
        builder.setPositiveButton("Ya", ((dialogInterface, i) -> {
            startActivity(new Intent(this, PendidikanActivity.class));
            overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
        }
        ));
        builder.setNegativeButton("Tidak", (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });
        builder.show();
    }
}