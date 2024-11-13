package com.naufalazryan.alumnimipaulm;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class AboutActivity extends YouTubeBaseActivity implements View.OnClickListener {

    YouTubePlayerView youtubePlayerView;
    TextView visiMisi, sejarah;
    LinearLayout linearLayout, linearLayout2, linearLayout3;
    Button btnWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        findViewById(R.id.arrow_back).setOnClickListener(this);

        youtubePlayerView = findViewById(R.id.youtube_player_view);
        btnWeb = findViewById(R.id.btnWeb);
        visiMisi = findViewById(R.id.visiMisi);
        sejarah = findViewById(R.id.sejarah);
        linearLayout = findViewById(R.id.linearLayout);
        linearLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        YouTubePlayer.OnInitializedListener listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("ZdRou0Mf2mk");
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(), "Inisialisasi Gagal", Toast.LENGTH_SHORT).show();
            }
        };


        youtubePlayerView.initialize("AIzaSyDo_SDa4yinCXWkt3RCYFX-5J9uMjrsTwQ", listener);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://fmipa.ulm.ac.id")));
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
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.slide_from_top, android.R.anim.accelerate_decelerate_interpolator);
    }

    public void expand(View view) {
        int v = (visiMisi.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(linearLayout,  new AutoTransition());
            visiMisi.setVisibility(v);
    }

    public void expandd(View view) {
        int v = (sejarah.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(linearLayout2, new AutoTransition());
        sejarah.setVisibility(v);
    }

    public void expanddd(View view) {
        int v = (btnWeb.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(linearLayout3, new AutoTransition());
        btnWeb.setVisibility(v);
    }
}