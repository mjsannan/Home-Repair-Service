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

    SignUp su = new SignUp();

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
        boolean isValid = false;
        if(address.isEmpty())
        {
            Toast.makeText(this,"Address is needed",Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        if(phoneNum.isEmpty())
        {
            Toast.makeText(this,"Phone is needed",Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        if(companyName.isEmpty())
        {
            Toast.makeText(this,"Company name is needed",Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        if(description.isEmpty())
        {
            Toast.makeText(this,"Description is needed",Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        if(licensed.isEmpty())
        {
            Toast.makeText(this,"Please enter yes/no if licensed",Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        if(!isValid){
            Toast.makeText(this,"Error occurred. All fields need to be filled",Toast.LENGTH_SHORT).show();

        }
        else{

            String u = su.getUsernameOfUser();

            database.child("Users").child(u).child(address);
            database.child("Users").child(u).child(phoneNum);
            database.child("Users").child(u).child(companyName);
            database.child("Users").child(u).child(description);
            database.child("Users").child(u).child(licensed);
            Toast.makeText(this,"Extra information successfully added to type serviceprovider profile",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ServiceProviderHome.class);
            startActivity(intent);

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
