package com.example.maryjoe.segapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BookService extends AppCompatActivity {

    private EditText tmpkeyword;
    private String keyword;
    private Button search;
    private ListView results;

    private List<String> availabilityList = new ArrayList<String>();

    private static final String TAG = "MyActivity";

    DatabaseReference dbServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_book_service);

        // adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, availabilityList);
    }

    // reading from database
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    availabilityList.add(snapshot.child("Date").getValue(String.class));
                    availabilityList.add(snapshot.child("Time").getValue(String.class));
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.signOutButton:
                signOutButton(v);
                break;
            case R.id.bookButton:
                bookButton(v);
                break;
        }
    }

    static DatabaseReference database;
    static {
        try {
            database = FirebaseDatabase.getInstance().getReference();
        }
        catch (Exception e){System.out.println(e);}
    }

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

    public void signOutButton(View v){
        Intent i = new Intent (this, SignIn.class);
        startActivity(i);
    }

    public void bookButton(View v){
//        serviceNameET = findViewById(R.id.nameToBook);
//        serviceDateET = findViewById(R.id.dateToBook);
//        serviceTimeET = findViewById(R.id.timeToBook);
//
//        serviceNameS = serviceNameET.getText().toString().trim();
//        serviceDateS = serviceDateET.getText().toString().trim();
//        serviceTimeS = serviceTimeET.getText().toString().trim();
//
//        if (serviceNameS.isEmpty()){
//            serviceNameET.setError("Service name required");
//            serviceNameET.requestFocus();
//        }
//        if (serviceDateS.isEmpty()){
//            serviceDateET.setError("Date required");
//            serviceDateET.requestFocus();
//        }
//        if (serviceTimeS.isEmpty()){
//            serviceTimeET.setError("Time required");
//            serviceTimeET.requestFocus();
//        }
    }

    public void search(View v) {
        tmpkeyword = findViewById(R.id.searchBar);
        keyword = tmpkeyword.getText().toString();
        search = findViewById(R.id.searchButton);

        // finding a given service
        // we know the service type and we want the email, date and time
        Query query = FirebaseDatabase.getInstance().getReference("Availability")
                .orderByChild("Service")
                .equalTo(keyword);

        query.addListenerForSingleValueEvent(valueEventListener);

        nextSearch(v);
    }

    public void nextSearch(View v) {

        try {
            if (availabilityList.get(0) != null) {
                Log.d(TAG, "pls work maybe");
                TextView showField = findViewById(R.id.showField);
                showField.setText(availabilityList.get(0) + " at " + availabilityList.get(1));
            } else {
                Toast.makeText(getApplicationContext(), "No services match your request", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Search again", Toast.LENGTH_SHORT).show();
        }

    }


}
