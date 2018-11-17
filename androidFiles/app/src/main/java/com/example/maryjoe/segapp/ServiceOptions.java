package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class ServiceOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_options);
    }

    public void addServiceButton(View view){
        Intent intent = new Intent(ServiceOptions.this, AddService.class);
        startActivity(intent);
    }

    public void addDeleteButton(View view){
        Intent intent = new Intent(ServiceOptions.this, DeleteService.class);
        startActivity(intent);
    }

    public void addAvailabilityButton(View view){
        Intent intent = new Intent(ServiceOptions.this, AddAvailability.class);
        startActivity(intent);
    }

    public void checkAvailabilityButton(View view){
        Intent intent = new Intent(ServiceOptions.this, CheckAvailability.class);
        startActivity(intent);
    }
}
