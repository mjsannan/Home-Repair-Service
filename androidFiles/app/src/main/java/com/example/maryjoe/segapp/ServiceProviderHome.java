package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ServiceProviderHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_home);


        TextView addressTV = findViewById(R.id.textView5);
        addressTV.setText(ServiceProviderAddExtraInfo.getAddress());

        TextView phoneNumTV = findViewById(R.id.textView2);
        phoneNumTV.setText(ServiceProviderAddExtraInfo.getPhoneNum());

        TextView companyNameTV = findViewById(R.id.textView3);
        companyNameTV.setText(ServiceProviderAddExtraInfo.getCompanyName());

        TextView descriptionTV = findViewById(R.id.textView4);
        descriptionTV.setText(ServiceProviderAddExtraInfo.getDescription());

        TextView licensedTV = findViewById(R.id.textView1);
        licensedTV.setText(ServiceProviderAddExtraInfo.getLicensed());

    }

    public void signOutButton(View v){
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
    }

    public void continueButton(View v){
        Intent i = new Intent(this, ServiceOptions.class);
        startActivity(i);
    }
}
