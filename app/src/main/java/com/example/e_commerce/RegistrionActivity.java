package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.FeatureGroupInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class RegistrionActivity extends AppCompatActivity {

    EditText name,password,mail;
    private FirebaseAuth auth;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrion);

        getSupportActionBar().hide();

        name=findViewById(R.id.edit_text_name);
        mail=findViewById(R.id.edit_text_email);
        password=findViewById(R.id.edit_text_password);


        sharedPreferences=getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
        boolean isfirestTime=sharedPreferences.getBoolean("FirstTime",true);
        if (isfirestTime){
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("First Time",false);
            editor.commit();
            Intent intent=new Intent(RegistrionActivity.this,OnBoardingActivity.class);
            startActivity(intent);
            finish();
        }


        auth=FirebaseAuth.getInstance();
        if (auth.getCurrentUser()!=null){
            startActivity(new Intent(RegistrionActivity.this,MainActivity.class));
            finish();
        }



    }



    public void signUp(View view) {

        String username=name.getText().toString();
        String useremail=mail.getText().toString();
        String userpassword=password.getText().toString();


        if (TextUtils.isEmpty(username)){
            Toast.makeText(this,"Enter Name!",Toast.LENGTH_SHORT).show();
            return;

        }


        if (TextUtils.isEmpty(useremail)){
            Toast.makeText(this,"Enter Email Address!",Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(userpassword)){
            Toast.makeText(this,"Enter Password!",Toast.LENGTH_SHORT).show();
            return;

        }

        if (userpassword.length()<6){
            Toast.makeText(this,"Password To Shor,Enter Minimum 6 Characters!",Toast.LENGTH_SHORT).show();
            return;

        }

    auth.createUserWithEmailAndPassword(useremail,userpassword)
            .addOnCompleteListener(RegistrionActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull  Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegistrionActivity.this,"Successfully Register  ",Toast.LENGTH_SHORT).show();

                    }
                    else  {

                        Toast.makeText(RegistrionActivity.this," Registration Failed "+task.getException(),Toast.LENGTH_SHORT).show();
                    }

                }

            });








    }



    public void signin(View view) {

        startActivity(new Intent(RegistrionActivity.this,LoginActivity.class));
    }







}