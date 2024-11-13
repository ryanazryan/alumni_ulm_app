package com.naufalazryan.alumnimipaulm.biodata;

import static com.naufalazryan.alumnimipaulm.Config.IMAGE_URL;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import com.naufalazryan.alumnimipaulm.AboutActivity;
import com.naufalazryan.alumnimipaulm.MainActivity;
import com.naufalazryan.alumnimipaulm.ModelResponse.AlumniModelResponse.AlumniResponse;
import com.naufalazryan.alumnimipaulm.R;
import com.naufalazryan.alumnimipaulm.SessionManager;
import com.naufalazryan.alumnimipaulm.api.APIService;
import com.naufalazryan.alumnimipaulm.api.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiodataActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvNim, tvNama, tvJk, tvAlamat, tvTelp, tvEmail;
    SessionManager sessionManager;
    ImageView gantiProfil;
    CircleImageView profil;
    String aluNim, nama, jk, alamat, telp, email;
    APIService apiService = RetrofitClient.getClient().create(APIService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);
        view();

    }


    @Override
    protected void onResume() {
        super.onResume();
        view();
    }

    @SuppressLint("SetTextI18n")
    private void view(){

        gantiProfil = findViewById(R.id.gantiProfil);
        profil = findViewById(R.id.bioGambar);
        tvNim = findViewById(R.id.nim);
        tvNama = findViewById(R.id.nama);
        tvJk = findViewById(R.id.jk);
        tvAlamat = findViewById(R.id.alamat);
        tvTelp = findViewById(R.id.no_telp);
        tvEmail = findViewById(R.id.email);


//        btnUpdate = findViewById(R.id.btnUpdate);
        findViewById(R.id.arrow_back).setOnClickListener(this);
        findViewById(R.id.btnUpdate).setOnClickListener(this);
        findViewById(R.id.about).setOnClickListener(this);



        TextView activity = findViewById(R.id.activity);
        activity.setText("Biodata");

        sessionManager = new SessionManager(BiodataActivity.this);

        aluNim = sessionManager.getUserDetail().get(SessionManager.ALU_NIM);
        nama = sessionManager.getUserDetail().get(SessionManager.ALU_NAMA);
        jk = sessionManager.getUserDetail().get(SessionManager.ALU_JK);
        alamat = sessionManager.getUserDetail().get(SessionManager.ALU_ALAMAT);
        telp = sessionManager.getUserDetail().get(SessionManager.ALU_HP);
        email = sessionManager.getUserDetail().get(SessionManager.ALU_EMAIL);



        tvNim.setText(aluNim);
        tvNama.setText(nama);
        if (!(jk==null)) {
            tvJk.setText((jk.equalsIgnoreCase("P") ? "Wanita" : "Pria"));
        }
        tvAlamat.setText(alamat);
        tvTelp.setText(telp);
        tvEmail.setText(email);


        Picasso.get().load(IMAGE_URL + sessionManager.getFoto()).into(profil);

        gantiProfil.setOnClickListener(v -> selectImage());
    }

    private void selectImage() {
        final CharSequence[] items = {"Choose From Gallery","Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(BiodataActivity.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setIcon(R.drawable.app);
        builder.setItems(items, (dialog, item) -> {
            // mengambil foto
            if(items[item].equals("Choose From Gallery")){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Image"), 20);
            } else if (items[item].equals("Cancel")){
                // membuka galeri
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(this, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20 && resultCode == RESULT_OK && data != null){

            final Uri path = data.getData();
            File file = new File(getRealPathFromURI(path));
            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part foto = MultipartBody.Part.createFormData("foto", file.getName(), reqFile);
            RequestBody nim = RequestBody.create(MediaType.parse("text/plain"), aluNim);
            Log.d("test",path.toString());
            Call<AlumniResponse> req = apiService.uploadImage(foto, nim);
            Log.d("test",req.toString());
            req.enqueue(new Callback<AlumniResponse>() {
                @Override
                public void onResponse(Call<AlumniResponse> call, Response<AlumniResponse> response) {
                    if (response.body().isStatus()){
                        String foto = response.body().getData().getAluFoto();
                        sessionManager.setAluFoto(foto);
                        Picasso.get().load(IMAGE_URL + foto).fit().into(profil);
                    }
                    Log.d("test",response.body().getData().getAluFoto().toString());
                }

                @Override
                public void onFailure(Call<AlumniResponse> call, Throwable t) {
                    t.printStackTrace();
                    Log.d("test", t.getCause().getMessage().toString());
                    Log.d("test", t.getMessage().toString());
                }
            });


            Thread thread = new Thread(() -> {
                try {
                    InputStream inputStream = getContentResolver().openInputStream(path); // ambil path ke inputStream
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream); // decode ke Bitmap
                    profil.post(() -> {
                        profil.setImageBitmap(bitmap); // bitmap ditampilkan ke avatar
                    });
                } catch (IOException e){
                    e.printStackTrace();
                }
            });
            thread.start();

            
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.arrow_back:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
                break;
            case R.id.btnUpdate:
                startActivity(new Intent(this, UpdateBiodataActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
                break;
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
    }
}