package com.esprit.scluptfit.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.esprit.scluptfit.R;

public class StartActivity extends AppCompatActivity {
    Animation topAnim,bottomAnim;
    TextView slogan1,slogan3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        slogan1 =findViewById(R.id.logo_name1);
        slogan1.setAnimation(bottomAnim);
        slogan3 =findViewById(R.id.logo_nam2);
        slogan3.setAnimation(topAnim);
    }

    public void login(View view) {

        Intent intent=new Intent(StartActivity.this,LoginActivity.class);
        startActivity(intent);


    }
}