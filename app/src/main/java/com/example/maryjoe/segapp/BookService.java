package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class BookService extends AppCompatActivity {

    public static DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    EditText serviceNameET, serviceDateET, serviceTimeET;
    String serviceNameS, serviceDateS, serviceTimeS;

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
        serviceNameET = findViewById(R.id.nameToBook);
        serviceDateET = findViewById(R.id.dateToBook);
        serviceTimeET = findViewById(R.id.timeToBook);

        serviceNameS = serviceNameET.getText().toString().trim();
        serviceDateS = serviceDateET.getText().toString().trim();
        serviceTimeS = serviceTimeET.getText().toString().trim();

        if (serviceNameS.isEmpty()){
            serviceNameET.setError("Service name required");
            serviceNameET.requestFocus();
        }
        if (serviceDateS.isEmpty()){
            serviceNameET.setError("Date required");
            serviceNameET.requestFocus();
        }
        if (serviceTimeS.isEmpty()){
            serviceNameET.setError("Time required");
            serviceNameET.requestFocus();
        }



    }


}
