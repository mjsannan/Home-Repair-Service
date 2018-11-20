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


    public static  String address,phoneNum,companyName,description,licensed;

    public static DatabaseReference database;

    SignUp su = new SignUp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_add_extra_info);

        database = FirebaseDatabase.getInstance().getReference();

    }

    public void gotoServiceProviderHome(View v){
        EditText editTextAddress = (EditText) findViewById(R.id.address);
        address = editTextAddress.getText().toString();

        EditText editTextPhoneNum = (EditText) findViewById(R.id.phoneNum);
        phoneNum = editTextPhoneNum.getText().toString();

        EditText editTextCompanyName = (EditText) findViewById(R.id.companyName);
        companyName = editTextCompanyName.getText().toString();

        EditText editTextDescription = (EditText) findViewById(R.id.description);
        description = editTextDescription.getText().toString();

        EditText editTextLicensed = (EditText) findViewById(R.id.licensed);
        licensed = editTextLicensed.getText().toString();

        boolean isValid = true;

        if(TextUtils.isEmpty(address))
        {
            isValid = false;
            Toast.makeText(this,"Address is needed",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(phoneNum))
        {
            isValid = false;
            Toast.makeText(this,"Phone is needed",Toast.LENGTH_SHORT).show();

        }
        if(TextUtils.isEmpty(companyName))
        {
            isValid = false;
            Toast.makeText(this,"Company name is needed",Toast.LENGTH_SHORT).show();

        }
        if(TextUtils.isEmpty(description))
        {
            isValid = false;
            Toast.makeText(this,"Description is needed",Toast.LENGTH_SHORT).show();

        }
        if(TextUtils.isEmpty(licensed))
        {
            isValid = false;
            Toast.makeText(this,"Please enter yes/no if licensed",Toast.LENGTH_SHORT).show();

        }

        if(!isValid){

            Toast.makeText(this,"Error occurred. All fields need to be filled",Toast.LENGTH_SHORT).show();

        }
        else{

            String u = su.getNameOfUser();

            database.child("Users").child(u).child("Address").setValue(address);
            database.child("Users").child(u).child("Phone Number").setValue(phoneNum);
            database.child("Users").child(u).child("Company Name").setValue(companyName);
            database.child("Users").child(u).child("Description").setValue(description);
            database.child("Users").child(u).child("Licensed").setValue(licensed);

            Toast.makeText(this,"Extra information successfully added to type serviceprovider profile",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ServiceProviderHome.class);
            EditText editText = (EditText) findViewById(R.id.address);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
            Toast.makeText(this,"Extra information successfully added to type serviceprovider profile",Toast.LENGTH_SHORT).show();





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
