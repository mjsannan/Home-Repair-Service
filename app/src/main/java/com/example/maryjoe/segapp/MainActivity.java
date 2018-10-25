package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class  MainActivity extends AppCompatActivity implements View.OnClickListener{


    public static final String EXTRA_MESSAGE = "com.example.HomeRepairService.MESSAGE";

    private FirebaseAuth mAuth2;
    EditText editTextemail, editTextpassword;
    ProgressBar progBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextemail = (EditText) findViewById(R.id.signInEmail);
        editTextpassword = (EditText) findViewById(R.id.signInPassword);
        progBar = (ProgressBar) findViewById(R.id.progressBar);
        mAuth2 = FirebaseAuth.getInstance();

        findViewById(R.id.btnSignIn).setOnClickListener(this);
    }

    private void userLogin(){

        String email = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();

        if(email.isEmpty()){
            editTextemail.setError("Email is needed");
            editTextemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Enter correct email");
            editTextemail.requestFocus();
            return;

        }

        if(password.isEmpty()){
            editTextpassword.setError("Password is needed");
            editTextpassword.requestFocus();
            return;
        }

        if(password.length()<6){
            editTextpassword.setError("Password should be more than six characters");
            editTextpassword.requestFocus();
            return;
        }

        progBar.setVisibility(View.VISIBLE);
        mAuth2.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Intent intent = new Intent(MainActivity.this, WelcomePage.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSignIn:
                userLogin();
                break;
        }
    }

    public void sendMessage(View view){
        // opens a new activity when the sign up button is pushed
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.signInEmail);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendMessage2(View view) {
        // opens a new activity when the sign in button is pushed
        Intent intent = new Intent(this, WelcomePage.class);
        EditText editText = (EditText) findViewById(R.id.signInEmail);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }



}

