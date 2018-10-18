package com.example.maryjoe.segapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;


import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;

import static com.example.maryjoe.segapp.MainActivity.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity {

    Object accountType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
    }

    public void sendMessage3(View view) {
        // opens a new activity when you sign up
        Intent intent = new Intent(this, WelcomePage2.class);
        EditText editText = (EditText) findViewById(R.id.nameTextField);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void adminClick(View view) {
        accountType = "Admin";
    }

    public void homeOwnerClick(View view) {
        accountType = "Homeowner";
    }

    public void serviceProviderClick(View view) {
        accountType = "Service Provider";


        LinearLayout serviceProLay = (LinearLayout) findViewById(R.id.serviceProviderLayout);
        serviceProLay.setVisibility(View.VISIBLE);

    }

}

