package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.ExceptionInInitializerError;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RateService extends AppCompatActivity {
    static DatabaseReference database;
    static {
        try {
            database = FirebaseDatabase.getInstance().getReference();
        }
        catch (Exception e){System.out.println(e);}
    }

    EditText serviceNameET, ratingET, commentET;
    String serviceNameS, ratingS, commentS;
    int n = 0;

    public RateService(){}

    public RateService(String serviceName, String rating, String comment){
        this.serviceNameS = serviceName;
        this.ratingS = rating;
        this.commentS = comment;
    }

    public void setName(String name){this.serviceNameS = name;}
    public void setRate(String rate){this.ratingS = rate;}
    public void setComment(String c){this.commentS = c;}

    public String getServiceName(){return this.serviceNameS;}
    public String getServiceRating(){return this.ratingS;}
    public String getServiceComment(){return this.commentS;}

    public boolean correctRating(){
        boolean anws = true;
        int r = Integer.parseInt(ratingS);
        if (r < 0 || r > 5){anws = false;}
        return anws;
    }

    public boolean serviceEmpty(){
        boolean anws = false;
        if (serviceNameS.equals("")){anws = true;}
        return anws;
    }

    public boolean ratingEmpty(){
        boolean anws = false;
        if (ratingS.equals("")){anws = true;}
        return anws;
    }

    public boolean commentEmpty(){
        boolean anws = false;
        if (commentS.equals("")){anws = true;}
        return anws;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_rate_service);
    }

    //@Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.rateButton:
                rateButton(v);
                break;
            case R.id.signOut:
                signOutButton(v);
                break;
        }
    }

    public void rateButton(View v){

        serviceNameET =  findViewById(R.id.serviceName);
        ratingET = findViewById(R.id.rating);
        commentET = findViewById(R.id.comment);

        serviceNameS = serviceNameET.getText().toString().trim();
        ratingS = ratingET.getText().toString().trim();
        commentS = commentET.getText().toString().trim();

        int ratingNum = Integer.parseInt(ratingS);
        boolean correctRate = true;


        if (serviceNameS.isEmpty()){
            serviceNameET.setError("Service name required");
            serviceNameET.requestFocus();
        }

        if (ratingS.isEmpty()){
            ratingET.setError("Rating is required (out of 5)");
            ratingET.requestFocus();
        }

        if (ratingNum < 0 || ratingNum > 5){
            try {
                ratingET.setError("Rating between 0 and 5 required");
                ratingET.requestFocus();
                correctRate = false;
            }
            catch (Exception e){
                ratingET.setError("Must be an integer between 0 and 5");
                ratingET.requestFocus();
                correctRate = false;
            }
        }

        if (commentS.isEmpty()){
            commentET.setError("PLease enter a comment about this service provider");
            commentET.requestFocus();
        }

        if (!serviceNameS.isEmpty() && !ratingS.isEmpty() && !commentS.isEmpty()){
            database.child("Users").child(serviceNameS).child("Ratings").child("Score"+n).setValue(ratingS);
            database.child("Users").child(serviceNameS).child("Ratings").child("Comment"+n).setValue(commentS);
            Toast.makeText(this, "Thank you for rating this Service Provider", Toast.LENGTH_SHORT).show();
            n++;
        }
    }

    public void signOutButton(View v){
        Intent i = new Intent (this, SignIn.class);
        startActivity(i);
    }

}
