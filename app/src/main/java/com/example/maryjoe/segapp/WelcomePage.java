package com.example.maryjoe.segapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class WelcomePage extends AppCompatActivity {

    private List<String> userArray = new ArrayList<String>();

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(SignIn.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView nameTextField = findViewById(R.id.nameTextField);
        nameTextField.setText(SignUp.getNameOfUser());

        TextView loggedTextView = findViewById(R.id.loggedTextView);
        loggedTextView.setText(SignUp.getAccountType());

        Query query = FirebaseDatabase.getInstance().getReference("Users")
                .orderByChild("Email")
                .equalTo(SignIn.emailLoggingIn);

        query.addListenerForSingleValueEvent(valueEventListener);
    }

    // reading from database
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            Toast.makeText(getApplicationContext(), dataSnapshot.child("Account Type").getValue(String.class), Toast.LENGTH_SHORT).show();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    userArray.add(snapshot.child("Account Type").getValue(String.class));
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    public void onClick(View v){
       continueButton(v);
    }

    SignUp signUp = new SignUp();

    public void continueButton(View view){

        try {

            String test = userArray.get(0);
            Log.d(TAG, "Hello " + test);

            if (test.equals(("Homeowner"))) {
                Intent j = new Intent(WelcomePage.this, HomeownerOptions.class);
                startActivity(j);
            } else if (test.equals(("Service Provider"))) {
                Intent i = new Intent(WelcomePage.this, ServiceOptions.class);
                startActivity(i);
            } else if ((signUp.getAccountType()).equals("Service Provider")) {
                Intent intent = new Intent(WelcomePage.this, ServiceOptions.class);
                startActivity(intent);
            } else if ((signUp.getAccountType()).equals("Homeowner")) {
                Intent i = new Intent(WelcomePage.this, HomeownerOptions.class);
                startActivity(i);
            }

        }

        catch (Exception e){
            Intent intent = new Intent (WelcomePage.this, ServiceOptions.class);
            startActivity(intent);
        }

    }

}
