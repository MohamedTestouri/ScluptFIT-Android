package com.esprit.scluptfit.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.services.PostService;
import com.esprit.scluptfit.services.UserService;

import org.json.JSONException;

public class StartActivity extends AppCompatActivity {
    Animation topAnim,bottomAnim;
    private Button signupButton;
    TextView slogan1,slogan3;
    PostService postService = new PostService();
    UserService userService = new UserService();
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
        signupButton = findViewById(R.id.signupButton);
        signupButton.setOnClickListener(l->{signup();});
    }

    public void login(View view) {
/*  Intent intent=new Intent(StartActivity.this,LoginActivity.class);
        startActivity(intent);*/
        userService.addRun();
        //postService.addComment();

    }

    public void signup() {
        Intent intent=new Intent(StartActivity.this, HomeActivity.class);
        startActivity(intent);

    }
}