package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.maryjoe.segapp.SignUp.database;

public class AddService extends AppCompatActivity {

    int n = 1;

    public AddService(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);

        AdminAddUser.printServiceList();

    }

    public void signOutButton(View v){
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
    }

    public void AddServiceClick(View v){
        EditText editTextOther = (EditText) findViewById(R.id.otherService);
        String otherString = editTextOther.getText().toString();

        String name = SignUp.getNameOfUser();

        database.child("Users").child(name).child("Service Type " + n).setValue(otherString);
        n++;
    }
}
