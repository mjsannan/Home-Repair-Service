package com.example.maryjoe.segapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteService extends Activity implements View.OnClickListener{

    public static DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_service);
    }

    EditText nameTV, serviceTV;
    String name, service;

    public DeleteService(){}

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.deleteService:
                remove(v);
                break;
        }
    }

    public void remove(View v){

        nameTV = findViewById(R.id.name);
        serviceTV = findViewById(R.id.deleteService);
        name = nameTV.getText().toString().trim();
        service = serviceTV.getText().toString().trim();

        if (!name.isEmpty() && !service.isEmpty()){
            database.child("Users").child(name).child("Added Services").child(service).setValue("null");
            Toast.makeText(this, "Service deleted from profile", Toast.LENGTH_SHORT).show();
        }

        if (name.isEmpty()){
            nameTV.setError("Name required");
            nameTV.requestFocus();
        }

        if (service.isEmpty()){
            serviceTV.setError("Service Required");
            serviceTV.requestFocus();
        }
    }

    public void signOut(View v){
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
    }

    public void serviceButton(View v){
        Intent i = new Intent (this, ServiceOptions.class);
        startActivity(i);
    }


}
