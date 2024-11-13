package com.naufalazryan.alumnimipaulm.pekerjaan;

import static com.naufalazryan.alumnimipaulm.Config.IMAGE_URL;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.naufalazryan.alumnimipaulm.AboutActivity;
import com.naufalazryan.alumnimipaulm.MainActivity;
import com.naufalazryan.alumnimipaulm.R;
import com.naufalazryan.alumnimipaulm.SessionManager;
import com.naufalazryan.alumnimipaulm.akademik.AkademikActivity;
import com.naufalazryan.alumnimipaulm.akademik.UpdateAkademikActivity;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpdatePekerjaanActivity extends AppCompatActivity implements View.OnClickListener {

    SessionManager sessionManager;
    Intent intent;
    EditText edPekerjaan, edInstansi, edTahunMulai, edNamaAtasan, edEmailAtasan, edHpAtasan;
    Spinner pekerjaan, bidang, penghasilan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pekerjaan);
        pekerjaan = findViewById(R.id.namaPekerjaan);
        bidang = findViewById(R.id.bidang);
        penghasilan = findViewById(R.id.penghasilan);


        sessionManager = new SessionManager(UpdatePekerjaanActivity.this);

        edPekerjaan = findViewById(R.id.pekerjaan);
        edInstansi = findViewById(R.id.namaInstansi);
        edTahunMulai = findViewById(R.id.tahunMulai);
        edNamaAtasan = findViewById(R.id.namaAtasan);
        edEmailAtasan = findViewById(R.id.emailAtasan);
        edHpAtasan = findViewById(R.id.hpAtasan);

        findViewById(R.id.arrow_back).setOnClickListener(this);
        findViewById(R.id.about).setOnClickListener(this);
        TextView activity = findViewById(R.id.activity);
        activity.setText("Update Pekerjaan");

        intent = getIntent();
        edPekerjaan.setText(intent.getStringExtra("kjPekerjaan"));
        edInstansi.setText(intent.getStringExtra("kjInstansi"));
        edTahunMulai.setText(intent.getStringExtra("kjTahunMulai"));
        edNamaAtasan.setText(intent.getStringExtra("kjNamaAtasan"));
        edEmailAtasan.setText(intent.getStringExtra("kjEmailAtasan"));
        edHpAtasan.setText(intent.getStringExtra("kjHpAtasan"));

        ArrayAdapter<String> spinnerPekerjaan = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.pekerjaan));
        pekerjaan.setAdapter(spinnerPekerjaan);

        ArrayAdapter<String> spinnerBidang = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.bidang));
        bidang.setAdapter(spinnerBidang);

        ArrayAdapter<String> spinnerPenghasilan = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.penghasilan));
        penghasilan.setAdapter(spinnerPenghasilan);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arrow_back:
                AlertDialog.Builder builder = new AlertDialog.Builder(UpdatePekerjaanActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setIcon(R.drawable.app);
                builder.setMessage("Yakin ingin kembali");
                builder.setPositiveButton("Ya", ((dialogInterface, i) -> {
                    startActivity(new Intent(this, PekerjaanActivity.class));
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
        AlertDialog.Builder builder = new AlertDialog.Builder(UpdatePekerjaanActivity.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setIcon(R.drawable.app);
        builder.setMessage("Yakin ingin kembali");
        builder.setPositiveButton("Ya", ((dialogInterface, i) -> {
            startActivity(new Intent(this, PekerjaanActivity.class));
            overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
        }
        ));
        builder.setNegativeButton("Tidak", (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });
        builder.show();
    }
}