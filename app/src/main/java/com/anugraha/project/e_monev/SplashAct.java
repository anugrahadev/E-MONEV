package com.anugraha.project.e_monev;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashAct extends AppCompatActivity {
    ImageView app_logo;
    TextView app_tagline,app_desc;
    Animation app_splash,tagline_to_top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //load
        app_logo = findViewById(R.id.app_logo);
        app_tagline = findViewById(R.id.tv1);
        app_desc = findViewById(R.id.tv2);
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        tagline_to_top = AnimationUtils.loadAnimation(this,R.anim.bottom_to_top);

        //run animation
        app_logo.startAnimation(app_splash);
        app_tagline.startAnimation(tagline_to_top);
        app_desc.startAnimation(tagline_to_top);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //berpindah acvitivy (intent)
                Intent goGetHome = new Intent(SplashAct.this, LoginAct.class);
                startActivity(goGetHome);
                finish();
            }
        },2000);

    }
}
