package com.esprit.scluptfit.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.utils.Database;
import com.esprit.scluptfit.utils.MYService;
import com.google.android.material.textfield.TextInputLayout;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout email,password;
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    MYService myService;

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void SignUp(View view) {
        Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intent);
    }


    private  Boolean validatEmail(){
        email=(TextInputLayout) findViewById(R.id.email);
        String val=email.getEditText().getText().toString();

        if (val.isEmpty()){
            email.setError("Field cannot be empty !!00");
            return false;
        }else {
            email.setError(null);
            email.setErrorEnabled(false);
            return  true;
        }

    }

    private  Boolean validatPassword(){
        password=(TextInputLayout) findViewById(R.id.password);
        String val=password.getEditText().getText().toString();

        if (val.isEmpty()){
            password.setError("Field cannot be empty");
            return false;
        }else {
            password.setError(null);
            password.setErrorEnabled(false);
            return  true;
        }

    }

    public  void loginUser(View view){
        if (!validatEmail() | !validatPassword()){
            return;
        } else {
            isUser();
        }
    }



   public void isUser() {
        email=(TextInputLayout) findViewById(R.id.email);
        password=(TextInputLayout) findViewById(R.id.password);

        String userEnteredEmail=email.getEditText().getText().toString().trim();
        String userEnteredPassword=password.getEditText().getText().toString().trim();
      // Toast.makeText(this," userEnteredEmail :"+userEnteredEmail,Toast.LENGTH_LONG).show();
       //init service
       Retrofit database= Database.getInstance();
       myService=database.create(MYService.class);

       compositeDisposable.add(myService.loginUser(userEnteredEmail,userEnteredPassword)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Consumer<String>() {
                   @Override
                   public void accept(String s) throws Exception {
                        Toast.makeText(LoginActivity.this," "+s,Toast.LENGTH_LONG).show();
                   }
               })


       );
        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
    }

}