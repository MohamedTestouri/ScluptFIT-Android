package com.esprit.scluptfit.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.esprit.scluptfit.R;

import java.net.InetAddress;

import static com.esprit.scluptfit.services.UserService.sharedPrefFile;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000;
    //variables
    Animation topAnim, bottomAnim;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        image = findViewById(R.id.img);
        image.setAnimation(topAnim);
        if (isNetworkConnected()) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, StartActivity.class);
                        Pair[] pairs = new Pair[1];
                        pairs[0] = new Pair<View, String>(image, "logo_image");
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                        if (getSharedPreferences(sharedPrefFile, MODE_PRIVATE).contains("currentUser"))
                        {
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        }else {
                            startActivity(intent, options.toBundle());
                        }
                        finish();
                    }
                }, SPLASH_SCREEN);

        } else {
            Toast.makeText(this, "Device is not connected!", Toast.LENGTH_LONG).show();
        }
    }

    public boolean isInternetAvailable() {
        try {
            InetAddress inetAddress = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !inetAddress.equals("");

        } catch (Exception e) {
            return false;
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }


}