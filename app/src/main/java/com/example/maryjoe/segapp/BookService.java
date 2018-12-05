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

    public BookService(){}

    public BookService(String name, String date, String time){
        this.serviceNameS = name;
        this.serviceDateS = date;
        this.serviceTimeS = time;
    }

    public void setName(String name){this.serviceNameS = name;}
    public void setDate(String date){this.serviceDateS = date;}
    public void setTime(String time){this.serviceTimeS = time;}

    public String getName(){return this.serviceNameS;}
    public String getDate(){return this.serviceDateS;}
    public String getTime(){return this.serviceTimeS;}

    public boolean nameEmpty(){

        boolean anws = false;
        if (serviceNameS.equals("")){anws = true;}
        return anws;
    }

    public boolean dateEmpty(){

        boolean anws = false;
        if (serviceDateS.equals("")){anws = true;}
        return anws;
    }

    public boolean timeEmpty(){

        boolean anws = false;
        if (serviceTimeS.equals("")){anws = true;}
        return anws;
    }

    public boolean success(){
        boolean anws = false;
        if (!serviceNameS.equals("") && !serviceDateS.equals("") && !serviceTimeS.equals("")){anws = true;}
        return anws;
    }

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
            serviceDateET.setError("Date required");
            serviceDateET.requestFocus();
        }
        if (serviceTimeS.isEmpty()){
            serviceTimeET.setError("Time required");
            serviceTimeET.requestFocus();
        }



    }


}
