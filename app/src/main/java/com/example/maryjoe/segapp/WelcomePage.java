package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(SignIn.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView nameTextField = findViewById(R.id.nameTextField);
        nameTextField.setText(SignUp.getNameOfUser());

        TextView loggedTextView = findViewById(R.id.loggedTextView);
        loggedTextView.setText(SignUp.getAccountType());
    }

    public void onClick(View v){
       continueButton(v);
    }

    SignUp signUp = new SignUp();

    public void continueButton(View view){

        try {

            if ((signUp.getAccountType()).equals("Service Provider")) {
                Intent intent = new Intent(WelcomePage.this, ServiceOptions.class);
                startActivity(intent);
            } else if ((signUp.getAccountType()).equals("Homeowner")) {
                Intent i = new Intent(WelcomePage.this, HomeownerOptions.class);
                startActivity(i);
            }

        }

        catch (Exception e){
            Intent intent = new Intent (WelcomePage.this, ServiceOptions.class);
            startActivity(intent);
        }

    }

}
