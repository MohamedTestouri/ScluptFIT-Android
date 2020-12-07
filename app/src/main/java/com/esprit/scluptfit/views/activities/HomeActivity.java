package com.esprit.scluptfit.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.widget.Button;
import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.views.fragments.ExerciceFragement;
import com.esprit.scluptfit.views.fragments.ForumFragment;
import com.esprit.scluptfit.views.fragments.ProfileFragment;
import com.esprit.scluptfit.views.fragments.HomeFragment;
import com.esprit.scluptfit.views.fragments.LocationFragment;
import com.esprit.scluptfit.views.fragments.RunningFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
private Button button;
private ArrayList<Exercice> exerciceArrayList = new ArrayList<>();
ChipNavigationBar chipNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();
chipNavigationBar.setItemSelected(R.id.home, true);
        bottomMenu();
    }

    private void bottomMenu() {

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment=null;
                switch (i){
                    case R.id.home:
                        fragment=new HomeFragment();
                        break;
                   /* case R.id.location:
                        fragment=new LocationFragment();
                        break;*/
                    case R.id.fitness:
                        fragment=new ExerciceFragement();
                        break;
                    case R.id.profile:
                        fragment=new ProfileFragment();
                        break;
                    case R.id.forum:
                        fragment=new ForumFragment();
                        break;
                    case R.id.running:
                        fragment=new RunningFragment();
                        break;



                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
            }
        });

    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}