package com.naufalazryan.alumnimipaulm.sosmed;

import static com.naufalazryan.alumnimipaulm.Config.IMAGE_URL;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.naufalazryan.alumnimipaulm.AboutActivity;
import com.naufalazryan.alumnimipaulm.MainActivity;
import com.naufalazryan.alumnimipaulm.R;
import com.naufalazryan.alumnimipaulm.SessionManager;
import com.naufalazryan.alumnimipaulm.akademik.AkademikActivity;
import com.naufalazryan.alumnimipaulm.akademik.UpdateAkademikActivity;
import com.naufalazryan.alumnimipaulm.biodata.BiodataActivity;
import com.naufalazryan.alumnimipaulm.pekerjaan.PekerjaanActivity;
import com.naufalazryan.alumnimipaulm.pekerjaan.UpdatePekerjaanActivity;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;


public class UpdateSosialMediaActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edUrl;
    Intent intent;
    Spinner sosmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sosial_media);

        edUrl = findViewById(R.id.url);

        findViewById(R.id.arrow_back).setOnClickListener(this);
        findViewById(R.id.about).setOnClickListener(this);
        sosmed = findViewById(R.id.jenisSosmed);

        TextView activity = findViewById(R.id.activity);
        activity.setText("Update Sosial Media");

        ArrayAdapter<String> spinnerJenisSosmed = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.jenisSosmed2));
        sosmed.setAdapter(spinnerJenisSosmed);

        intent = getIntent();
        edUrl.setText(intent.getStringExtra("URL"));


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arrow_back:
                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateSosialMediaActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setIcon(R.drawable.app);
                builder.setMessage("Yakin ingin kembali");
                builder.setPositiveButton("Ya", ((dialogInterface, i) -> {
                    startActivity(new Intent(this, SosialMediaActivity.class));
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
        AlertDialog.Builder builder = new AlertDialog.Builder(UpdateSosialMediaActivity.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setIcon(R.drawable.app);
        builder.setMessage("Yakin ingin kembali");
        builder.setPositiveButton("Ya", ((dialogInterface, i) -> {
            startActivity(new Intent(this, SosialMediaActivity.class));
            overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
        }
        ));
        builder.setNegativeButton("Tidak", (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });
        builder.show();
    }
}