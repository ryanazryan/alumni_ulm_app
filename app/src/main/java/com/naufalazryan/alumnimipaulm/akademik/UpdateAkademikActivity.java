package com.naufalazryan.alumnimipaulm.akademik;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.naufalazryan.alumnimipaulm.AboutActivity;
import com.naufalazryan.alumnimipaulm.ModelResponse.AlumniModelResponse.AlumniResponse;
import com.naufalazryan.alumnimipaulm.ModelResponse.SpinnerModelResponse.DosenDataModel;
import com.naufalazryan.alumnimipaulm.ModelResponse.SpinnerModelResponse.DosenResponse;
import com.naufalazryan.alumnimipaulm.R;
import com.naufalazryan.alumnimipaulm.SessionManager;
import com.naufalazryan.alumnimipaulm.UtilsApi;
import com.naufalazryan.alumnimipaulm.api.APIService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateAkademikActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edAluSkripsi, edAluDsnPuLain, edAluDsnPpLain, edAluDsnPg1Lain, edAluDsnPg2Lain;
    SessionManager sessionManager;
    ProgressDialog loading;
    Button btnUpdate;
    String upAluSkripsi, upAluNim, upAluDsnPuLain, upAluDsnPpLain, upAluDSnPg1Lain, upAluDsnPg2Lain;
    @BindView(R.id.dosenPA)
    Spinner listDosen;
    @BindView(R.id.dosenPU)
    Spinner listDosen2;
    @BindView(R.id.dosenPP)
    Spinner listDosen3;
    @BindView(R.id.dosenPG1)
    Spinner listDosen4;
    @BindView(R.id.dosenPG2)
    Spinner listDosen5;
    Context context;
    APIService apiService;


    List<String> listSpinnerDosen = new ArrayList<>();
    List<String> listSpinnerDosenNip = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_akademik);


        findViewById(R.id.arrow_back).setOnClickListener(this);
        findViewById(R.id.about).setOnClickListener(this);
        btnUpdate = findViewById(R.id.btnUpdate);
        TextView activity = findViewById(R.id.activity);
        activity.setText("Update Akademik");

        sessionManager = new SessionManager(UpdateAkademikActivity.this);
        edAluSkripsi = findViewById(R.id.judulSkripsi);
        edAluDsnPuLain = findViewById(R.id.dosenPuLain);
        edAluDsnPpLain = findViewById(R.id.dosenPpLain);
        edAluDsnPg1Lain = findViewById(R.id.dosenPg1Lain);
        edAluDsnPg2Lain = findViewById(R.id.dosenPg2Lain);


        upAluNim = sessionManager.getUserDetail().get(SessionManager.ALU_NIM);
        upAluDsnPuLain = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PU_LAIN);
        upAluDsnPpLain = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PP_LAIN);
        upAluDSnPg1Lain = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PG_1_LAIN);
        upAluDsnPg2Lain = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PG_2_LAIN);
        upAluSkripsi = sessionManager.getUserDetail().get(SessionManager.ALU_JUDUL_SKRIPSI);

        edAluDsnPuLain.setText(upAluDsnPuLain);
        edAluDsnPpLain.setText(upAluDsnPpLain);
        edAluDsnPg1Lain.setText(upAluDSnPg1Lain);
        edAluDsnPg2Lain.setText(upAluDsnPg2Lain);
        edAluSkripsi.setText(upAluSkripsi);



        ButterKnife.bind(this);
        context = this;
        apiService = UtilsApi.getAPIService();

        initSpinnerDosen();

        listDosen.getBackground().setColorFilter(Color.parseColor("#0168FA"), PorterDuff.Mode.MULTIPLY);
        listDosen2.getBackground().setColorFilter(Color.parseColor("#0168FA"), PorterDuff.Mode.MULTIPLY);
        listDosen3.getBackground().setColorFilter(Color.parseColor("#0168FA"), PorterDuff.Mode.MULTIPLY);
        listDosen4.getBackground().setColorFilter(Color.parseColor("#0168FA"), PorterDuff.Mode.MULTIPLY);
        listDosen5.getBackground().setColorFilter(Color.parseColor("#0168FA"), PorterDuff.Mode.MULTIPLY);


        listDosen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String getNamaDosen = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(context, "Pilih Dosen " + getNamaDosen, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listDosen2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String getNamaDosen = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(context, "Pilih Dosen " + getNamaDosen, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listDosen3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String getNamaDosen = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(context, "Pilih Dosen " + getNamaDosen, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listDosen4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedName = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(context, "Pilih Dosen " + selectedName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listDosen5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String getNamaDosen = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(context, "Pilih Dosen " + getNamaDosen, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnUpdate.setOnClickListener(view -> {
            int posSelectedPa = listDosen.getSelectedItemPosition();
            int posSelectedPu = listDosen2.getSelectedItemPosition();
            int posSelectedPp = listDosen3.getSelectedItemPosition();
            int posSelectedPg1 = listDosen4.getSelectedItemPosition();
            int posSelectedPg2 = listDosen5.getSelectedItemPosition();
            String nipDosenPA = listSpinnerDosenNip.get(posSelectedPa);
            String nipDosenPU = listSpinnerDosenNip.get(posSelectedPu);
            String nipDosenPP = listSpinnerDosenNip.get(posSelectedPp);
            String nipDosenPG1 = listSpinnerDosenNip.get(posSelectedPg1);
            String nipDosenPG2 = listSpinnerDosenNip.get(posSelectedPg2);
            String dosenPuLain="";

            if (posSelectedPu == 0){
                dosenPuLain=edAluDsnPuLain.getText().toString();
            }
//                Log.d("posSelected",nipDosenPA);
            Call<AlumniResponse> update = apiService.updateAkademik(
                    upAluNim,
                    nipDosenPA,
                    edAluSkripsi.getText().toString(),
                    nipDosenPU,
                    nipDosenPP,
                    nipDosenPG1,
                    nipDosenPG2,
                    dosenPuLain,
                    edAluDsnPpLain.getText().toString(),
                    edAluDsnPg1Lain.getText().toString(),
                    edAluDsnPg2Lain.getText().toString()
                   );

            update.enqueue(new Callback<AlumniResponse>() {
                @Override
                public void onResponse(Call<AlumniResponse> call, Response<AlumniResponse> response) {

                    sessionManager.setAluDsnPaNama(response.body().getData().getAluDsnPaNama());
                    sessionManager.setAluJudulSkripsi(response.body().getData().getAluJudulSkripsi());
                    sessionManager.setAluDsnPuNama(response.body().getData().getAluDsnPuNama());
                    sessionManager.setAluDsnPpNama(response.body().getData().getAluDsnPpNama());
                    sessionManager.setAluDsnPg1Nama(response.body().getData().getAluDsnPg1Nama());
                    sessionManager.setAluDsnPg2Nama(response.body().getData().getAluDsnPg2Nama());
                    sessionManager.setAluDsnPuLain(response.body().getData().getAluDsnPuLain());
                    sessionManager.setAluDsnPpLain(response.body().getData().getAluDsnPpLain());
                    sessionManager.setAluDsnPg1Lain(response.body().getData().getAluDsnPg1Lain());
                    sessionManager.setAluDsnPg2Lain(response.body().getData().getAluDsnPg2Lain());
                    Toast.makeText(UpdateAkademikActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateAkademikActivity.this, AkademikActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<AlumniResponse> call, Throwable t) {
                    loading.hide();
                    Log.d("Akademik", "On Failure");
                }
            });
        });
    }

    private void initSpinnerDosen() {
        apiService.getListDosen().enqueue(new Callback<DosenResponse>() {
            @Override
            public void onResponse(Call<DosenResponse> call, Response<DosenResponse> response) {
                if(response.isSuccessful()){
                    List<DosenDataModel> dosenDataModel = response.body().getData();


                    String DosenPA = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PA_NAMA);
                    String DosenPU = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PU_NAMA);
                    String DosenPP = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PP_NAMA);
                    String DosenPG1 = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PG_1_NAMA);
                    String DosenPG2 = sessionManager.getUserDetail().get(SessionManager.ALU_DSN_PG_2_NAMA);

                    int defaultPosition = 0;
                    int defaultPosition2 = 0;
                    int defaultPosition3 = 0;
                    int defaultPosition4 = 0;
                    int defaultPosition5 = 0;


                    for (int i = 0; i < dosenDataModel.size(); i++){
                        listSpinnerDosen.add(dosenDataModel.get(i).getDsnNama());
                        listSpinnerDosenNip.add(dosenDataModel.get(i).getDsnNip());
                        if (dosenDataModel.get(i).getDsnNama()!=null) {
                            if (DosenPA!=null) {
                                if (DosenPA.equalsIgnoreCase(dosenDataModel.get(i).getDsnNama())) {
                                    defaultPosition = i;
                                }
                            }

                            if (DosenPU!=null) {
                                if (DosenPU.equalsIgnoreCase(dosenDataModel.get(i).getDsnNama())) {
                                    defaultPosition2 = i;
                                }
                            }
                            if (DosenPP!=null) {
                                if (DosenPP.equalsIgnoreCase(dosenDataModel.get(i).getDsnNama())) {
                                    defaultPosition3 = i;
                                }
                            }
                            if (DosenPG1!=null) {
                                if (DosenPG1.equalsIgnoreCase(dosenDataModel.get(i).getDsnNama())) {
                                    defaultPosition4 = i;
                                }
                            }
                            if (DosenPG2!=null) {
                                if (DosenPG2.equalsIgnoreCase(dosenDataModel.get(i).getDsnNama())) {
                                    defaultPosition5 = i;
                                }
                            }
                        }
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>
                            (context, android.R.layout.simple_spinner_item, listSpinnerDosen);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    listDosen.setAdapter(adapter);
                    listDosen.setSelection(defaultPosition);
                    listDosen2.setAdapter(adapter);
                    listDosen2.setSelection(defaultPosition2);
                    listDosen3.setAdapter(adapter);
                    listDosen3.setSelection(defaultPosition3);
                    listDosen4.setAdapter(adapter);
                    listDosen4.setSelection(defaultPosition4);
                    listDosen5.setAdapter(adapter);
                    listDosen5.setSelection(defaultPosition5);

                } else {
                    loading.dismiss();
                    Toast.makeText(context, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DosenResponse> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(context, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arrow_back:
                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateAkademikActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setIcon(R.drawable.app);
                builder.setMessage("Yakin ingin kembali");
                builder.setPositiveButton("Ya", ((dialogInterface, i) -> {
                    startActivity(new Intent(this, AkademikActivity.class));
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
        AlertDialog.Builder builder = new AlertDialog.Builder(UpdateAkademikActivity.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setIcon(R.drawable.app);
        builder.setMessage("Yakin ingin kembali");
        builder.setPositiveButton("Ya", ((dialogInterface, i) -> {
            startActivity(new Intent(this, AkademikActivity.class));
            overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
        }
        ));
        builder.setNegativeButton("Tidak", (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });
        builder.show();
    }

}