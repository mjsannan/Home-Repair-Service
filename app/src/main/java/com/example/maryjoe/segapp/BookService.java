package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BookService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_service);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.signOutButton:
                signOutButton(v);
                break;
            case R.id.bookButton:
                bookButton(v);
                break;
        }
    }

    public void signOutButton(View v){
        Intent i = new Intent (this, SignIn.class);
        startActivity(i);
    }

    public void bookButton(View v){
        // do nothing for now
    }


}
