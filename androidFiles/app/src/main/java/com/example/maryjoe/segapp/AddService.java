package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import static com.example.maryjoe.segapp.SignUp.database;

public class AddService extends AppCompatActivity {

    int n = 1;
    EditText otherServiceET, otherPriceET, fromDatabaseET;

   // FirebaseUser currUser = FirebaseAuth.getCurrentUser();


    public AddService(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);

        ArrayList <String> db = AdminAddUser.getServiceList();

        if (db.isEmpty()){
            Toast.makeText(this, "No services created in the database", Toast.LENGTH_SHORT).show();
        }

        if (db.size() == 1){
            TextView service1T = findViewById(R.id.service1);
            if (db.get(0) != null) {service1T.setText(db.get(0));}
        }

        if (db.size() == 2){

            TextView service1T = findViewById(R.id.service1);
            if (db.get(0) != null) {service1T.setText(db.get(0));}

            TextView service2T = findViewById(R.id.service2);
            if (db.get(1) != null) {service2T.setText(db.get(1));}

        }

        if (db.size() == 3){
            TextView service1T = findViewById(R.id.service1);
            if (db.get(0) != null) {service1T.setText(db.get(0));}

            TextView service2T = findViewById(R.id.service2);
            if (db.get(1) != null) {service2T.setText(db.get(1));}

            TextView service3T = findViewById(R.id.service3);
            if (db.get(2) != null) {service3T.setText(db.get(2));}
        }

        if (db.size() == 4){

            TextView service1T = findViewById(R.id.service1);
            if (db.get(0) != null) {service1T.setText(db.get(0));}

            TextView service2T = findViewById(R.id.service2);
            if (db.get(1) != null) {service2T.setText(db.get(1));}

            TextView service3T = findViewById(R.id.service3);
            if (db.get(2) != null) {service3T.setText(db.get(2));}

            TextView service4T = findViewById(R.id.service4);
            if (db.get(3) != null) {service4T.setText(db.get(3));}
        }

        if (db.size() == 5){

            TextView service1T = findViewById(R.id.service1);
            if (db.get(0) != null) {service1T.setText(db.get(0));}

            TextView service2T = findViewById(R.id.service2);
            if (db.get(1) != null) {service2T.setText(db.get(1));}

            TextView service3T = findViewById(R.id.service3);
            if (db.get(2) != null) {service3T.setText(db.get(2));}

            TextView service4T = findViewById(R.id.service4);
            if (db.get(3) != null) {service4T.setText(db.get(3));}

            TextView service5T = findViewById(R.id.service5);
            if (db.get(4) != null) {service5T.setText(db.get(4));}
        }

        if (db.size() == 6){

            TextView service1T = findViewById(R.id.service1);
            if (db.get(0) != null) {service1T.setText(db.get(0));}

            TextView service2T = findViewById(R.id.service2);
            if (db.get(1) != null) {service2T.setText(db.get(1));}

            TextView service3T = findViewById(R.id.service3);
            if (db.get(2) != null) {service3T.setText(db.get(2));}

            TextView service4T = findViewById(R.id.service4);
            if (db.get(3) != null) {service4T.setText(db.get(3));}

            TextView service5T = findViewById(R.id.service5);
            if (db.get(4) != null) {service5T.setText(db.get(4));}

            TextView service6T = findViewById(R.id.service6);
            if (db.get(5) != null) {service6T.setText(db.get(5));}
        }

        if (db.size() > 6){
            TextView service1T = findViewById(R.id.service1);
            if (db.get(0) != null) {service1T.setText(db.get(0));}

            TextView service2T = findViewById(R.id.service2);
            if (db.get(1) != null) {service2T.setText(db.get(1));}

            TextView service3T = findViewById(R.id.service3);
            if (db.get(2) != null) {service3T.setText(db.get(2));}

            TextView service4T = findViewById(R.id.service4);
            if (db.get(3) != null) {service4T.setText(db.get(3));}

            TextView service5T = findViewById(R.id.service5);
            if (db.get(4) != null) {service5T.setText(db.get(4));}

            TextView service6T = findViewById(R.id.service6);
            if (db.get(5) != null) {service6T.setText(db.get(5));}
        }

    }

   // @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.providedServiceButton:
                fromDatabaseButton(v);
                break;
            case R.id.addServiceButton:
                AddServiceClick(v);
                break;
            case R.id.addPriceButton:
                AddServiceClick(v);
                break;
            case R.id.updateButton:
                updateButton(v);
                break;
        }
    }

    public void signOutButton(View v){
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
    }

    public void AddServiceClick(View v){

        String otherServiceS = otherServiceET.getText().toString().trim();
        String otherPriceS = otherPriceET.getText().toString().trim();

        if (!otherServiceS.isEmpty() && !otherPriceS.isEmpty()) {

            SignUp signUp = new SignUp();

            EditText editTextOther = (EditText) findViewById(R.id.otherService);
            String otherString = editTextOther.getText().toString();

            String name = signUp.getNameOfUser();

            database.child("Users").child(name).child("Service Type " + n).setValue(otherString);
            Toast.makeText(this, "Service added to profile", Toast.LENGTH_SHORT).show();
            n++;
        }

        if (otherServiceS.isEmpty()){
            otherServiceET.setError("Service Required");
            otherServiceET.requestFocus();
            return;
        }

        if (otherPriceS.isEmpty()){
            otherPriceET.setError(("Price Required"));
            otherPriceET.requestFocus();
            return;
        }

    }

    public void fromDatabaseButton(View v){

        String databaseService = fromDatabaseET.getText().toString().trim();

        ArrayList<String> db = AdminAddUser.getServiceList();

        if (!databaseService.isEmpty()){

            SignUp signUp2 = new SignUp();

            EditText editTextFromDB = (EditText) findViewById(R.id.fromDatabase);
            String dbString = editTextFromDB.getText().toString();

            if (db.contains(dbString)) {

                String name = signUp2.getNameOfUser();

                database.child("Users").child(name).child("Service Type " + n).setValue(dbString);
                Toast.makeText(this, "Service added to profile", Toast.LENGTH_SHORT).show();
                n++;
            }

            if (!db.contains(dbString)){
                fromDatabaseET.setError("Service not provided");
                fromDatabaseET.requestFocus();
                return;

            }
        }

        if (databaseService.isEmpty()){
            fromDatabaseET.setError("Service Required");
            fromDatabaseET.requestFocus();
            return;
        }

    }

    public void updateButton(View v){
        Toast.makeText(this, "Profile updated", Toast.LENGTH_SHORT).show();
    }


}
