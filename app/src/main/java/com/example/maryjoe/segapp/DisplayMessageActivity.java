package com.example.maryjoe.segapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;


import android.util.Patterns;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;


import static com.example.maryjoe.segapp.MainActivity.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity implements View.OnClickListener {

    public static String accountType;
    public static String nameOfUser;
    public static String emailOfUser;
    public static String usernameOfUser;
    public static String passwordOfUser;

    EditText editTextusername,editTextname,editTextemail,editTextpassword,editTextconfpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        editTextname = (EditText) findViewById(R.id.nameTextField);
        editTextusername = (EditText) findViewById(R.id.usernameTextField);
        editTextemail = (EditText) findViewById(R.id.emailTextField);
        editTextpassword = (EditText) findViewById(R.id.passwordTextField);
        editTextconfpass = (EditText) findViewById(R.id.confirmPassTextField);
    }

    private void registerUser(){
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
            editTextconfpass.setError("Passwoed does not match. Renter password");
            editTextconfpass.requestFocus();
            return;
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSignUp:
                registerUser();
                break;

        }
    }

    public void sendMessage3(View view) {
        // opens a new activity when you sign up
        Intent intent = new Intent(this, WelcomePage.class);
        EditText editText = (EditText) findViewById(R.id.nameTextField);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void adminClick(View view) {
        accountType = "Admin";

        EditText editTextName = (EditText) findViewById(R.id.nameTextField);
        nameOfUser = editTextName.getText().toString();

        EditText editTextEmail = (EditText) findViewById(R.id.emailTextField);
        emailOfUser = editTextEmail.getText().toString();

        EditText editTextUserName = (EditText) findViewById(R.id.usernameTextField);
        usernameOfUser = editTextUserName.getText().toString();

        EditText editTextPassword = (EditText) findViewById(R.id.passwordTextField);
        passwordOfUser = editTextPassword.getText().toString();
    }

    public void homeOwnerClick(View view) {
        accountType = "Homeowner";

        EditText editTextName = (EditText) findViewById(R.id.nameTextField);
        nameOfUser = editTextName.getText().toString();

        EditText editTextEmail = (EditText) findViewById(R.id.emailTextField);
        emailOfUser = editTextEmail.getText().toString();

        EditText editTextUserName = (EditText) findViewById(R.id.usernameTextField);
        usernameOfUser = editTextUserName.getText().toString();

        EditText editTextPassword = (EditText) findViewById(R.id.passwordTextField);
        passwordOfUser = editTextPassword.getText().toString();
    }

    public void serviceProviderClick(View view) {
        accountType = "Service Provider";


        LinearLayout serviceProLay = (LinearLayout) findViewById(R.id.serviceProviderLayout);
        serviceProLay.setVisibility(View.VISIBLE);

        EditText editTextName = (EditText) findViewById(R.id.nameTextField);
        nameOfUser = editTextName.getText().toString();

        EditText editTextEmail = (EditText) findViewById(R.id.emailTextField);
        emailOfUser = editTextEmail.getText().toString();

        EditText editTextUserName = (EditText) findViewById(R.id.usernameTextField);
        usernameOfUser = editTextUserName.getText().toString();

        EditText editTextPassword = (EditText) findViewById(R.id.passwordTextField);
        passwordOfUser = editTextPassword.getText().toString();
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

