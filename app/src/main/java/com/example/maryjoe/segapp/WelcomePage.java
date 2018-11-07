package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

}
