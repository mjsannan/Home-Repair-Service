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

//import static com.example.maryjoe.segapp.SignUp.database;

public class AddService extends AppCompatActivity implements View.OnClickListener{

    int n = 1;
    EditText otherServiceET, otherPriceET, fromDatabaseET, nameET;
    boolean empty = false;
    ArrayList<String> dbService;
    boolean changes = false;

    public static DatabaseReference database = FirebaseDatabase.getInstance().getReference();


    public AddService(ArrayList <String> dbService){
        this.dbService = dbService;
    }

    public AddService(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);

        ArrayList <String> db = AdminAddUser.getServiceList();

        if (db.isEmpty()){
            Toast.makeText(this, "No services created in the database", Toast.LENGTH_SHORT).show();
            empty = true;
        }

        if (db.size() == 1){
            TextView service1T = findViewById(R.id.service1);
            if (db.get(0) != null) {service1T.setText(db.get(0));}
            empty = false;
        }

        if (db.size() == 2){

            TextView service1T = findViewById(R.id.service1);
            if (db.get(0) != null) {service1T.setText(db.get(0));}

            TextView service2T = findViewById(R.id.service2);
            if (db.get(1) != null) {service2T.setText(db.get(1));}

            empty = false;

        }

        if (db.size() == 3){
            TextView service1T = findViewById(R.id.service1);
            if (db.get(0) != null) {service1T.setText(db.get(0));}

            TextView service2T = findViewById(R.id.service2);
            if (db.get(1) != null) {service2T.setText(db.get(1));}

            TextView service3T = findViewById(R.id.service3);
            if (db.get(2) != null) {service3T.setText(db.get(2));}

            empty = false;
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

            empty = false;
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

            empty = false;
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

            empty = false;
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

            empty = false;
        }

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.providedServiceButton:
                fromDatabaseButton(v);
                break;
            case R.id.addServiceButton:
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

        nameET = findViewById(R.id.nameView);
        String name = nameET.getText().toString().trim();
        otherServiceET = findViewById(R.id.otherService);
        String otherServiceS = otherServiceET.getText().toString().trim();
        otherPriceET = findViewById(R.id.priceOther);
        String otherPriceS = otherPriceET.getText().toString().trim();

        if (!otherServiceS.isEmpty() && !otherPriceS.isEmpty() && !name.isEmpty()) {

            SignUp signUp = new SignUp();

           // String name = signUp.getNameOfUser();

            //database.child("Users").child(name).child("Service Type " + n).setValue(otherString);
            database.child("Users").child(name).child("Added Services").child("Service Type ").setValue(otherServiceS);
            database.child("Users").child(name).child("Added Services").child("Service Price").setValue(otherPriceS);
            Toast.makeText(this, "Service added to profile", Toast.LENGTH_SHORT).show();
            n++;
            changes = true;
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

        if (name.isEmpty()){
            nameET.setError("Registered Name Required");
            nameET.requestFocus();
            return;
        }


    }

    public void fromDatabaseButton(View v){

        nameET = findViewById(R.id.nameView);
        String name = nameET.getText().toString().trim();
        fromDatabaseET = findViewById(R.id.fromDatabase);
        String databaseService = fromDatabaseET.getText().toString().trim();

        ArrayList<String> db = AdminAddUser.getServiceList();

        if (!databaseService.isEmpty() && !name.isEmpty()){

            SignUp signUp2 = new SignUp();

           // EditText editTextFromDB = (EditText) findViewById(R.id.fromDatabase);
            //String dbString = editTextFromDB.getText().toString();

            if (db.contains(databaseService)) {

               // String name = signUp2.getNameOfUser();

                database.child("Users").child(name).child("Added Services").child("Service Type ").setValue(databaseService);
               // database.child("Users").child(name).child("Service Type " + n).setValue(dbString);
                Toast.makeText(this, "Service added to profile", Toast.LENGTH_SHORT).show();
                n++;
                changes = true;
            }

            if (!db.contains(databaseService)){
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

        if (name.isEmpty()){
            nameET.setError("Registered Name Required");
            nameET.requestFocus();
            return;
        }

    }

    public void updateButton(View v){
        if (changes) {Toast.makeText(this, "Profile updated", Toast.LENGTH_SHORT).show();}
        if (!changes) {Toast.makeText(this, "No changes were made to profile", Toast.LENGTH_SHORT).show();}
    }

    public void backToSO(View v){
        Intent i = new Intent(this, ServiceOptions.class);
        startActivity(i);
    }

    public boolean checkEmpty(ArrayList<String> l){
        return dbService.isEmpty();
    }



}
