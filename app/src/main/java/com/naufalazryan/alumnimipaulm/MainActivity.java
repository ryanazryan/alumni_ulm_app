package com.naufalazryan.alumnimipaulm;

import static com.naufalazryan.alumnimipaulm.Config.IMAGE_URL;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.naufalazryan.alumnimipaulm.akademik.AkademikActivity;
import com.naufalazryan.alumnimipaulm.biodata.BiodataActivity;
import com.naufalazryan.alumnimipaulm.carousel.SlideAdapter;
import com.naufalazryan.alumnimipaulm.carousel.SlideItem;
import com.naufalazryan.alumnimipaulm.galeri.GaleriActivity;
import com.naufalazryan.alumnimipaulm.pekerjaan.PekerjaanActivity;
import com.naufalazryan.alumnimipaulm.pendidikan.PendidikanActivity;
import com.naufalazryan.alumnimipaulm.sosmed.SosialMediaActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvNama;
    CircleImageView profil;
    SessionManager sessionManager;
    String nama;
    ViewPager2 viewPager2;
    private Handler slideHandler = new Handler();


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);

        tvNama = findViewById(R.id.nama);

        // ImageView ID
        profil = findViewById(R.id.profil);
        findViewById(R.id.biodata).setOnClickListener(this);
        findViewById(R.id.sosmed).setOnClickListener(this);
        findViewById(R.id.pendidikan).setOnClickListener(this);
        findViewById(R.id.pekerjaan).setOnClickListener(this);
        findViewById(R.id.akademik).setOnClickListener(this);
        findViewById(R.id.galeri).setOnClickListener(this);

        // Constraint Layout ID
       findViewById(R.id.biodata2).setOnClickListener(this);
       findViewById(R.id.sosmed2).setOnClickListener(this);
       findViewById(R.id.pendidikan2).setOnClickListener(this);
       findViewById(R.id.pekerjaan2).setOnClickListener(this);
       findViewById(R.id.akademik2).setOnClickListener(this);
       findViewById(R.id.galeri2).setOnClickListener(this);

        viewPager2 = findViewById(R.id.viewPager);

        nama = sessionManager.getUserDetail().get(SessionManager.ALU_NAMA);
        tvNama.setText(nama);


        profil.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ProfileActivity.class)));

        Picasso.get().load(IMAGE_URL + sessionManager.getFoto()).into(profil);

        List<SlideItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SlideItem(R.drawable.slide3));
        sliderItems.add(new SlideItem(R.drawable.slide4));
        sliderItems.add(new SlideItem(R.drawable.slide2));
        sliderItems.add(new SlideItem(R.drawable.slide1));

        viewPager2.setAdapter(new SlideAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(4);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r*0.15f);

        });

        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(slideRunnable);
                slideHandler.postDelayed(slideRunnable, 3000);
            }
        });
    }

    private final Runnable slideRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }

    };

    @Override
    protected void onPause(){
        super.onPause();
        slideHandler.removeCallbacks(slideRunnable);
    }

    @Override
    protected void onResume(){
        super.onResume();
        slideHandler.postDelayed(slideRunnable, 3000);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.biodata:
            case R.id.biodata2:
                startActivity(new Intent(this, BiodataActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);

                break;
            case R.id.pendidikan:
            case R.id.pendidikan2:
                startActivity(new Intent(this, PendidikanActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);

                break;
            case R.id.pekerjaan:
            case R.id.pekerjaan2:
                startActivity(new Intent(this, PekerjaanActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);

                break;
            case R.id.akademik:
                startActivity(new Intent(this, AkademikActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
                break;
            case R.id.sosmed:
            case R.id.sosmed2:
                startActivity(new Intent(this, SosialMediaActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
                break;
            case R.id.galeri:
            case R.id.galeri2:
                startActivity(new Intent(this, GaleriActivity.class));
                overridePendingTransition(R.anim.slide_from_bottom, android.R.anim.accelerate_decelerate_interpolator);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setIcon(R.drawable.app);
        builder.setMessage("Apakah anda ingin keluar dari aplikasi?");
        builder.setPositiveButton("Iya", (dialogInterface, i) -> finishAffinity());
        builder.setNegativeButton("Tidak", (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });
        builder.show();
    }
}