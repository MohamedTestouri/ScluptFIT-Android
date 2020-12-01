package com.esprit.scluptfit.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.esprit.scluptfit.R;

public class MainActivity extends AppCompatActivity {
    private static  int SPLASH_SCREEN = 5000;
    //variables
    Animation topAnim,bottomAnim;
    ImageView image;
    Intent intent;
    SharedPreferences sp;
    public final static String PREFS = "Settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sp = this.getSharedPreferences(PREFS,MODE_PRIVATE);
        if(sp.contains("isLogged")){
            intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image =findViewById(R.id.img);
        image.setAnimation(topAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, StartActivity.class);
                Pair[] pairs=new Pair[1];
                pairs[0]=new Pair<View,String>(image,"logo_image");
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(intent,options.toBundle());
                finish();
            }
        },SPLASH_SCREEN) ;


    }


}