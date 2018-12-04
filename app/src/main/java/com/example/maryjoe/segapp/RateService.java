package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RateService extends AppCompatActivity {

    public static DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    EditText serviceNameET, ratingET, commentET;
    String serviceNameS, ratingS, commentS;
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
