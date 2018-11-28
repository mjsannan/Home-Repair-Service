package com.example.maryjoe.segapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.io.FileInputStream;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class AdminHome extends AppCompatActivity {

    public static DatabaseReference mDatabase;
    public static FirebaseAuth.AuthStateListener mAuthListener;
    public static FirebaseDatabase mFirebaseDatabase;
    public static FirebaseAuth mAuth;

    public EditText serviceEditText;
    public String serviceToEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_home);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = mFirebaseDatabase.getReference();

        serviceEditText = (EditText) findViewById(R.id.enterService);
        serviceToEdit =  serviceEditText.getText().toString();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showData(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds: dataSnapshot.getChildren()) {
            UserInformation uInfo = new UserInformation();
            uInfo.setService(ds.child(serviceToEdit).getValue(UserInformation.class).getService());
            uInfo.setPrice(ds.child(serviceToEdit).getValue(UserInformation.class).getPrice());

        }
    }

    public void editButton(View v) {

        EditText newPrice = (EditText) findViewById(R.id.changePrice);
        String newPriceString =  newPrice.getText().toString();

        mDatabase.child("Services").child(serviceToEdit).child("Price").setValue(newPriceString);

        Toast.makeText(this,"This service has been edited successfully",Toast.LENGTH_SHORT).show();


    }

    public void deleteButton(View v) {
        mDatabase.child("Services").child(serviceToEdit).child("Price").setValue(null);
        mDatabase.child("Services").child(serviceToEdit).removeValue();

        Toast.makeText(this, "This service has been deleted successfully",Toast.LENGTH_SHORT).show();
    }

    public void addUserButton(View v){
        Intent intent = new Intent(AdminHome.this, AdminAddUser.class);
        startActivity(intent);
    }

    public void signOutButton(View v) {
        Intent intent = new Intent(AdminHome.this, SignIn.class);
        startActivity(intent);
    }

    public String getService(){return serviceToEdit;}
    public void setService(String serviceToEdit){this.serviceToEdit = serviceToEdit;}

}
