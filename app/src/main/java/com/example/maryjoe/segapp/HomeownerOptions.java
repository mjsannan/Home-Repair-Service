package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeownerOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeowner_options);
    }

    public HomeownerOptions(){}

    //@Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bookService:
                bookServiceButton(v);
                break;
            case R.id.rateService:
                rateServiceButton(v);
                break;
        }
    }

    public void bookServiceButton(View v){
        Intent i = new Intent (HomeownerOptions.this, BookService.class);
        startActivity(i);
    }

    public void rateServiceButton(View v){
        Intent i = new Intent (HomeownerOptions.this, RateService.class);
        startActivity(i);
    }
}
