package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {
    EditText email,name,password;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        name=findViewById(R.id.edit_text_name);
        email=findViewById(R.id.edit_text_email);
        password=findViewById(R.id.edit_text_password);

        auth=FirebaseAuth.getInstance();

    }

    public void signin(View view) {
        String useremail=email.getText().toString();
        String userepassword=password.getText().toString();


  if(TextUtils.isEmpty(useremail)){
      Toast.makeText(this,"Enter Email Address!",Toast.LENGTH_SHORT).show();
      return;



  }
  if(TextUtils.isEmpty(userepassword)){
      Toast.makeText(this,"Enter Password!",Toast.LENGTH_SHORT).show();
      return;
  }
  if(password.getText().length()<6){
      Toast.makeText(this,"Password To Shor,Enter Minimum 6 Characters!",Toast.LENGTH_SHORT).show();
      return;

  }
  auth.signInWithEmailAndPassword(useremail,userepassword)
          .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  if(task.isSuccessful()){
                      Toast.makeText(LoginActivity.this,"Successfully Login",Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(LoginActivity.this,MainActivity.class));

                  }
                  else{
                      Toast.makeText(LoginActivity.this,"Error "+task.getException(),Toast.LENGTH_SHORT).show();

                  }

              }
          });



    }

    public void signp(View view) {
        startActivity(new Intent(LoginActivity.this,RegistrionActivity.class));

    }


}