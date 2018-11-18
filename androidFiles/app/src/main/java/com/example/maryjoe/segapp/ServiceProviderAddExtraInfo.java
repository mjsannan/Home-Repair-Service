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

public class ServiceProviderAddExtraInfo extends AppCompatActivity {

    EditText editTextAddress,editTextPhoneNum,editTextCompanyName,editTextDescription,editTextLicensed;
    public static  String address,phoneNum,companyName,description,licensed;

    public static DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_add_extra_info);

        database = FirebaseDatabase.getInstance().getReference();

        editTextAddress = (EditText) findViewById(R.id.address);
        address = editTextAddress.getText().toString();

        editTextPhoneNum = (EditText) findViewById(R.id.phoneNum);
        phoneNum = editTextPhoneNum.getText().toString();

        editTextCompanyName = (EditText) findViewById(R.id.companyName);
        companyName = editTextCompanyName.getText().toString();

        editTextDescription = (EditText) findViewById(R.id.description);
        description = editTextDescription.getText().toString();

        editTextLicensed = (EditText) findViewById(R.id.licensed);
        licensed = editTextLicensed.getText().toString();


    }

    public void gotoServiceProviderHome(View v){
        if((!TextUtils.isEmpty(address) && !TextUtils.isEmpty(phoneNum) && !TextUtils.isEmpty(companyName) && !TextUtils.isEmpty(description) && !TextUtils.isEmpty(licensed))){
            database.child("Service Providers").child(address);
            database.child("Service Providers").child(phoneNum);
            database.child("Service Providers").child(companyName);
            database.child("Service Providers").child(description);
            database.child("Service Providers").child(licensed);
            Toast.makeText(this,"Extra info successfully added to type serviceprovider",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ServiceProviderHome.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(this,"Error Occurred. All fields needs to be filled",Toast.LENGTH_SHORT).show();
        }
    }

    public void signOutButton(View v){
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
    }

    public static String getAddress(){return address;}
    public static String getPhoneNum(){return phoneNum;}
    public static String getCompanyName(){return  companyName;}
    public static String getDescription(){return description;}
    public static String getLicensed(){return licensed;}
}
