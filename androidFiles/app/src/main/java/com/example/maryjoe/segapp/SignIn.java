package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class SignIn extends AppCompatActivity implements View.OnClickListener {


    public static final String EXTRA_MESSAGE = "com.example.HomeRepairService.MESSAGE";

    private FirebaseAuth mAuth2;
    EditText editTextemail, editTextpassword;
    ProgressBar progBar;

    String emailString, passwordString;

    // used to determine if user is admin
    public static DatabaseReference mDatabase;
    public static FirebaseDatabase mFirebaseDatabase;
    public static FirebaseAuth mAuth;

    EditText emailTextEdit;
    String emailLoggingIn;

    public ArrayList<String> account = new ArrayList<>();

    public static ArrayList<Long> arrayUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        editTextemail = (EditText) findViewById(R.id.signInEmail);
        editTextpassword = (EditText) findViewById(R.id.signInPassword);
        progBar = (ProgressBar) findViewById(R.id.progressBar);
        mAuth2 = FirebaseAuth.getInstance();

        // initilizing what will be used to determine if user is admin
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = mFirebaseDatabase.getReference();

        emailTextEdit = (EditText) findViewById(R.id.signInEmail);
        emailLoggingIn = emailTextEdit.getText().toString();

        findViewById(R.id.btnSignIn).setOnClickListener(this);

        mDatabase = FirebaseDatabase.getInstance().getReference("Users");
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    account.add(postSnapshot.getValue().toString());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("failTAG", "loadPost:onCancelled", databaseError.toException());
            }
        };
        mDatabase.addValueEventListener(postListener);
    }


    private void userLogin() {

        String email = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();

        if(email.isEmpty()){
            editTextemail.setError("Email required");
            editTextemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Incorrect Email");
            editTextemail.requestFocus();
            return;

        }

        if(password.isEmpty()){
            editTextpassword.setError("Password required");
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
                String e = editTextemail.getText().toString().trim();
                if(task.isSuccessful() && !e.equals("admintest@yahoo.com")){
                    Intent intent = new Intent(SignIn.this, WelcomePage.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
                else if (task.isSuccessful() && e.equals("admintest@yahoo.com")){
                    Intent intent = new Intent(SignIn.this, AdminHome.class);
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
        if (Arrays.asList(arrayUsers).contains(emailLoggingIn)) {
            Log.d("ACCOUNT TYPE", "PLs work thx");
            // opens a new activity when you sign up
            Intent intent = new Intent(this, AdminHome.class);
            startActivity(intent);
        } else {
            switch (v.getId()) {
                case R.id.btnSignIn:
                    userLogin();
                    break;
                case R.id.btnSignUp:
                    goToSignUp();
                    break;
            }
        }
    }

    public void goToSignUp(){
        // opens a new activity when the sign up button is pushed
        Intent intent = new Intent(this, SignUp.class);
        //EditText editText = (EditText) findViewById(R.id.signInEmail);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void goToWelcome(View v){
        String e = editTextemail.getText().toString().trim();
        if (e.equals("admintest@example.com")) {
            // opens a new activity when you sign up
            Intent intent = new Intent(this, AdminHome.class);
            userLogin();
            startActivity(intent);
        }
        else{goToWelcome2(v);}
    }

    public void goToWelcome2(View v) {
            // opens a new activity when the sign in button is pushed
            userLogin();
            Intent intent = new Intent(this, WelcomePage.class);
            EditText editText = (EditText) findViewById(R.id.signInEmail);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
    }

    public String getPass(){return passwordString;}

    public String getEmail(){return emailString;}

    public void setPass(String passwordString){this.passwordString = passwordString;}

    public void setEmail(String emailString){this.emailString = emailString;}




}

