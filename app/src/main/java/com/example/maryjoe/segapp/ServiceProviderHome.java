package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ServiceProviderHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_home);

        TextView addressTV = findViewById(R.id.addressTV);
        addressTV.setText(ServiceProviderAddExtraInfo.getAddress());

        TextView phoneNumTV = findViewById(R.id.phoneNumTV);
        phoneNumTV.setText(ServiceProviderAddExtraInfo.getPhoneNum());

        TextView companyNameTV = findViewById(R.id.companyNameTV);
        companyNameTV.setText(ServiceProviderAddExtraInfo.getCompanyName());

        TextView descriptionTV = findViewById(R.id.descriptionTV);
        descriptionTV.setText(ServiceProviderAddExtraInfo.getDescription());

        TextView licensedTV = findViewById(R.id.licensedTV);
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
