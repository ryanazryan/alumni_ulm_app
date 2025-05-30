package com.naufalazryan.alumnimipaulm.pendidikan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.naufalazryan.alumnimipaulm.AboutActivity;
import com.naufalazryan.alumnimipaulm.MainActivity;
import com.naufalazryan.alumnimipaulm.ModelResponse.PendidikanModelResponse.PendidikanDataModel;
import com.naufalazryan.alumnimipaulm.ModelResponse.PendidikanModelResponse.PendidikanResponse;
import com.naufalazryan.alumnimipaulm.R;
import com.naufalazryan.alumnimipaulm.SessionManager;
import com.naufalazryan.alumnimipaulm.api.APIService;
import com.naufalazryan.alumnimipaulm.api.RetrofitClient;
import com.naufalazryan.alumnimipaulm.biodata.UpdateBiodataActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendidikanActivity extends AppCompatActivity implements View.OnClickListener {

    SessionManager sessionManager;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    APIService apiService;
    String nim;
    public static PendidikanActivity pendidikanActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendidikan);
        view();


    }

        private void view() {
            sessionManager = new SessionManager(this);
            layoutManager = new LinearLayoutManager(this);
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(layoutManager);
            apiService = RetrofitClient.getClient().create(APIService.class);
            nim = sessionManager.getUserDetail().get(SessionManager.ALU_NIM);
            pendidikanActivity = this;
            refresh();

            findViewById(R.id.arrow_back).setOnClickListener(this);
            findViewById(R.id.about).setOnClickListener(this);
            findViewById(R.id.btnTambah).setOnClickListener(this);

            TextView activity = findViewById(R.id.activity);
            activity.setText("Pendidikan");

        }

        private void refresh() {
            Call<PendidikanResponse> pendidikan = apiService.readPendidikan(nim);
            Log.d("response",nim);
            pendidikan.enqueue(new Callback<PendidikanResponse>() {
                @Override
                public void onResponse(Call<PendidikanResponse> call, Response<PendidikanResponse> response) {
                    List<PendidikanDataModel> pendidikanDataModel = response.body().getData();
                    Log.d("response",pendidikanDataModel.toString());
                    adapter = new PendidikanAdapter(pendidikanDataModel);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<PendidikanResponse> call, Throwable t) {
                    Log.d("Retrofit Get", t.toString());
                }
            });
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arrow_back:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
                break;
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
                break;
            case R.id.btnTambah:
                startActivity(new Intent(this, AddPendidikanActivity.class));
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