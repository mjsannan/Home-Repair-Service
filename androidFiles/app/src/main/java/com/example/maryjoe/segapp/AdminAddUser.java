package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.maryjoe.segapp.SignIn.EXTRA_MESSAGE;

public class AdminAddUser extends AppCompatActivity { // Admin add Service
    public static String serviceType, priceOfService;

    EditText nameOfService, priceofService;

    public static DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_user);

        database = FirebaseDatabase.getInstance().getReference();
    }



    public void signOutButton(View v){
        Intent intent = new Intent(AdminAddUser.this, SignIn.class);
        startActivity(intent);
    }

    public void goBackHome(View v) {

        EditText editTextService = (EditText) findViewById(R.id.serviceName);
        serviceType = editTextService.getText().toString();

        EditText editTextPrice = (EditText) findViewById(R.id.price);
        priceOfService = editTextPrice.getText().toString();

        Float p = Float.parseFloat(priceOfService);


        if(!TextUtils.isEmpty(serviceType) && !TextUtils.isEmpty(priceOfService)){

            database.child("Services").child(serviceType);
            database.child("Services").child(serviceType).child("Price").setValue(p);
            Toast.makeText(this, "Service Type and Price of Service successfully added", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AdminHome.class);
            EditText editText = (EditText) findViewById(R.id.serviceName);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        else{

            Toast.makeText(this,"Service name and Price is needed",Toast.LENGTH_SHORT).show();

        }

    }



    public String getService(){return serviceType;}
    public String getPriceService(){return priceOfService;}

    public void setServiceType(String serviceType){this.serviceType = serviceType;}
    public void setPriceOfService(String priceOfService){this.priceOfService = priceOfService;}
}