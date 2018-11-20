package com.example.maryjoe.segapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;


import android.util.Patterns;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.maryjoe.segapp.SignIn.EXTRA_MESSAGE;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    public static DatabaseReference database;

    public static String accountType, nameOfUser, emailOfUser, usernameOfUser, passwordOfUser, serviceType, priceOfService;

    public static FirebaseAuth mAuth;

    public static ProgressBar progBar;

    public static EditText editTextusername, editTextname, editTextemail, editTextpassword, editTextconfpass;

    public static boolean adminFlag = false;

    public SignUp(String accountType, String nameOfUser, String emailOfUser, String usernameOfUser, String passwordOfUser){
        this.accountType = accountType;
        this.nameOfUser = nameOfUser;
        this.emailOfUser = emailOfUser;
        this.usernameOfUser = usernameOfUser;
        this.passwordOfUser = passwordOfUser;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        database = FirebaseDatabase.getInstance().getReference();

        editTextname = (EditText) findViewById(R.id.nameTextField);
        editTextusername = (EditText) findViewById(R.id.usernameTextField);
        editTextemail = (EditText) findViewById(R.id.emailTextField);
        editTextpassword = (EditText) findViewById(R.id.passwordTextField);
        editTextconfpass = (EditText) findViewById(R.id.confirmPassTextField);

        mAuth= FirebaseAuth.getInstance();

        progBar = (ProgressBar) findViewById(R.id.progressBar);

        // findViewById(R.id.button3).setOnClickListener(this);

    }

    public SignUp(){}

    public void registerUser(){
        String name = editTextname.getText().toString().trim();
        String email = editTextemail.getText().toString().trim();
        String username = editTextusername.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        String confirmpass = editTextconfpass.getText().toString().trim();

        if(name.isEmpty()){
            editTextname.setError("Name is required ");
            editTextname.requestFocus();
            return;
        }
        if(username.isEmpty()){
            editTextusername.setError("Username is required");
            editTextusername.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextemail.setError("Email is required");
            editTextemail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Enter a valid email");
            editTextemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextpassword.setError("Password is required");
            editTextpassword.requestFocus();
            return;
        }
        if(password.length()<6) {
            editTextpassword.setError("Minimum length of password is six");
            editTextpassword.requestFocus();
            return;
        }

        if(confirmpass.isEmpty()){
            editTextconfpass.setError("Password is required");
            editTextconfpass.requestFocus();
            return;
        }
        if(!confirmpass.equals(password)){
            editTextconfpass.setError("Password does not match. Renter password");
            editTextconfpass.requestFocus();
            return;
        }
        progBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Intent intent = new Intent(SignUp.this, WelcomePage.class);
                    EditText editText = (EditText) findViewById(R.id.nameTextField);
                    String message = editText.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"User Registration Successful",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error occurred",Toast.LENGTH_SHORT).show();

                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"You are already registered in the system",Toast.LENGTH_SHORT).show();
                    }

                    else{
                        Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void registerUser1(){
        String name = editTextname.getText().toString().trim();
        String email = editTextemail.getText().toString().trim();
        String username = editTextusername.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        String confirmpass = editTextconfpass.getText().toString().trim();

        if(name.isEmpty()){
            editTextname.setError("Name is required ");
            editTextname.requestFocus();
            return;
        }
        if(username.isEmpty()){
            editTextusername.setError("Username is required");
            editTextusername.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextemail.setError("Email is required");
            editTextemail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Enter a valid email");
            editTextemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextpassword.setError("Password is required");
            editTextpassword.requestFocus();
            return;
        }
        if(password.length()<6) {
            editTextpassword.setError("Minimum length of password is six");
            editTextpassword.requestFocus();
            return;
        }

        if(confirmpass.isEmpty()){
            editTextconfpass.setError("Password is required");
            editTextconfpass.requestFocus();
            return;
        }
        if(!confirmpass.equals(password)){
            editTextconfpass.setError("Password does not match. Renter password");
            editTextconfpass.requestFocus();
            return;
        }
        progBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Intent intent = new Intent(SignUp.this, AdminHome.class);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(),"User Registration Successful",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error occurred",Toast.LENGTH_SHORT).show();

                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"You are already registered in the system",Toast.LENGTH_SHORT).show();
                    }

                    else{
                        Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void registerUser2(){
        String name = editTextname.getText().toString().trim();
        String email = editTextemail.getText().toString().trim();
        String username = editTextusername.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        String confirmpass = editTextconfpass.getText().toString().trim();

        if(name.isEmpty()){
            editTextname.setError("Name is required ");
            editTextname.requestFocus();
            return;
        }
        if(username.isEmpty()){
            editTextusername.setError("Username is required");
            editTextusername.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextemail.setError("Email is required");
            editTextemail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Enter a valid email");
            editTextemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextpassword.setError("Password is required");
            editTextpassword.requestFocus();
            return;
        }
        if(password.length()<6) {
            editTextpassword.setError("Minimum length of password is six");
            editTextpassword.requestFocus();
            return;
        }

        if(confirmpass.isEmpty()){
            editTextconfpass.setError("Password is required");
            editTextconfpass.requestFocus();
            return;
        }
        if(!confirmpass.equals(password)){
            editTextconfpass.setError("Password does not match. Renter password");
            editTextconfpass.requestFocus();
            return;
        }
        progBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Intent intent = new Intent(SignUp.this, ServiceProviderAddExtraInfo.class);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(),"User Registration Successful",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error occurred",Toast.LENGTH_SHORT).show();

                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"You are already registered in the system",Toast.LENGTH_SHORT).show();
                    }

                    else{
                        Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button3:
                registerUser();
                break;
                //goToWelcome(v);
        }
    }

    public void goToWelcome(View view) {
        if(accountType.equals(null)){
            Toast.makeText(this,"Error occurred. You need to select an account type",Toast.LENGTH_SHORT).show();
        }
        else if (accountType.equals("Admin")) {
            // opens a new activity when you sign up
            registerUser1();

        }
        else if(accountType.equals("Service Provider")){
            registerUser2();

        }
        else {
            // opens a new activity when you sign up
            registerUser();

        }
    }

    public void adminClick(View view) {
        adminFlag = true;
        accountType = "Admin";

        EditText editTextName = (EditText) findViewById(R.id.nameTextField);
        nameOfUser = editTextName.getText().toString();

        EditText editTextEmail = (EditText) findViewById(R.id.emailTextField);
        emailOfUser = editTextEmail.getText().toString();

        EditText editTextUserName = (EditText) findViewById(R.id.usernameTextField);
        usernameOfUser = editTextUserName.getText().toString();

        EditText editTextPassword = (EditText) findViewById(R.id.passwordTextField);
        passwordOfUser = editTextPassword.getText().toString();

        database.child("Users").child(nameOfUser);
        database.child("Users").child(nameOfUser).child("Email").setValue(emailOfUser);
        database.child("Users").child(nameOfUser).child("Account Type").setValue(accountType);
        database.child("Users").child(nameOfUser).child("Username").setValue(usernameOfUser);
        database.child("Users").child(nameOfUser).child("Password").setValue(passwordOfUser);
        database.child("Users").child(nameOfUser).child("Service Type").setValue(null);
        database.child("Users").child(nameOfUser).child("Price of Service").setValue(null);
    }

    public void homeOwnerClick(View view) {
        accountType = "Homeowner";

        EditText editTextUserName = (EditText) findViewById(R.id.usernameTextField);
        usernameOfUser = editTextUserName.getText().toString();

        EditText editTextName = (EditText) findViewById(R.id.nameTextField);
        nameOfUser = editTextName.getText().toString();

        EditText editTextEmail = (EditText) findViewById(R.id.emailTextField);
        emailOfUser = editTextEmail.getText().toString();

        EditText editTextPassword = (EditText) findViewById(R.id.passwordTextField);
        passwordOfUser = editTextPassword.getText().toString();

        database.child("Users").child(nameOfUser);
        database.child("Users").child(nameOfUser).child("Email").setValue(emailOfUser);
        database.child("Users").child(nameOfUser).child("Account Type").setValue(accountType);
        database.child("Users").child(nameOfUser).child("Username").setValue(usernameOfUser);
        database.child("Users").child(nameOfUser).child("Password").setValue(passwordOfUser);
        database.child("Users").child(nameOfUser).child("Service Type").setValue(null);
        database.child("Users").child(nameOfUser).child("Price of Service").setValue(null);
    }

    public void serviceProviderClick(View view) {
        accountType = "Service Provider";

       // ConstraintLayout serviceProLay = (LinearLayout) findViewById(R.id.serviceProviderLayout);
        //serviceProLay.setVisibility(View.VISIBLE);

        EditText editTextName = (EditText) findViewById(R.id.nameTextField);
        nameOfUser = editTextName.getText().toString();

        EditText editTextEmail = (EditText) findViewById(R.id.emailTextField);
        emailOfUser = editTextEmail.getText().toString();

        EditText editTextUserName = (EditText) findViewById(R.id.usernameTextField);
        usernameOfUser = editTextUserName.getText().toString();

        EditText editTextPassword = (EditText) findViewById(R.id.passwordTextField);
        passwordOfUser = editTextPassword.getText().toString();


        EditText editTextService = (EditText) findViewById(R.id.serviceTypeField);
        serviceType = editTextService.getText().toString();

        EditText editTextPrice = (EditText) findViewById(R.id.priceField);
        priceOfService = editTextPrice.getText().toString();

        database.child("Users").child(nameOfUser);
        database.child("Users").child(nameOfUser).child("Email").setValue(emailOfUser);
        database.child("Users").child(nameOfUser).child("Account Type").setValue(accountType);
        database.child("Users").child(nameOfUser).child("Username").setValue(usernameOfUser);
        database.child("Users").child(nameOfUser).child("Password").setValue(passwordOfUser);
        database.child("Users").child(nameOfUser).child("Service Type").setValue(serviceType);
        database.child("Users").child(nameOfUser).child("Price of Service").setValue(priceOfService);
    }

    public static String getNameOfUser() {
        return nameOfUser;
    }

    public static String getEmailOfUser() {
        return emailOfUser;
    }

    public static String getUsernameOfUser() {
        return usernameOfUser;
    }

    public static String getPasswordOfUser() {
        return passwordOfUser;
    }

    public static String getAccountType() {
        return accountType;
    }

}

